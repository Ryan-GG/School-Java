/**
 * Class for parsing strings that encode mathematical expressions in prefix
 * format.
 * 
 * @author ??
 * @version ??
 *
 */
public class PrefixParser {



  public PrefixParser() {
   
  }

  /**
   * This method takes a string encoding a prefix expression and returns the
   * corresponding expression tree.
   * 
   * For example, the string "* + 4.0 1.0 2.0", will result in the tree:
   * 
   * <pre>
   *            *
   *           / \
   *          +  2.0
   *         / \
   *       4.0  1.0
   * </pre>
   */
  public ExpressionNode parseExpression(String expression) {
    
    // UNFINISHED!  Here is how you can figure out what the tokens represent:
    
    String[] tokens = expression.split(" ");
    
    for (int i = 0; i < tokens.length; i++) {
      try {
        
        double operand = Double.parseDouble(tokens[i]);
        System.out.println("The token " + operand + " is an operand!");
        
      } catch (NumberFormatException e) {

        Operator op = Operator.parseOperator(tokens[i]);
        System.out.println("The token " + op.opString() + " is an operator!");
      }
      
    }
  
    return null;
  }

 

}
