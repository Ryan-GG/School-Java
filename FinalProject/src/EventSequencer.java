
import java.util.HashMap;
import java.util.TreeMap;

public class EventSequencer
{

  /*
   * This work complies with the JMU honor code. I have not discussed this assignment with others. I
   * will not share information about my solution. I have not accessed resources outside of those
   * posted to the course Canvas page.
   * 
   * Signed: Ryan Gross
   */

  private TreeMap<Integer, String> map = new TreeMap<>();
  private int timeCounter = 0;

  public EventSequencer()
  {

  }

  public void addEvent(int timeStamp, String event)
  {

    if (timeStamp >= timeCounter)
    {
      map.put(timeStamp, event);
    }

  }

  public String nextEvent()
  {
    timeCounter = map.ceilingKey(timeCounter);
    String ret = map.get(timeCounter);
    timeCounter++;
    return ret;
  }

}
