
import java.util.Scanner;

/**
 * . Inputloop - used to control user inputs
 * 
 * This work complies with the JMU Honor Code.
 *
 * 
 * @author Ryan Gross
 * @version 9/4/20
 *
 */
public class InputLoop
{
  private Spreadsheet sheet;
  private Scanner scanner;
  private Format format;

  /**
   * . constructor
   * 
   * @param sheet
   *          spreadsheet
   */
  public InputLoop(Spreadsheet sheet)
  {
    this.sheet = sheet;
    scanner = new Scanner(System.in);
    format = new PlainFormat();
  }

  /**
   * . input for user interface
   * 
   * @return boolean if to continue loop
   */
  public boolean go()
  {
    format.print(sheet);
    System.out.print("> ");
    String input = scanner.nextLine();
    String[] inputs = input.split(" ");

    if (input.matches("^quit$"))
    {

      return false;

    }
    else if (input.matches("^format plain$"))
    {
      format = new PlainFormat();
      System.out.print("\n");
    }
    else if (input.matches("^format fancy$"))
    {
      format = new FancyFormat();
      System.out.print("\n");
    }
    else if (input.matches("^set [0-9] [0-9] [+-]?([0-9]*[.])?[0-9]+$"))
    {

      sheet.setEntry(Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]),
          Double.parseDouble(inputs[3]));

      System.out.print("Set value of cell (" + inputs[1] + ", " + inputs[2] + ") to "
          + String.format("%.8f", Double.parseDouble(inputs[3])) + "\n\n");
    }
    else if (input.matches("^name [0-9] [\\S]+$"))
    {

      sheet.setName(Integer.parseInt(inputs[1]), inputs[2]);
      System.out.print("Set name of column " + inputs[1] + " to " + inputs[2] + "\n\n");

    }
    else if (input.matches("^sumcol [0-9]"))
    {
      System.out.print("The sum of column " + Integer.parseInt(inputs[1]) + " is ");
      System.out
          .println(String.format("%.8f", Calculator.sumcol(sheet, Integer.parseInt(inputs[1]))));
      System.out.print("\n");

    }
    else if (input.matches("^sumrow [0-9]"))
    {
      System.out.print("The sum of row " + Integer.parseInt(inputs[1]) + " is ");
      System.out
          .println(String.format("%.8f", Calculator.sumrow(sheet, Integer.parseInt(inputs[1]))));
      System.out.print("\n");

    }
    else
    {

      System.out.println("Unrecognized command\n");

    }

    return true;
  }

}
