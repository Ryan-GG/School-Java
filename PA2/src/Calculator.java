
/**
 * Encapsulate various spreadsheet computations.
 * 
 * @author C. Fox
 * @author Ryan Gross[credit to Dr.Fox's code]
 * @version 8/20, 9/14
 */
public class Calculator
{
  /**
   * Sum up the designated column of a spreadsheet. Return 0 if there is no such column.
   * 
   * @param sheet
   *          which spreadsheet to work on
   * @param col
   *          which column to sum
   * @return the sum of the values in the designated column, or 0 if there is no such column.
   */
  public static double sumcol(Spreadsheet sheet, int col)
  {
    if (col < 0 || Spreadsheet.SIZE <= col)
      return 0.0;
    double result = 0.0;
    for (int row = 0; row < Spreadsheet.SIZE; row++)
      result += sheet.getEntry(row, col);
    return result;
  }

  /**
   * Sum up the designated row of a spreadsheet. Return 0 if there is no such row.
   * 
   * @param sheet
   *          which spreadsheet to work on
   * @param row
   *          which row to sum
   * @return the sum of the values in the designated row, or 0 if there is no such row.
   */
  public static double sumrow(Spreadsheet sheet, int row)
  {
    if (row < 0 || Spreadsheet.SIZE <= row)
      return 0.0;
    double result = 0.0;
    for (int col = 0; col < Spreadsheet.SIZE; col++)
      result += sheet.getEntry(row, col);
    return result;
  }

  /**
   * Average the designated row of a spreadsheet. Return 0 if there is no such row.
   * 
   * @param sheet
   *          which spreadsheet to work on
   * @param row
   *          which row to sum
   * @return the avg of the values in the designated row, or 0 if there is no such row.
   */
  public static double avgrow(Spreadsheet sheet, int row)
  {
    if (row < 0 || Spreadsheet.SIZE <= row)
      return 0.0;
    double result = 0.0;
    int counter = 0;
    for (int col = 0; col < Spreadsheet.SIZE; col++)
    {
      result += sheet.getEntry(row, col);
      if (sheet.getEntry(row, col) > 0)
        counter++;
    }
    if (counter == 0)
    {
      return 0.0;
    }
    return result / counter;
  }

  /**
   * Average the designated col of a spreadsheet. Return 0 if there is no such col.
   * 
   * @param sheet
   *          which spreadsheet to work on
   * @param col
   *          which row to sum
   * @return the avg of the values in the designated col, or 0 if there is no such col.
   */
  public static double avgcol(Spreadsheet sheet, int col)
  {
    if (col < 0 || Spreadsheet.SIZE <= col)
      return 0.0;
    double result = 0.0;
    int counter = 0;
    for (int row = 0; row < Spreadsheet.SIZE; row++)
    {
      result += sheet.getEntry(row, col);
      if (sheet.getEntry(row, col) > 0)
        counter++;
    }
    if (counter == 0)
    {
      return 0.0;
    }
    return result / counter;
  }
}
