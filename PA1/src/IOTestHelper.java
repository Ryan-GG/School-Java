import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class IOTestHelper
{
  public static String captureOutput(Runnable runnable)
  {
    return captureOutput(runnable, null);
  }

  public static String captureOutput(Runnable runnable, String inputString)
  {
    PrintStream originalOut = System.out;
    InputStream originalIn = System.in;
    if (inputString != null)
    {
      System.setIn(new ByteArrayInputStream(inputString.getBytes()));
    }
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    System.setOut(new PrintStream(baos));
    runnable.run();
    String output = baos.toString();
    if (inputString != null)
    {
      System.setIn(originalIn);
    }
    System.setOut(originalOut);
    return output;
  }

  public static String getTestData(String fileName)
  {
    InputStream inputStream = IOTestHelper.class.getResourceAsStream(fileName);
    BufferedInputStream bis = new BufferedInputStream(inputStream);
    try
    {
      byte[] bytes = bis.readAllBytes();
      return new String(bytes);
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
    finally
    {
      try
      {
        inputStream.close();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
  }
}
