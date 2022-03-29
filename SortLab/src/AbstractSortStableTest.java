import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class AbstractSortStableTest extends AbstractSortTest {

  protected void checkSortStability(Integer[] numbers, Sorter<Integer> sorter) {
    try {
      Integer[] copy = Arrays.copyOf(numbers, numbers.length);
      Arrays.sort(copy);
      sorter.sort(numbers);
      for (int i = 0; i < numbers.length; i++) {
        assertTrue("There is a defect in at least one sort.", copy[i] == numbers[i]);
      }
    } catch (Throwable e) {
      fail("There is a defect in at least one sort.");
    }
  }

  @Test
  public void testStabilityRandomSequences() {
    Integer[] curSequence;
    for (int i = 0; i < 50; i++) {
      curSequence = randomSequence(i);
      checkSortStability(curSequence, sorter);
    }
  }

  @Test
  public void testStabilityAllEntriesEqual() {
    for (int size = 1; size < 20; size++) {
      Integer[] numbers = new Integer[size];
      for (int i = 0; i < size; i++) {
        numbers[i] = 10100021;
      }
      checkSortStability(numbers, sorter);
    }
  }

}
