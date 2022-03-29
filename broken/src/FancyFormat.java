/**
 * . FancyFormat - format for spreadsheet
 * 
 * This work complies with the JMU Honor Code.
 *
 * 
 * @author Ryan Gross
 * @version 9/4/20
 *
 */
public class FancyFormat implements Format
{
  /**
   * . print in fancy format
   * 
   * @param sheet
   *          spreadsheet
   */
  @Override
  public void print(Spreadsheet sheet)
  {
    for (int i = 0; i < 11; i++)
    {
      System.out.print("+-------------");
      if (i == 10)
      {
        System.out.print("+");
      }
    }
    System.out.print("\n");
    System.out.print("|     Number ");
    for (int i = 0; i < 10; i++)
    {
      System.out.print(String.format("%4s", "|  "));
      System.out.print(String.format("%10s", i + " "));
    }
    System.out.print(" |");
    System.out.print("\n");
    for (int i = 0; i < 11; i++)
    {
      System.out.print("+-------------");
      if (i == 10)
      {
        System.out.print("+");
      }
    }
    System.out.print("\n");
    System.out.print("|       Name ");
    for (int i = 0; i < 10; i++)
    {
      System.out.print(String.format("%2s", "|"));
      System.out.print(String.format("%8s", "   " + sheet.getName(i)) + " ");
    }
    System.out.print(" |");
    System.out.print("\n");
    for (int i = 0; i < 11; i++)
    {
      System.out.print("+-------------");
      if (i == 10)
      {
        System.out.print("+");
      }
    }
    System.out.print("\n");
    for (int row = 0; row < 10; row++)
    {
      System.out.print("|    " + String.format("%7s", row));
      System.out.print("  | ");
      for (int col = 0; col < 10; col++)
      {
        if (col == 9)
        {
          System.out.print(String.format("%.8f", sheet.getEntry(row, col)) + "  |");
          System.out.print("\n");
        }
        else
        {
          System.out.print(String.format("%.8f", sheet.getEntry(row, col)) + "  | ");
        }
      }
    }
    for (int i = 0; i < 11; i++)
    {
      System.out.print("+-------------");
      if (i == 10)
      {
        System.out.print("+");
      }
    }
    System.out.print("\n");
  }

}
