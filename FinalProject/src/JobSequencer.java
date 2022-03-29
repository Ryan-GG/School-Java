import java.util.ArrayList;
import java.util.HashMap;

/*
 * This work complies with the JMU honor code. I have not discussed this assignment with others. I
 * will not share information about my solution. I have not accessed resources outside of those
 * posted to the course Canvas page.
 * 
 * Signed: Ryan Gross
 */

public class JobSequencer
{
  HashMap<String, ArrayList<Integer>> hashqueue;

  public JobSequencer()
  {
    hashqueue = new HashMap<>();
  }

  public void addJob(String jobType, int jobID)
  {
    ArrayList<Integer> copy = new ArrayList<>();
    if (hashqueue.get(jobType) != null)
    {
      copy = hashqueue.get(jobType);
    }

    copy.add(jobID);

    hashqueue.put(jobType, copy);
  }

  public int nextJob(String jobType)
  {
    int ret = hashqueue.get(jobType).get(0);
    hashqueue.get(jobType).remove(0);
    return ret;
  }

}
