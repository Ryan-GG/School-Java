
import java.util.HashMap;
import java.util.HashSet;

/*
 * @author Ryan Gross, Seth Walter
 * @Version 12/10/20
 */
public class HideNSeek {
  
  /*
   * Any number of items may be hidden at the same location. 
   * You should assume that both the hide and the seek methods may 
   * be called arbitrarily many times and in any order: efficiency matters for both.
   */
  
  private HashMap<Integer, HashMap<Integer,HashSet<String>>> map;
  private HashMap<Integer, HashSet<String>> yCord;

  
  public HideNSeek() {
    map = new HashMap<Integer, HashMap<Integer, HashSet<String>>>();
    yCord = new HashMap<Integer,HashSet<String>>();
  }
  
  public void hide(int x, int y, String item) {
    HashSet<String> temp = new HashSet<>();
    if(yCord.get(y) != null) {
      temp = yCord.get(y);
    }
    
    temp.add(item);
    yCord.put(y, temp);
    map.put(x, yCord);
  }
  
  public boolean seek(int x, int y, String item) {
    if(map.get(x) != null) {
        if(map.get(x).get(y) != null) {
          HashSet<String> temp = map.get(x).get(y);
          if(temp.contains(item) != false) {
          return true;
          }
        }
    }
    return false;
  }

}
