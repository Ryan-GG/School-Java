/**
 * . PlainFormat - plain format for spreadsheet
 * 
 * This work complies with the JMU Honor Code.
 *
 * 
 * @author Ryan Gross
 * @version 9/4/20
 *
 */
public class PlainFormat implements Format
{
  /**
   * . print(sheet) - prints spreadsheet in plain format
   */
  @Override
  public void print(Spreadsheet sheet)
  {
    System.out.print(String.format("%11s", "Number"));
    for (int i = 0; i < 10; i++)
    {
      System.out.print(String.format("%13s", i));
    }
    System.out.print("  ");
    System.out.print("\n");

    System.out.print(String.format("%11s", "Name")); // 9
    for (int i = 0; i < 10; i++)
    {
      System.out.print(String.format("%13s", sheet.getName(i)));
    }
    System.out.print("  ");
    System.out.print("\n");

    for (int row = 0; row < 10; row++)
    {
      System.out.print(String.format("%14s", row + "   ")); // 13
      for (int col = 0; col < 10; col++)
      {
        if (col != 9)
        {
          System.out.print(String.format("%.8f", sheet.getEntry(row, col)) + "   ");
        }
        else
        {
          System.out.print(String.format("%.8f", sheet.getEntry(row, col)) + "  ");
        }
        if (col == 9)
          System.out.print("\n");
      }
    }

  }

}
