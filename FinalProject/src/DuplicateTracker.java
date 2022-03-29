import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/*
 * This work complies with the JMU honor code. I have not discussed this assignment with others. I
 * will not share information about my solution. I have not accessed resources outside of those
 * posted to the course Canvas page.
 * 
 * Signed: Ryan Gross
 */

public class DuplicateTracker
{

  private ArrayList<Integer> input;


  public DuplicateTracker()
  {
    input = new ArrayList<>();

  }

  public void addID(int id)
  {
    input.add(id);
  }

  public List<Integer> getDuplicates()
  {

    HashSet<Integer> set = new HashSet<>();
    HashSet<Integer> filter = new HashSet<>();
    ArrayList<Integer> output = new ArrayList<>();
   for(Integer e : input) {
     if(set.add(e) == false) {
       filter.add(e);
     }
   }
   
   for(Integer e : filter) {
     output.add(e);
   }
   Collections.sort(output);
   return output;


  }
}
