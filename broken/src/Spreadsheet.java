/**
 * . SpreadSheet - used to store data
 * 
 * This work complies with the JMU Honor Code.
 *
 * 
 * @author Ryan Gross
 * @version 9/4/20
 *
 */
public class Spreadsheet
{

  /**
   * . Size - size of spreadsheet
   */
  public static final int SIZE = 10;
  private String[] columnNames;
  private double[][] entries;

  /**
   * . Speadsheet for data array
   */
  public Spreadsheet()
  {
    columnNames = new String[SIZE];
    for (int i = 0; i < 10; i++)
    {
      setName(i, "Column " + i);
    }
    entries = new double[SIZE][SIZE];
  }

  /**
   * . Sets value at position in spreadsheet
   * 
   * @param row
   *          row index
   * @param col
   *          col index
   * @param value
   *          input
   * 
   */
  public void setEntry(int row, int col, double value)
  {
    entries[row][col] = value;
  }

  /**
   * . returns value
   * 
   * @param row
   *          index
   * @param col
   *          index
   * @return value at row and col
   */
  public double getEntry(int row, int col)
  {
    return entries[row][col];
  }

  /**
   * . gets column name
   * 
   * @param col
   *          index
   * @return String column name
   */
  public String getName(int col)
  {
    return columnNames[col];

  }

  /**
   * . sets column name
   * 
   * @param colNumber
   *          index
   * @param columnName
   *          name
   */
  public void setName(int colNumber, String columnName)
  {
    columnNames[colNumber] = columnName;
  }

}
