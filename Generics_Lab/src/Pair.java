/**
 * Mutable 2-tuple type.
 * 
 * @author Nathan Sprague and Michael S. Kirkpatrick
 * @version V3, 3/2020
 */
public class Pair<T,T1> {

  private T first;
  private T1 second;

  /**
   * Create an Pair with the provided objects.
   * 
   * @param first The first object.
   * @param second The second object.
   */
  public Pair(T first, T1 second) {
    this.first = first;
    this.second = second;
  }

  public T getFirst() {
    return first;
  }

  public void setFirst(T first) {
    this.first = first;
  }

  public T1 getSecond() {
    return second;
  }

  public void setSecond(T1 second) {
    this.second = second;
  }

  @Override
  public String toString() {
    return "<" + first.toString() + ", " + second.toString() + ">";
  }

}