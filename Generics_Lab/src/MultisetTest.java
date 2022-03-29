import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Testsuite for a Multiset collection.
 *
 * @author Michael S. Kirkpatrick, Nathan Sprague
 * @version V2, 8/2020
 */
public class MultisetTest {

  // --------------------------------------------
  // TESTS FOR ADDING AND SIZE METHODS
  // --------------------------------------------

  @Test
  public void testUniqueItemsSize() {
    Multiset<Integer> set = new Multiset<>();
    assertEquals(0, set.size());
    for (int i = 0; i < 10; i++) {
      assertTrue(set.add(i));
      assertEquals(i + 1, set.size());
    }
  }

  @Test
  public void testDuplicateSingletonSize() {
    Multiset<Integer> set = new Multiset<>();
    assertEquals(0, set.size());
    for (int i = 0; i < 50; i++) {
      assertTrue(set.add(42));
    }
    assertEquals(50, set.size());
  }

  @Test
  public void testDuplicateItemsSize() {
    Multiset<Integer> set = new Multiset<>();
    assertEquals(0, set.size());
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 5; j++) {
        assertTrue(set.add(i));
      }
      assertEquals(5 * (i + 1), set.size());
    }
    assertEquals(50, set.size());
  }

  @Test
  public void testTooManyItemsSize() {
    Multiset<Integer> set = new Multiset<>();
    assertEquals(0, set.size());
    for (int i = 0; i < 10; i++) {
      assertTrue(set.add(i));
    }
    assertEquals(10, set.size());
    for (int i = 10; i < 50; i++) {
      assertFalse(set.add(i));
    }
    assertEquals(10, set.size());
  }

  // --------------------------------------------
  // TESTS FOR CONTAINS
  // --------------------------------------------

  @Test
  public void testContainsSingleInstance() {
    Multiset<Integer> set = new Multiset<>();
    assertEquals(0, set.size());
    for (int i = 0; i < 10; i++) {
      assertTrue(set.add(i));
    }
    for (int i = 0; i < 10; i++) {
      assertTrue(set.contains(i));
    }
  }

  @Test
  public void testContainsDuplicates() {
    Multiset<Integer> set = new Multiset<>();
    assertEquals(0, set.size());
    for (int i = 0; i < 10; i++) {
      assertTrue(set.add(i));
      assertTrue(set.add(i));
    }
    for (int i = 0; i < 10; i++) {
      assertTrue(set.contains(i));
    }
  }

  @Test
  public void testContainsReturnsFalse() {
    Multiset<Integer> set = new Multiset<>();
    assertEquals(0, set.size());
    for (int i = 0; i < 10; i++) {
      assertTrue(set.add(i));
      assertTrue(set.add(i));
    }
    for (int i = 10; i < 20; i++) {
      assertFalse(set.contains(i));
    }
  }

  // --------------------------------------------
  // TESTS FOR REMOVE
  // --------------------------------------------

  @Test
  public void testRemoveSingleItem() {
    Multiset<Integer> set = new Multiset<>();
    assertEquals(0, set.size());

    assertTrue(set.add(1));
    assertTrue(set.contains(1));
    assertEquals(1, set.size());

    // Remove the item once (success)
    assertTrue(set.remove(1));
    assertFalse(set.contains(1));
    assertEquals(0, set.size());

    // Second remove should fail
    assertFalse(set.remove(1));
  }

  @Test
  public void testRemoveUniqueItems() {
    Multiset<Integer> set = new Multiset<>();
    assertEquals(0, set.size());

    // Insert 0..9
    for (int i = 0; i < 10; i++) {
      assertTrue(set.add(i));
      assertEquals(i + 1, set.size());
    }

    // Remove each item and confirm contains() and size() are correct
    for (int i = 0; i < 10; i++) {
      assertTrue(set.remove(i));
      assertEquals(10 - i - 1, set.size());
      for (int j = 0; j <= i; j++) {
        assertFalse(set.contains(j));
      }
      for (int j = i + 1; j < 10; j++) {
        assertTrue(set.contains(j));
      }
    }

    // Result should be an empty set
    assertEquals(0, set.size());
    for (int i = 0; i < 10; i++) {
      assertFalse(set.contains(i));
    }
  }

  @Test
  public void testRemoveDuplicateItems() {
    Multiset<Integer> set = new Multiset<>();
    assertEquals(0, set.size());

    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 5; j++) {
        assertTrue(set.add(i));
      }
      assertEquals(5 * (i + 1), set.size());
    }

    int size = 50;
    // First, remove the 4 extra copies of each item
    for (int k = 0; k < 4; k++) {
      for (int i = 0; i < 10; i++) {
        assertTrue(set.remove(i));
        size--;
        assertEquals(size, set.size());
        
        for (int j = 0; j < 10; j++) {
          assertTrue(set.contains(j));
        }
      }
    }
    // There should still be one copy of each
    for (int i = 0; i < 10; i++) {
      assertTrue(set.contains(i));
    }
    // Now remove the last copy of each
    for (int i = 0; i < 10; i++) {
      assertTrue(set.remove(i));
      size--;
      assertEquals(size, set.size());
      for (int j = 0; j <= i; j++) {
        assertFalse(set.contains(j));
      }
      for (int j = i + 1; j < 10; j++) {
        assertTrue(set.contains(j));
      }
    }
    // Set should now be empty
    assertEquals(0, set.size());
    for (int i = 0; i < 10; i++) {
      assertFalse(set.contains(i));
    }

  }

  // --------------------------------------------
  // TESTS FOR ADDING AND ITERATING
  // --------------------------------------------

  @Test
  public void testSingleItemIterator() {
    Multiset<Integer> set = new Multiset<>();
    set.add(42);

    int iterations = 0;
    for (Integer integer : set) {
      assertEquals(42, integer);
      iterations++;
    }
    assertEquals(1, iterations);
  }

  @Test
  public void testUniqueItemIterator() {
    Multiset<Integer> set = new Multiset<>();
    // Add 10 items (0..9)
    for (int i = 0; i < 10; i++) {
      assertTrue(set.add(i));
    }
    assertEquals(10, set.size());

    // Iterate through the set, confirming 0..9 are added once each
    int[] counters = new int[10];
    int iterations = 0;
    for (Integer integer : set) {
      assertTrue(integer >= 0 && integer < 10);
      counters[integer] += 1;
      iterations++;
    }
    assertEquals(10, iterations);
    for (int i = 0; i < 10; i++) {
      assertEquals(1, counters[i]);
    }
  }

  @Test
  public void testDuplicateItemIterator() {
    Multiset<Integer> set = new Multiset<>();
    // Add items (0..2) 1 through 3 times
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < i + 1; j++) {
        assertTrue(set.add(i));
      }
    }
    
    assertEquals(6, set.size());

    List<Integer> expected = Arrays.asList(0, 1, 1, 2, 2, 2);
    List<Integer> actual = new ArrayList<>();

    // Iterate through the set, confirming 0..9 are retrieved the appropriate number of times

    for (Integer integer : set) {
      actual.add(integer);
    }
   
    assertEquals(expected.size(), actual.size());
    assertTrue(expected.containsAll(actual));
    assertTrue(actual.containsAll(expected));

  }


}