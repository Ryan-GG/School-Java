/**
 * Test driver for the Pair class.
 * 
 * @author Nathan Sprague and Michael S. Kirkpatrick
 * @version V2, 1/2018
 *
 */
public class PairDriver<T,T1> {

  /**
   * Create several stadium pairs then print the name of the stadium with the
   * largest capacity.
   * 
   * @param args Not used.
   */
  public static void main(String[] args) {

    Pair<String, Integer>[] stadiums = new Pair[3];
    stadiums[0] = new Pair("Bridgeforth Stadium", 25000);
    stadiums[1] = new Pair("Michigan Stadium", 109901);
    stadiums[2] = new Pair("Lane Stadium", 66233);

    System.out.println(largestStadium(stadiums));

  }

  /**
   * Returns the name of the stadium with the largest capacity.
   * 
   * @param stadiums An array of Pairs where each pair contains a stadium
   *        name followed by an integer capacity
   * @return The name of the stadium with the largest capacity
   */
  public static String largestStadium(Pair<String,Integer>[] stadiums) {
   
    int maxSize = 0;
    String largest = "[not found]";

    // Loop through the array; if the Pair's getSecond() is bigger
    // than maxSize, update the maxSize and largest values
    for (int i = 0; i < stadiums.length; i++) {
      //You can remove explicit casting
      Integer in = (stadiums[i].getSecond());
      if (in > maxSize) {
        largest = (String)stadiums[i].getFirst();
        maxSize = in;
      }
    }

    return largest;

  }

}
