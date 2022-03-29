import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;


/**
 * Test for the dynamic array lab. These tests aren't comprehensive. They are only designed to
 * ensure that array resizing and iteration are handled correctly.
 * 
 * @author Nathan Sprague
 * @version V1.2, 9/9/2020
 *
 */
class AListTest {


  /**
   * This method is a hack that allows us grab the length of the array for the purposes of testing.
   * 
   * @param list - An AList object
   * @return The length of the underlying array
   */
  @SuppressWarnings("rawtypes")
  private static int getArraySize(AList list) {
    return ((Object[]) list.listArray).length;
  }

  // -------------------------
  // TEST METHODS FOR APPPEND
  // -------------------------
  @Test
  public void testAppendNoResizeNeeded() {
    AList<String> list = new AList<>(2);
    list.append("A");
    list.append("B");

    assertEquals(0, list.currPos());
    assertEquals(2, list.length());

    assertEquals("A", list.getValue());
    list.moveToPos(1);
    assertEquals("B", list.getValue());

    assertEquals(2, getArraySize(list));

  }

  @Test
  public void testAppendOneResizeNeeded() throws IllegalArgumentException, IllegalAccessException,
      NoSuchFieldException, SecurityException {
    AList<String> list = new AList<>(2);
    list.append("A");
    list.append("B");
    list.append("C");

    assertEquals(0, list.currPos());
    assertEquals(3, list.length());

    assertEquals("A", list.getValue());
    list.moveToPos(1);
    assertEquals("B", list.getValue());
    list.moveToPos(2);
    assertEquals("C", list.getValue());

    assertEquals(4, getArraySize(list));
  }

  @Test
  public void testAppenTwoResizesNeeded() throws IllegalArgumentException, IllegalAccessException,
      NoSuchFieldException, SecurityException {
    AList<String> list = new AList<>(3);
    for (int i = 0; i < 7; i++) {
      list.append("A");
    }

    assertEquals(0, list.currPos());
    assertEquals(7, list.length());

    for (list.moveToStart(); !list.isAtEnd(); list.next()) {
      assertEquals("A", list.getValue());
    }

    assertEquals(12, getArraySize(list));
  }

  // -------------------------
  // TEST METHODS FOR INSERT
  // -------------------------

  @Test
  public void testInsertNoResizeNeeded() throws IllegalArgumentException, IllegalAccessException,
      NoSuchFieldException, SecurityException {
    AList<String> list = new AList<>(2);
    list.insert("A");
    list.insert("B");

    assertEquals(0, list.currPos());
    assertEquals(2, list.length());

    assertEquals("B", list.getValue());
    list.moveToPos(1);
    assertEquals("A", list.getValue());

    assertEquals(2, getArraySize(list));


  }

  @Test
  public void testInsertOneResizeNeeded() throws IllegalArgumentException, IllegalAccessException,
      NoSuchFieldException, SecurityException {
    AList<String> list = new AList<>(2);
    list.insert("A");
    list.insert("B");
    list.insert("C");

    assertEquals(0, list.currPos());
    assertEquals(3, list.length());

    assertEquals("C", list.getValue());
    list.moveToPos(1);
    assertEquals("B", list.getValue());
    list.moveToPos(2);
    assertEquals("A", list.getValue());

    assertEquals(4, getArraySize(list));
  }

  @Test
  public void testInsertTwoResizesNeeded() throws IllegalArgumentException, IllegalAccessException,
      NoSuchFieldException, SecurityException {
    AList<String> list = new AList<>(3);
    for (int i = 0; i < 7; i++) {
      list.insert("A");
    }

    assertEquals(0, list.currPos());
    assertEquals(7, list.length());

    for (list.moveToStart(); !list.isAtEnd(); list.next()) {
      assertEquals("A", list.getValue());
    }

    assertEquals(12, getArraySize(list));
  }


