import java.util.NoSuchElementException;

/**
 * . Main - to run JSpreadhseet
 * 
 * This work complies with the JMU Honor Code.
 *
 * 
 * @author Ryan Gross
 * @version 9/4/20
 *
 */
public class JSpreadsheetMain
{
  /**
   * . runs program
   * 
   * @param args
   *          input
   */
  public static void main(String[] args)
  {
    Spreadsheet sheet = new Spreadsheet();
    InputLoop input = new InputLoop(sheet);
    boolean start = true;
    try
    {
      while (start)
      {
        start = input.go();
      }
    }
    catch (NoSuchElementException e)
    {
      e.printStackTrace();
    }

    System.out.print("Bye!\n");
  }
}
