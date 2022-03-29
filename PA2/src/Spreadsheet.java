
/**
 * Hold the data in a spreadsheet.
 * 
 * @author C. Fox
 * @version 8/20
 */
public class Spreadsheet
{

  /** How many rows/columns in a spreadsheet. */
  public static final int SIZE = 10;

  private String[] columnNames;
  private double[][] entries;

  /**
   * Create a blank spreadsheet of the right size.
   */
  public Spreadsheet()
  {
    columnNames = new String[SIZE];
    entries = new double[SIZE][SIZE];

    for (int col = 0; col < SIZE; col++)
      columnNames[col] = "Column " + col;
  }

  /**
   * Modify a non-header cell, or do nothing if params out of bounds.
   * 
   * @param row
   *          which row
   * @param col
   *          which column
   * @param value
   *          new value
   */
  public void setEntry(int row, int col, double value)
  {
    if (row < 0 || SIZE <= row || col < 0 || SIZE <= col)
      return;
    entries[row][col] = value;
  }

  /**
   * Fetch a non-header cell, or return 0 if params out of bounds.
   * 
   * @param row
   *          which row
   * @param col
   *          which column
   * @return the value at that spot, or 0 if params out of bounds
   */
  public double getEntry(int row, int col)
  {
    if (row < 0 || SIZE <= row || col < 0 || SIZE <= col)
      return 0.0;
    return entries[row][col];
  }

  /**
   * Modify the name of a column, or do nothing if the column is out of bounds.
   * 
   * @param col
   *          which column
   * @param name
   *          the new name
   */
  public void setName(int col, String name)
  {
    if (col < 0 || SIZE <= col)
      return;
    columnNames[col] = name;
  }

  /**
   * Fetch the name of a column, or return null if the column is out of bounds.
   * 
   * @param col
   *          which column
   * @return the column name, or null if the column is out of bounds
   */
  public String getName(int col)
  {
    if (col < 0 || SIZE <= col)
      return null;
    return columnNames[col];
  }

} // Spreadsheet
