import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Doubly-linked list class (UNFINISHED).
 * 
 * @author Ryan Gross
 * @author Seth Walter
 *
 */
public class DoubleList<E> implements Iterable<E>
{

  private Link<E> head; // Pointer to list header
  private Link<E> tail; // Pointer to last node
  private int listSize; // Size of list

  /**
   * Create an empty LList.
   */
  DoubleList()
  {
    clear();
  }

  /**
   * Remove all elements.
   */
  public void clear()
  {
    tail = new Link<E>(null, null); // Create trailer
    head = new Link<E>(null, tail); // Create header
    tail.setPrev(head);
    listSize = 0;
  }

  /**
   * Append item to the end of the list.
   */
  public void append(E item)
  {
    Link<E> newLink = new Link<>(item, tail.prev(), tail);
    tail.prev().setNext(newLink);
    tail.setPrev(newLink);
    listSize++;
  }

  /**
   * Return the element at the provided index. This method will iterate from the head or the tail
   * depending on which will require fewer steps.
   */
  public E get(int pos)
  {
    if (pos < 0 || pos >= listSize)
    {
      throw new IndexOutOfBoundsException();
    }

    if (pos < listSize / 2)
    {
      return forward(pos).element();
    }
    else
    {
      return backward(pos).element();
    }
  }

  /**
   * Helper method for iterating forward from the head.
   */
  private Link<E> forward(int pos)
  {
    Link<E> current = head.next();
    for (int i = 0; i < pos; i++)
    {
      current = current.next();
    }
    return current;
  }

  /**
   * Helper method for iterating backward from the tail.
   */
  private Link<E> backward(int pos)
  {
    Link<E> current = tail.prev();
    for (int i = 0; i < (listSize - 1) - pos; i++)
    {
      current = current.prev();
    }
    return current;
  }

  /**
   * Return the number of elements stored in the list.
   */
  public int size()
  {
    return listSize;
  }

  /**
   * Iterates forward through the list. Remove operation is supported.
   */
  @Override
  public Iterator<E> iterator()
  {
    return new DoubleIterator();
  }

  private class DoubleIterator implements Iterator<E>
  {

    Link<E> curr = head;

    @Override
    public boolean hasNext()
    {

      return curr.next() != null && curr != tail.prev();
    }

    @Override
    public E next()
    {

      if (hasNext())
      {
        curr = curr.next();
      }
      else
      {
        throw new NoSuchElementException();
      }
      return curr.element();
    }

    @Override
    public void remove()
    {
      if (!curr.equals(head))
      {
        if (hasNext())
        {
          curr.prev().setNext(curr.next()); // currents previous pointer's next is set to currents
                                            // next
          curr.next().setPrev(curr.prev()); // currents next pointer previous pointer is set to
                                            // currents previous
          listSize--;
        }
        else
        {
          listSize--;
        }
      }
      else
      {
        throw new IllegalStateException();
      }
    }

  }

  /**
   * Add the item at the specified index.
   */
  public void add(int index, E item)
  {

    if (index == 0)
    {
      Link<E> newLink = new Link<>(item, head, head.next());
      head.next().setPrev(newLink);
      head.setNext(newLink);
      listSize++;
    }
    else if (index == size() - 1)
    {
      append(item);

    }
    else
    {
      Link<E> input = new Link<E>(item, forward(index).prev(), backward(index).next());

      forward(index).prev().setNext(input);
      backward(index).next().setPrev(input);
      listSize++;
    }

  }

  /**
   * Remove and return the item at the specified index.
   */
  public E remove(int index)
  {

    Link<E> temp = null;
    if (index == 0)
    {

      head.setNext(forward(index).next());
      forward(index).next().setPrev(head);
      temp = forward(index);
      listSize--;

    }
    else if (index == size() - 1)
    {
      temp = backward(index);
      backward(index).prev().setNext(tail);
      tail.setPrev(backward(index).prev());
      listSize--;

    }
    else
    {
      forward(index).prev().setNext(backward(index).next());
      backward(index).next().setPrev(forward(index).prev());
      temp = forward(index);
      listSize--;

    }

    return temp.element();
  }

  /**
   * Reverse the list (in place)
   */
  public void reverse()
  {

    Link<E> temp;
    temp = head;

    head = tail;
    tail = temp;
    head.setNext(forward(0));
    tail.setPrev(backward(size() - 1));

  }

}
