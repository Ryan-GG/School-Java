import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Array-based List implementation
 * 
 * @author OpenDSA Textbook
 *
 * @param <E> - Element type to store.
 */

/*
 * OpenDSA Project Distributed under the MIT License
 * 
 * Copyright (c) 2011-2016 - Ville Karavirta and Cliff Shaffer
 */

class AList<E> implements List<E> {

  protected E[] listArray; // Array holding list elements
  // Protected instead of private to facilitate testing/grading.

  private static final int defaultSize = 10; // Default size
  private int listSize; // Current # of list items
  private int curr; // Position of current element


  /**
   * Create a new list object with maximum size "size".
   * 
   * @param size Initial array size.
   */
  @SuppressWarnings("unchecked") // Generic array allocation
  public AList(int size) {
    listSize = curr = 0;
    listArray = (E[]) new Object[size];
  }

  /**
   * Create a list with the default capacity.
   */
  public AList() {
    this(defaultSize); // Just call the other constructor
  }

  /**
   * Reinitialize the list.
   */
  public void clear() {
    listSize = curr = 0;
  }

  /**
   * Insert item at current position.
   * 
   * @param it The item to insert
   */
  public boolean insert(E it) {
    if (listSize >= listArray.length) {
      listArray = sizingArray();
    }
    for (int i = listSize; i > curr; i--) { // Shift elements up
      listArray[i] = listArray[i - 1]; // to make room
    }
    listArray[curr] = it;
    listSize++; // Increment list size
    return true;
  }

  
  public E[] sizingArray() {
    @SuppressWarnings("unchecked")
    E[] tempArray = (E[]) new Object [listArray.length*2];
    
    for(int i=0; i < listArray.length; i++) {
      
      tempArray[i] = listArray[i];
    }
    
    return tempArray;
  }
  
  /**
   * Append item to list.
   * 
   * @param it The item to append
   */
  public boolean append(E it) {
    if (listSize >= listArray.length) {
      listArray = sizingArray();
    }
    listArray[listSize++] = it;
    return true;
  }

  /**
   * Remove and return the current element.
   */
  public E remove() {
    if ((curr < 0) || (curr >= listSize)) { // No current element
      return null;
    }

    E it = listArray[curr]; // Copy the element
    for (int i = curr; i < listSize - 1; i++) { // Shift them down
      listArray[i] = listArray[i + 1];
    }
    listSize--;
    return it;
  }

  /**
   * Set position to front.
   */
  public void moveToStart() {
    curr = 0;
  }

  /**
   * Set position to end.
   */
  public void moveToEnd() {
    curr = listSize;
  }

  /**
   * Move position left.
   */
  public void prev() {
    if (curr != 0) {
      curr--;
    }
  }

  /**
   * Move position right.
   */
  public void next() {
    if (curr < listSize) {
      curr++;
    }
  }

  /**
   * Return the list size.
   */
  public int length() {
    return listSize;
  }

  /**
   * Return the current position.
   */
  public int currPos() {
    return curr;
  }

  /**
   * Set the current position to the specified value.
   * 
   * @return false if the position is invalid.
   */
  public boolean moveToPos(int pos) {
    if ((pos < 0) || (pos > listSize)) {
      return false;
    }
    curr = pos;
    return true;
  }


  /**
   * Return true if the position is at the end of the list.
   */
  public boolean isAtEnd() {
    return curr == listSize;
  }

  /**
   * Return the element at the current position.
   */
  public E getValue() {
    if ((curr < 0) || (curr >= listSize)) { // No current element
      return null;
    }
    return listArray[curr];
  }

  @Override
  public Iterator<E> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<E> {

    
    private int pointer = 0;
    private int nextCounter = 0;
    @Override
    public boolean hasNext() {

      
      return pointer < listSize && listArray[pointer] != null;
    }

    @Override
    public E next() {

      nextCounter++;
      if(hasNext()) {
        return listArray[pointer++];

      } else {
        throw new NoSuchElementException("");
      }
   
    }

    @Override
    public void remove() {

      if (nextCounter >= 1)
      {
        if (pointer < curr)
        {
          curr--;
          pointer--;
          if ((pointer < 0) || (pointer >= listSize))
          { 
            return;
          }
          for (int i = pointer; i < listSize - 1; i++)
          { 
            listArray[i] = listArray[i + 1];
          }
          listSize--;
          nextCounter = 0;
        }
        else
        {
          pointer--;
          if ((pointer < 0) || (pointer >= listSize))
          { 
            return;
          }
          for (int i = pointer; i < listSize - 1; i++)
          { 
            listArray[i] = listArray[i + 1];
          }
          listSize--;
          nextCounter = 0;
        }
      } else {
        throw new IllegalStateException(); 
         
      }
    }
  }


}

