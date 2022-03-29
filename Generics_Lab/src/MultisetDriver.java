import java.util.Iterator;
/**
 * 
 * Simple demo code for the Multiset iterator.
 *
 */
public class MultisetDriver {

  public static void main(String[] args) {

    // Create a multiset and add 0..4 two times each
    Multiset<Integer> set = new Multiset<>();
    for (int i = 0; i < 5; i++) {
      set.add(i);
      set.add(i);
    }

    System.out.println("Size is " + set.size());

    System.out.println(
        "\nPrinting using iterator methods directly.  Should see each element printed twice.");

    // Loop through each item in the multiset and print it
    Iterator<Integer> iter = set.iterator();
    while (iter.hasNext()) {
      Integer next = iter.next();
      System.out.println("Item " + next);
    }
    
    // Add one more of each
    for (int i = 0; i < 5; i++) {
      set.add(i);
    }
    
    System.out.println(
        "\nPrinting using a for-each loop.  Should see each element printed three times.");

    // Loop through each item in the multiset and print it
    for (Integer integer : set) {
      System.out.println("Item " + integer);
    }

  
  
  }

}