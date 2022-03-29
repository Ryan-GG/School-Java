
/**
 * Methods common to all JSpreadsheet printers.
 * 
 * @author C. Fox
 * @version 8/20
 */
public interface Format
{

  /**
   * Print a JSpreadsheet in some format.
   * 
   * @param sheet
   *          which spreadsheet to print
   */
  void print(Spreadsheet sheet);

  /**
   * Print a JSpreadsheet in some format.
   * 
   * @param sheet
   *          which spreadsheet to print
   */
  void csvPrint(Spreadsheet sheet);
}
