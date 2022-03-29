import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class AbstractSortTest {

  protected Sorter<Integer> sorter;

  /**
   * Generate a random sequence of integers to sort. This takes a seed for the random number
   * generator, so it will always produce the same sequence if the same key is provided.
   * 
   */
  protected Integer[] randomSequence(long seed) {
    Random gen = new Random(seed);
    int size = gen.nextInt(100) + 1;
    Integer[] numbers = new Integer[size];
    for (int i = 0; i < size; i++) {
      numbers[i] = gen.nextInt(size / 2 + 1); // Should be plenty of
                                              // repeats.
      numbers[i] = numbers[i] * 1000 - 500; // important for stability
                                            // tests.
    }
    return numbers;
  }

  /**
   * Helper method to check that a sorting algorithm places the provided keys in the correct order.
   */
  protected void checkSortOrdering(Integer[] numbers, Sorter<Integer> sorter) {

    Integer[] copy = Arrays.copyOf(numbers, numbers.length);
    Arrays.sort(copy);
    sorter.sort(numbers);
    for (int i = 0; i < numbers.length; i++) {
      assertEquals(copy[i], numbers[i]);
    }


  }

  @Test
  public void test50RandomSequences() {
    Integer[] curSequence;
    for (int i = 0; i < 50; i++) {
      curSequence = randomSequence(i);
      checkSortOrdering(curSequence, sorter);
    }
  }

  @Test
  public void testLengthZero() {
    Integer[] curSequence = new Integer[0];
    sorter.sort(curSequence);
  }

  @Test
  public void testLengthOne() {
    Integer[] curSequence = new Integer[1];
    curSequence[0] = 101;
    sorter.sort(curSequence);
    assertEquals(Integer.valueOf(101), curSequence[0]);
  }

  @Test
  public void testOrderedArrays() {

    for (int size = 1; size < 20; size++) {
      Integer[] numbers = new Integer[size];
      for (int i = 0; i < size; i++) {
        numbers[i] = i;
      }
      sorter.sort(numbers);
      for (int i = 0; i < size; i++) {
        assertEquals("There is a defect in at least one sort.", Integer.valueOf(i), numbers[i]);
      }
    }

  }

  @Test
  public void testReverseOrderedArrays() {

    for (int size = 1; size < 20; size++) {
      Integer[] numbers = new Integer[size];
      for (int i = 0; i < size; i++) {
        numbers[i] = -i;
      }

      sorter.sort(numbers);
      for (int i = 0; i < size; i++) {
        assertEquals("There is a defect in at least one sort.", Integer.valueOf(i - size + 1),
            numbers[i]);
      }
    }

  }

  @Test
  public void testAllDuplicates() {

    for (int size = 1; size < 20; size++) {
      Integer[] numbers = new Integer[size];
      for (int i = 0; i < size; i++) {
        numbers[i] = 101;
      }
      sorter.sort(numbers);
      for (int i = 0; i < size; i++) {
        assertEquals("There is a defect in at least one sort.", Integer.valueOf(101), numbers[i]);
      }
    }
  }
}
