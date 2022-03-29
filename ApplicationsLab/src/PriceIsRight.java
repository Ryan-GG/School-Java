
import java.util.TreeMap;


/*
 * @author Ryan Gross, Seth Walter
 * @Version 12/10/20
 */
public class PriceIsRight {

  /*
   *  Once an item is purchased, it is removed from the collection of products. 
   *  You may assume that no two items will have exactly the same price. 
   *  You should assume that both the addProduct and the buy methods may be 
   *  called arbitrarily many times and in any order: efficiency matters for both.
   */
  
  private TreeMap<Double, String> pricer;
  
  public PriceIsRight() {
    pricer = new TreeMap<Double, String>();
  }

  public void addProduct(double price, String product) {

    pricer.put(price, product);
  }

  public String buy(double price) {

    

    double pos = 0;
    String out = null;
    if( pricer.lowerEntry(price) != null) {
      pos = pricer.lowerKey(price);
    } else {
      return null;
    }


    out = pricer.get(pos);
    
    pricer.remove(pos);
    
    return out;
    
  }

}
