
import java.util.Scanner;

import javax.swing.JFrame;

import jdk.dynalink.CallSiteDescriptor;

/** * Contains the information defining a course at a school. * * @author rileypb * */
public class Course
{
  private String departmentCode;
  private int courseNumber;
  private int creditHours;

  /**
   * The department code is an alphabetic code such as "CS" that represents the department of the
   * course.
   * 
   * @return a String containing the department code
   */
  public String getDepartmentCode()
  {
    return departmentCode;
  }

  /**
   * Set the department code.
   * 
   * @param departmentCode
   *          the new value of departmentCode
   */
  public void setDepartmentCode(String departmentCode)
  {
    this.departmentCode = departmentCode;
  }

  /**
   * The course number is an integer used to identify a course.
   * 
   * @return the course number
   */
  public int getCourseNumber()
  {
    return courseNumber;
  }

  /**
   * Set the course number.
   * 
   * @param courseNumber
   *          the new value of courseNumber
   */
  public void setCourseNumber(int courseNumber)
  {
    this.courseNumber = courseNumber;
  }

  /**
   * The number of credit hours for this course as listed in the course catalog.
   * 
   * @return the number of credit hours
   */
  public int getCreditHours()
  {
    return creditHours;
  }

  /**
   * Set credit hours.
   * 
   * @param creditHours
   *          how many to set it to
   */
  public void setCreditHours(int creditHours)
  {
    this.creditHours = creditHours;
  }

  /**
   * Main program.
   * 
   * @param args
   *          ignored
   */
  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    JFrame frame = new JFrame();
    CallSiteDescriptor csd;
  }
}
