
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * This class implements the main program loop that accepts input, processes it, and prints the
 * result.
 * 
 * @author C. Fox
 * @author Ryan Gross[credit to Dr.Fox's code]
 * @version 8/20, 9/14
 */
public class InputLoop
{
  private Spreadsheet sheet; // which sheet to process
  private Scanner scanner; // for accepting user input
  private Format format; // for printing the spreadsheet
  private PrintStream csvWriter;

  /**
   * Initialize attributes.
   * 
   * @param s
   *          which spreadsheet to process
   */
  public InputLoop(Spreadsheet s)
  {
    sheet = s;
    format = new PlainFormat();
    scanner = new Scanner(System.in);
  }

  /**
   * Main loop: prompt the user, accept input commands, process the command, and display the result.
   * 
   * @return false iff the program should halt
   */
  public boolean go()
  {

    format.print(sheet);
    System.out.print("> ");
    String command = scanner.next();
    switch (command)
    {
      case "set":
        if (scanner.hasNextInt())
        {
          int row = scanner.nextInt();
          if (scanner.hasNextInt())
          {
            int col = scanner.nextInt();
            if (scanner.hasNextDouble())
            {
              double value = scanner.nextDouble();
              sheet.setEntry(row, col, value);
              System.out.printf("Set value of cell (%d, %d) to %10.8f\n", row, col, value);
            }
          }
        }
        break;
      case "name":
        if (scanner.hasNextInt())
        {
          int col = scanner.nextInt();
          if (scanner.hasNext())
          {
            String name = scanner.next();
            sheet.setName(col, name);
            System.out.printf("Set name of column %d to %s\n", col, name);
          }
        }
        break;
      case "store":
        if (scanner.hasNext())
        {
          String name = scanner.next();
          try
          {
            if (!name.contains(".csv"))
            {
              name = name + ".csv";
            }
            csvWriter = new PrintStream(new File(name));

            PrintStream console = System.out;

            System.setOut(csvWriter);
            format.csvPrint(sheet);
            System.setOut(console);
            System.out.printf("Data stored in %s\n", name);
            csvWriter.close();
          }
          catch (FileNotFoundException e)
          {
            System.out.printf("Store failed: %s", e.getMessage());
          }
        }
        break;

      case "load":
        if (scanner.hasNext())
        {

          String name = scanner.next();

          try
          {
            if (!name.contains(".csv"))
            {
              name = name + ".csv";
            }
            Path pathToFile = Paths.get(name);
            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String line = br.readLine();
            String totalLine = "";
            String[] values;

            while (line != null)
            {
              totalLine = totalLine + line;

              line = br.readLine();
            }

            values = totalLine.split(",");

            int counter = 1;
            for (int i = 0; i < 10; i++)
            {
              sheet.setName(i, values[counter].replaceAll(" ", ""));
              counter++;
            }

            counter++;

            for (int r = 0; r < 10; r++)
            {
              for (int c = 0; c < 10; c++)
              {
                if (counter % 11 == 0)
                {
                  counter++;
                }
                sheet.setEntry(r, c, Double.parseDouble(values[counter]));
                counter++;
              }
            }

            System.out.printf("Data loaded from %s", name);
            br.close();
          }
          catch (IOException e)
          {
            System.out.printf("Load failed: %s %s", name, e.getMessage());
          }

        }
        break;
      case "format":
        if (scanner.hasNext())
        {
          String fmt = scanner.next();
          if (fmt.equals("plain"))
            format = new PlainFormat();
          else if (fmt.equals("fancy"))
            format = new FancyFormat();
        }
        break;
      case "sumrow":
        if (scanner.hasNextInt())
        {
          int row = scanner.nextInt();
          System.out.printf("The sum of row %d is %10.8f\n", row, Calculator.sumrow(sheet, row));
        }
        break;
      case "sumcol":
        if (scanner.hasNextInt())
        {
          int col = scanner.nextInt();
          System.out.printf("The sum of column %d is %10.8f\n", col, Calculator.sumcol(sheet, col));
        }
        break;
      case "avgrow":
        if (scanner.hasNextInt())
        {
          int row = scanner.nextInt();
          System.out.printf("The avg of row %d is %10.8f\n", row, Calculator.avgrow(sheet, row));
        }
        break;
      case "avgcol":
        if (scanner.hasNextInt())
        {
          int col = scanner.nextInt();
          System.out.printf("The avg of column %d is %10.8f\n", col, Calculator.avgcol(sheet, col));
        }
        break;
      case "quit":
        return false;
      default:
        System.out.println("Unrecognized command");
    }
    System.out.println();
    return true;
  }
}
