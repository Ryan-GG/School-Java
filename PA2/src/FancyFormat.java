
/**
 * Print a spreadsheet with esecpially nice formatting.
 * 
 * @author C. Fox
 * @author Ryan Gross[credit to Dr.Fox's code]
 * @version 8/20, 9/14
 */
public class FancyFormat implements Format
{

  @Override
  public void print(Spreadsheet sheet)
  {
    // print header
    printHorizontalLine();
    System.out.printf("| %10s  ", "Number");
    for (int i = 0; i < Spreadsheet.SIZE; i++)
      System.out.printf("| %10d  ", i);
    System.out.println("|");

    // print column names
    printHorizontalLine();
    System.out.printf("| %10s  ", "Name");
    for (int i = 0; i < Spreadsheet.SIZE; i++)
      System.out.printf("| %10.10s  ", sheet.getName(i));
    System.out.println("|");

    // print body
    printHorizontalLine();
    for (int row = 0; row < Spreadsheet.SIZE; row++)
    {
      System.out.printf("| %10d  ", row);
      for (int col = 0; col < Spreadsheet.SIZE; col++)
        System.out.printf("| %10.8f  ", sheet.getEntry(row, col));
      System.out.println("|");
    }
    printHorizontalLine();
  }

  /**
   * Print a line between parts of the spreadsheet.
   */
  private static void printHorizontalLine()
  {
    StringBuilder line = new StringBuilder();
    for (int i = 0; i < Spreadsheet.SIZE + 1; i++)
      line.append("+-------------");
    line.append("+");
    System.out.println(line);
  }

  
  /*
   * @param sheet
   * 
   * prints in csv format
   */
  @Override
  public void csvPrint(Spreadsheet sheet)
  {

    for (int i = 0; i < Spreadsheet.SIZE; i++)
      System.out.printf("%s,", sheet.getName(i));
    System.out.printf("\n");

    // print body
    for (int row = 0; row < Spreadsheet.SIZE; row++)
    {
      // System.out.printf("%d,", row);
      for (int col = 0; col < Spreadsheet.SIZE; col++)
        System.out.printf("%.8f,", sheet.getEntry(row, col));
      System.out.printf("\n");
    }

  }
}
