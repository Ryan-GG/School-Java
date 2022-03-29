import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterable collection of a set with repeated objects
 *
 * @author Michael S. Kirkpatrick and Nathan Sprague
 * @version V2, 8/2020
 */
public class Multiset<E> implements Iterable<E>
{

  private final int maximumSize = 10;

  // TODO: Parameterize the array so that one element of each Pair is
  // an element and the second is the number of times it has been added.
  private Pair<E, Integer>[] items;

  // TODO: Add additional fields to keep track of the first spot to add
  // a new item, the current size of the set, and any other fields that
  // are helpful.
  private int currSize;
  private int uniquePairCounter;
  //wants a variable as a counter for unique pairs

  /**
   * Create a collection that will store items long with a counter.
   */
  public Multiset()
  {
    items = new Pair[maximumSize];
    currSize = 0;
    uniquePairCounter = 0;
    // TODO: Initialize the other fields as needed
  }

  /**
   * Private helper method for getting the index where an item is stored in the array. This will be
   * helpful for several of the methods below.
   * 
   * @param item
   *          The item to search for
   * @return The index, or -1 if it isn't in the array
   */
  private int find(Object item)
  {
    for (int i = 0; i < maximumSize; i++)
    {
      if(items[i] != null) {
        if (item.equals(items[i].getFirst()))
        {
          return i;
        }
      }
    }
    return -1;
  }

  /**
   * Insert an object into the collection if there's space.
   *
   * @param object
   *          The object to insert.
   *
   * @return true if the object was successfully added.
   */
  public boolean add(E item)
  {
    // TODO: If the object has already been added, increment that Pair's
    // counter. Otherwise, insert a new Pair if there is space available.
    



    for (int i = 0; i < maximumSize; i++)
    {

      if (items[i] != null)
      {
        if ((item.equals(items[i].getFirst()))) // check if the same 
        {
          items[i].setSecond(items[i].getSecond() + 1);
          currSize++;
          return true;
        } 
      } else { //if the spot is null add it there
        items[i] = new  Pair<E, Integer>(item, 1);
        uniquePairCounter++;
        currSize++;
        return true;
      }

    }

    return false;
  }

  /**
   * Check if an object exists in the collection.
   *
   * @param object
   *          The object to search for.
   *
   * @return true if the object has been added previously.
   */
  public boolean contains(Object item)
  {
    // TODO: Search through the items array to determine if the object
    // has been added at least once.
    if(find(item)> -1) {
      return true;
    }
    /*
    for(int i = 0; i < currSize; i++) {
      if(item == null) return false;
      if(item != null && item == items[i].getFirst()) return true;
    }
    */
    return false;
  }

  /**
   * Remove an instance of an object if it exists.
   *
   * @param object
   *          The object to remove.
   *
   * @return true if an element was removed.
   */
  public boolean remove(Object object)
  {
    // TODO: Remove one instance of the object (if it exists) by
    // decrementing the Pair's counter. If the result is a counter of
    // 0, remove that Pair. HINT: Always keep the array so that indexes
    // 0 through some value N (< 10) has a valid Pair. E.g., if the set
    // contains "A", "B", and "C", then items[0] through items[2] are
    // valid. If a Pair is removed from index M, then copy items[M+1]
    // into items[M], items[M+2] into items[M+1], etc.
    
    for (int i = 0; i < maximumSize; i++)
    {
      if (items[i] != null)
      {
        if ((object.equals(items[i].getFirst())))
        {
          currSize--;
          if (items[i].getSecond() - 1 == 0)
          {
            uniquePairCounter--;
            items[i] = null;
            for (int x = i; x < maximumSize - 1; x++)
            {
              items[x] = items[x + 1];
            }
            return true;
          }
          else
          {
            items[i].setSecond(items[i].getSecond() - 1);
            return true;
          }

        }
      }
    }
    

   
    return false;
  }

  /**
   * Get the current count of objects that have been added.
   */
  public int size()
  {
    // TODO: Return the total number of object instances. This can
    // exceed the maximum size of the array if items are added repeatedly.
    return currSize;


  }
  


  /**
   * Creates an Iterator for use in a for-loop. Implement an Iterator here based on the API
   * documentation at:
   * https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Iterator.html Throw the
   * exceptions as specified in the API.
   */
  @Override
  public Iterator<E> iterator()
  {

    return new Iterator<E>()
    {

      // TODO: Declare members needed to keep track of the Iterator state.
      // HINTS:
      // * You can access the items[] array from the containing class
      // directly.
      //
      // * You'll need at least two instance variables: one to keep track of which is the current
      // item, and one to keep track of how many times that item has been visited so far.
      int pointer = 0;
      int instanceCounter = 0;
      int index = 0;

      /**
       * Return a Boolean indicating whether more items are left.
       */
      @Override
      public boolean hasNext()
      {

        if (pointer < uniquePairCounter-1 && index != uniquePairCounter)
        {
          return true;
        }
        
        return false;
      }

      /**
       * Return the next object in the iterator.
       */
      @Override
      @SuppressWarnings("unchecked")
      public E next()
      {

        
          if(instanceCounter == items[pointer].getSecond()-1) {
            
            pointer = 0;
            instanceCounter = 0;
            //index++;
            /*
              if(index  == uniquePairCounter) {
                return items[index-1].getFirst();
              }
              */
              return items[index++].getFirst();
           // throw new NoSuchElementException();
          } else{
                pointer = index;
              instanceCounter++;
          }
          
        
        return items[pointer].getFirst();
        
        
      }

      /**
       * Remove the previous Pair returned by next() from the array.
       */
      @Override
      public void remove()
      {
        throw new UnsupportedOperationException();
      }
    };

  }

}
