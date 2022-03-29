import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class RecursionTest {

  // --------------------------------------------
  // TESTS FOR N QUEENS
  // --------------------------------------------

  /**
   * Test for placing 0 queens on a board of size 8.
   */
  @Test
  public void testNoQueens() {
    BacktrackingQueens queens = new BacktrackingQueens(8);
    assertTrue(queens.placeQueens(8), "Placing no queens should be successful");

    int[] places = queens.getQueens();
    for (int i = 0; i < 8; i++) {
      assertEquals(-1, places[i], "All places should be -1 for empty board");
    }
  }

  /**
   * Test for placing 1 queen on a board of size 8.
   */
  @Test
  public void testOneQueen() {
    BacktrackingQueens queens = new BacktrackingQueens(8);
    assertTrue(queens.placeQueens(7), "Placing no queens should be successful");

    int[] places = queens.getQueens();
    assertEquals(0, places[7], "First queen should be in position 0");
    for (int i = 0; i < 7; i++) {
      assertEquals(-1, places[i], "All places should be -1 for empty board");
    }
  }

  /**
   * Test for placing 4 queens on a board of size 8.
   */
  @Test
  public void testFourQueen() {
    BacktrackingQueens queens = new BacktrackingQueens(8);
    assertTrue(queens.placeQueens(4), "Placing some queens should be successful");

    int[] expected = { -1, -1, -1, -1, 0, 2, 4, 1};
    int[] places = queens.getQueens();
    for (int i = 0; i < 8; i++) {
      assertEquals(expected[i], places[i], "Partial solution placement is not correct");
    }
  }

  /**
   * Test for placing 8 queens on a board of size 8.
   */
  @Test
  public void testAllQueen() {
    BacktrackingQueens queens = new BacktrackingQueens(8);
    assertTrue(queens.placeQueens(0), "Placing all queens should be successful");

    int[] expected = { 0, 4, 7, 5, 2, 6, 1, 3 };
    int[] places = queens.getQueens();
    for (int i = 0; i < 8; i++) {
      assertEquals(expected[i], places[i], "Full solution placement is not correct");
    }
  }

  // --------------------------------------------
  // TESTS FOR DYNAMIC PROGRAMMING FIBONACCI
  // --------------------------------------------

  /**
   * Test for Fib(0) = 0.
   */
  @Test
  public void testFibZero() {
    DynamicFibonacci fib = new DynamicFibonacci();
    assertEquals(BigInteger.ZERO, fib.computeHelper(0), "Base case for Fib(0) failed");
  }

  /**
   * Test for Fib(1) = 1.
   */
  @Test
  public void testFibOne() {
    DynamicFibonacci fib = new DynamicFibonacci();
    assertEquals(BigInteger.ONE, fib.computeHelper(1), "Base case for Fib(1) failed");
  }

  /**
   * Test for Fib(10) = 55.
   */
  @Test
  public void testFibTen() {
    DynamicFibonacci fib = new DynamicFibonacci();
    assertEquals(new BigInteger("55"), fib.compute(10), "Computation of Fib(10) failed");
  }

  /**
   * Test for Fib(50) = 12586269025.
   */
  @Test
  public void testFibFifty() {
    DynamicFibonacci fib = new DynamicFibonacci();
    assertEquals(new BigInteger("12586269025"), fib.compute(50), "Computation of Fib(50) failed");
  }

  /**
   * Test for Fib(1000) = 12586269025.
   */
  @Test
  public void testFibDynamic() {
    DynamicFibonacci fib = new DynamicFibonacci();
    assertEquals(new BigInteger("43466557686937456435688527675040625802564660517371780402481729089536555417949051890403879840079255169295922593080322634775209689623239873322471161642996440906533187938298969649928516003704476137795166849228875"), fib.compute(1000), "Computation of Fib(1000) failed");
  }

  // --------------------------------------------
  // TESTS FOR BACKTRACKING SUBSET SUM
  // --------------------------------------------

  /**
   * Helper routine for creating a list.
   */
  private List<Integer> getList() {
    List<Integer> items = new ArrayList<>();
    items.add(8);
    items.add(6);
    items.add(7);
    items.add(5);
    items.add(3);
    items.add(9);
    return items;
  }

  /**
   * Test for a sum of 0.
   */
  @Test
  public void testBackSumZero() {
    List<Integer> items = getList();
    BacktrackingSubsetSum back = new BacktrackingSubsetSum(items);
    assertTrue(back.subsetSumHelper(items, 0), "Base case for sum 0 failed");
  }

  /**
   * Test for a sum of -1.
   */
  @Test
  public void testBackSumNegative() {
    List<Integer> items = getList();
    BacktrackingSubsetSum back = new BacktrackingSubsetSum(items);
    assertFalse(back.subsetSumHelper(items, -1), "Base case for sum -1 should fail");
  }

  /**
   * Test for a sum with empty set.
   */
  @Test
  public void testBackSumEmptySet() {
    List<Integer> items = new ArrayList<>();
    BacktrackingSubsetSum back = new BacktrackingSubsetSum(items);
    assertFalse(back.subsetSumHelper(items, 1), "Base case for empty set should fail");
  }

  /**
   * Test for a sum in the set.
   */
  @Test
  public void testBackSumEachItem() {
    List<Integer> items = getList();
    for (Integer i : items) {
      List<Integer> subset = getList();
      BacktrackingSubsetSum back = new BacktrackingSubsetSum(items);
      assertTrue(back.subsetSumHelper(subset, i), "Should be able to find each item as a sum");
    }
  }

  /**
   * Test for of all values.
   */
  @Test
  public void testBackSumItems() {
    List<Integer> items = getList();
    int sum = 0;
    for (Integer i : items) {
      sum += i;
    }
    BacktrackingSubsetSum back = new BacktrackingSubsetSum(items);
    assertTrue(back.subsetSumHelper(items, sum), "Should be able to find total as a sum");
  }


  /**
   * Test for repeated subset sum calculations.
   */
  @Test
  public void testFundSum() {
    List<Integer> items = getList();
    BacktrackingSubsetSum back = new BacktrackingSubsetSum(items);
    assertTrue(back.findSum(21), "Should be able to find 21 as a sum of 8+6+7");
    assertTrue(back.findSum(15), "Should be able to find 15 as a sum of 7+5+3 and 8+7 and 6+9");
  }

  /**
   * Test for repeated subset sum calculations.
   */
  @Test
  public void testFundSumFails() {
    List<Integer> items = getList();
    BacktrackingSubsetSum back = new BacktrackingSubsetSum(items);
    assertFalse(back.findSum(50), "Should not be able to find sum larger than total");
    assertFalse(back.findSum(37), "Should not be able to find one less than total");
    assertFalse(back.findSum(2), "Should not be able to find one smaller than minimum");
  }

  // --------------------------------------------
  // TESTS FOR DYNAMIC PROGRAMMING SUBSET SUM
  // --------------------------------------------

  /**
   * Test for a row of -1.
   */
  @Test
  public void testDynamicSumNegative() {
    List<Integer> items = getList();
    DynamicSubsetSum dyn = new DynamicSubsetSum(items);
    boolean[][] memo = new boolean[1][1];
    dyn.fillHelper(memo, -1);
    assertFalse(memo[0][0], "Base case for row -1 should not change anything");
  }

  /**
   * Test for last row with value 8.
   */
  @Test
  public void testDynamicLastRow() {
    List<Integer> items = getList();
    DynamicSubsetSum dyn = new DynamicSubsetSum(items);
    boolean[][] memo = new boolean[2][13];
    memo[1][0] = true;
    memo[1][2] = true;
    memo[1][4] = true;
    memo[1][6] = true;
    dyn.fillHelper(memo, 0);
    for (int i = 0; i < 13; i++) {
      if ((i % 2) == 0) {
        assertTrue(memo[0][i], "Even values should all be true");
      } else {
        assertFalse(memo[0][i], "Odd values should all be false");
      }
    }
   
  }

  /**
   * Test for a sum of 0.
   */
  @Test
  public void testDynamicSumZero() {
    List<Integer> items = getList();
    DynamicSubsetSum dyn = new DynamicSubsetSum(items);
    assertTrue(dyn.fillTable(0), "Base case for sum 0 failed");
  }

  /**
   * Test for a sum in the set.
   */
  @Test
  public void testDynamicSumEachItem() {
    List<Integer> items = getList();
    for (Integer i : items) {
      List<Integer> subset = getList();
      DynamicSubsetSum dyn = new DynamicSubsetSum(items);
      assertTrue(dyn.fillTable(i), "Should be able to find each item as a sum");
    }
  }

  /**
   * Test for of all values.
   */
  @Test
  public void testDynamicSumItems() {
    List<Integer> items = getList();
    int sum = 0;
    for (Integer i : items) {
      sum += i;
    }
    DynamicSubsetSum dyn = new DynamicSubsetSum(items);
    assertTrue(dyn.fillTable(sum), "Should be able to find total as a sum");
  }


  /**
   * Test for repeated subset sum calculations.
   */
  @Test
  public void testFillTable() {
    List<Integer> items = getList();
    DynamicSubsetSum dyn = new DynamicSubsetSum(items);
    assertTrue(dyn.fillTable(21), "Should be able to find 21 as a sum of 8+6+7");
    assertTrue(dyn.fillTable(15), "Should be able to find 15 as a sum of 7+5+3 and 8+7 and 6+9");
  }

  /**
   * Test for repeated subset sum calculations.
   */
  @Test
  public void testFillTableFails() {
    List<Integer> items = getList();
    DynamicSubsetSum dyn = new DynamicSubsetSum(items);
    assertFalse(dyn.fillTable(50), "Should not be able to find sum larger than total");
    assertFalse(dyn.fillTable(37), "Should not be able to find one less than total");
    assertFalse(dyn.fillTable(2), "Should not be able to find one smaller than minimum");
  }

}
