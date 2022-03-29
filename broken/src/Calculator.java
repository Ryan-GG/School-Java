/**
 * . Calculator - used to total cols and rows
 * 
 * This work complies with the JMU Honor Code.
 *
 * 
 * @author Ryan Gross
 * @version 9/4/20
 *
 */
public class Calculator
{
  /**
   * . sums the column values
   * 
   * @param sheet
   *          spreadsheet
   * @param colNumber
   *          index
   * @return double value of all column values
   */
  public static double sumcol(Spreadsheet sheet, int colNumber)
  {
    double sum = 0.0;
    for (int i = 0; i < 10; i++)
    {
      sum += sheet.getEntry(i, colNumber);
    }
    return sum;

  }

  /**
   * . sums all values in row
   * 
   * @param sheet
   *          spreadhseet
   * @param rowNumber
   *          index
   * @return double value of all row values
   */
  public static double sumrow(Spreadsheet sheet, int rowNumber)
  {
    double sum = 0.0;
    for (int i = 0; i < 10; i++)
    {
      sum += sheet.getEntry(rowNumber, i);
    }
    return sum;
  }

  public static double avgrow(Spreadsheet sheet, int rowNumber)
  {
    double sum = sumrow(sheet, rowNumber);

    int counter = 0;

    for (int i = 0; i < 10; i++)
    {
      if (sheet.getEntry(rowNumber, i) > 0)
      {
        counter++;
      }
    }

    return sum / counter;
  }

  public static double avgcol(Spreadsheet sheet, int colNumber)
  {
    double sum = sumcol(sheet, colNumber);

    int counter = 0;

    for (int i = 0; i < 10; i++)
    {
      if (sheet.getEntry(colNumber, i) > 0)
      {
        counter++;
      }
    }

    return sum / counter;
  }

}
