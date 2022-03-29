/*
 * OpenDSA Project Distributed under the MIT License
 * 
 * Copyright (c) 2011-2019 - Ville Karavirta and Cliff Shaffer
 * @author Ryan Gross
 * @author Seth Walter
 */

class AQueue<E> implements Queue<E> {

  // Keep this non-private for testing purposes!
  E queueArray[]; // Array holding queue elements
  
  private static final int defaultSize = 10;
  private int front; // Index of front element
  private int size; // Number of elements stored.

  // Constructors
  @SuppressWarnings("unchecked") // Generic array allocation
  AQueue(int capacity) {
    front = 0;
    size = 0;
    queueArray = (E[]) new Object[capacity];
  }
  

  AQueue() {
    this(defaultSize);
  }

  // Reinitialize
  @SuppressWarnings("unchecked")
  public void clear() {
    front = 0;
    size = 0;
    queueArray = (E[]) new Object[queueArray.length];
  }

  // Put "it" in queue
  @SuppressWarnings("unchecked")
  public boolean enqueue(E it)
  {
    // front + size % queueArray.length
    if (size != queueArray.length)
    { // not full
      int pos = (front + size) % queueArray.length;
      queueArray[pos] = it;
      size++;
      return true;
    }
    else
    {
      E tempArray[] = (E[]) new Object[size * 2];
      for (int i = 0; i < size; i++)
      {
        int pos = (front + size) % queueArray.length;
        tempArray[i] = queueArray[pos];
        if(front == queueArray.length -1) {
          front = 0;
        } else if(i == size -1) {
          front = 0;
        } else {
          front++;
        }
        
      }
      queueArray = tempArray;
      int pos = (front + size) % queueArray.length;
      queueArray[pos] = it;
      size++;
      return true;
    }
    // return false;
    
  }

  // Remove and return front value
  public E dequeue() {
    
    if(!isEmpty()) { // not empty
      E temp = queueArray[front];
      queueArray[front] = null;
      if(front == queueArray.length-1) {
        front = 0;
       
      }else {
   
        front++;
        
      }
      size--;
      return temp;
    }
   return null;
  }

  // Return front value
  public E frontValue() {
    return queueArray[front];
  }

  // Return queue size
  public int length() {
    return size;
  }
  
  //Check if the queue is empty
  public boolean isEmpty() {
    return size == 0;
  }
}