  // -------------------------
  // TEST METHODS FOR ITERATOR NEXT AND HASNEXT
  // -------------------------
  @Test
  public void testIteratorEmptyList() {
    AList<String> list = new AList<>(3);
    Iterator<String> it = list.iterator();
    assertFalse(it.hasNext());
    assertThrows(NoSuchElementException.class, () -> it.next());
  }

  @Test
  public void testIteratorSeveralItems() {
    AList<String> list = new AList<>(3);
    list.append("A");
    list.append("B");
    list.append("C");

    list.moveToPos(2); // iteration should not change position.

    Iterator<String> it = list.iterator();

    assertTrue(it.hasNext());
    assertTrue(it.hasNext());

    assertEquals("A", it.next());
    assertEquals("B", it.next());

    assertTrue(it.hasNext());
    assertEquals("C", it.next());

    assertFalse(it.hasNext());

    assertThrows(NoSuchElementException.class, () -> it.next());

    assertEquals(2, list.currPos());

  }

  // -------------------------
  // TEST METHODS FOR ITERATOR REMOVE
  // -------------------------


  @Test
  public void testRemoveBeforeNextCalled() {
    AList<String> list = new AList<>(3);
    list.append("A");

    Iterator<String> it = list.iterator();

    assertThrows(IllegalStateException.class, () -> it.remove());
  }

  @Test
  public void testRemoveCalledTwiceForOneNext() {
    AList<String> list = new AList<>(3);
    list.append("A");
    list.append("B");

    Iterator<String> it = list.iterator();
    it.next();

    it.remove();

    assertThrows(IllegalStateException.class, () -> it.remove());
  }

  @Test
  public void testIteratorRemoveAll() {
    AList<String> list = new AList<>(3);
    list.append("A");
    list.append("B");
    list.append("C");
    list.append("D");

    Iterator<String> it = list.iterator();
    for (int i = 0; i < 4; i++) {
      it.next();
      it.remove();
    }
    assertEquals(0, list.length());
    assertEquals(0, list.currPos());

  }

  // -------------------------
  // TESTS THAT ITERATOR REMOVE UPDATES POSITION CORRECTLY
  // -------------------------


  @Test
  public void testIteratorRemoveBeforeCurrUpdatesCurr() {
    AList<String> list = new AList<>(3);
    list.append("A");
    list.append("B");
    list.append("C");

    list.moveToPos(2);

    Iterator<String> it = list.iterator();
    it.next();
    it.remove();

    assertEquals("C", list.getValue());
    assertEquals(1, list.currPos());
  }

  @Test
  public void testIteratorRemoveAfterCurrDoesntUpdateCurr() {
    AList<String> list = new AList<>(3);
    list.append("A");
    list.append("B");
    list.append("C");

    list.moveToPos(1);

    Iterator<String> it = list.iterator();
    it.next();
    it.next();
    it.next();
    it.remove();

    assertEquals("B", list.getValue());
    assertEquals(1, list.currPos());
  }

  @Test
  public void testIteratorRemoveAtPositionDoesntUpdatePosition() {
    AList<String> list = new AList<>(3);
    list.append("A");
    list.append("B");
    list.append("C");

    list.moveToPos(1);

    Iterator<String> it = list.iterator();
    it.next();
    it.next();
    it.remove();

    assertEquals("C", list.getValue());
    assertEquals(1, list.currPos());
  }

  @Test
  public void testIteratorRemove() {
    AList<String> list = new AList<>(4);
    //- pos 0
    list.append("A");
  //- pos 1
    list.append("B");
  //- pos 2
    list.append("C");
  //- pos 3
    list.append("D");
  //- pos 4

    list.moveToPos(1);

    Iterator<String> it = list.iterator();
    // remove the first and the last
    it.next();
    it.remove();
    it.next();
    it.next();
    it.next();
    it.remove();

    assertEquals(2, list.length());
    list.moveToPos(0);
    assertEquals("B", list.getValue());
    list.moveToPos(1);
    assertEquals("C", list.getValue());

    String result = "";

    for (String str : list) {
      result += str;
    }

    assertEquals("BC", result);
  }



}
