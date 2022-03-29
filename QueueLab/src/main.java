
public class main
{

  public static void main(String[] args) {
String[] letters = {"A", "B", "C", "D", "E", "F"};
    
    int index = 4;

    index = (index + 3) % letters.length;

    System.out.println(letters[index]);
  }
}
