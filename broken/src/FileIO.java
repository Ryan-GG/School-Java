import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileIO
{

  //save & name spreadsheets
  //load spreadsheets
  //average values in row and cols(calculator.java)
  //load csv files
  //save spreadsheets as csv files
  
  /* Things to consider
   * the name and arguments of each command
   * what happens if a user tries to save over an exising file
   * where shoudl you put the save and load functionailty in your design
   * where should you put the average functioanl in your design (calculator)
   */
  
  /* direct path
   * 
   */
  public boolean save(Spreadsheet sheet, String name, String path) {
    return false;
    
  }
  
  /*to disk
   * 
   */
  public boolean save(Spreadsheet sheet) {
    return false;
  }
  
  
  public File load(String fileName) throws FileNotFoundException {
    BufferedReader br = new BufferedReader(new FileReader(fileName));
    return null;
  }
}
