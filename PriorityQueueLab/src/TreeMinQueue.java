
import java.util.TreeMap;
/**
 * 
 * @author Ryan Gross, Seth Walter
 * @version 11/13/20
 * @param <V>
 */
public class TreeMinQueue<V> implements MinQueue<V>
{

  private TreeMap<Double,V> map;
  
  
  public TreeMinQueue()
  {
    map = new TreeMap<>();
  }
  
  public TreeMinQueue(double[] p, V[] v)
  {
    
    map = new TreeMap<Double,V>();
    
    for(int i = 0; i < p.length; i ++) {
      map.put(p[i], v[i]);
    }
  }
  @Override
  public void clear()
  {
    map.clear();

  }

  @Override
  public void insert(double priority, V value)
  {
    map.put(priority,value);

  }

  @Override
  public V removeMin()
  {
    V temp = map.pollFirstEntry().getValue();
    return temp;
  }

  @Override
  public V min()
  {
    V temp = map.firstEntry().getValue();
    return temp;
  }

  @Override
  public int size()
  {
    return map.size();
  }



}
