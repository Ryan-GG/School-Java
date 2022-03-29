
/**
 * Main program--the main method just calls ohter methods to do all the work, and prints a farewell
 * message at the end.
 * 
 * @author C. Fox
 * @version 8/20
 */
public class JSpreadsheetMain
{

  /**
   * Main program for JSpreadsheet 1.
   * 
   * @param args
   *          not used
   */
  public static void main(String[] args)
  {
    Spreadsheet sheet = new Spreadsheet();
    InputLoop loop = new InputLoop(sheet);
    boolean go = true;
    while (go)
    {
      go = loop.go();
    }
    System.out.println("Bye!");
  }
}
