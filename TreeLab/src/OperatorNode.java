
/**
 * Operator nodes are the internal nodes of a binary expression tree.
 * 
 * @author Ryan gross & Seth Walter
 * @version 10/23/20
 */
public class OperatorNode extends ExpressionNode {

  private Operator op;
  private String s = "";

  public OperatorNode(Operator op) {
    super();
    this.op = op;
  }

  public OperatorNode(Operator op, ExpressionNode left, ExpressionNode right) {
    super(left, right);
    this.op = op;
  }

  /**
   * Evaluate the expression rooted at this node and return the result.
   */
  @Override
  public double evaluate() {

    // UNFINISHED.
   
    switch( op.toString() ) {
      case("ADD"): return left().evaluate() + right().evaluate();
      case("SUBTRACT"):return left().evaluate() - right().evaluate();
      case("DIVIDE"): return left().evaluate() / right().evaluate();
      case("MULTIPLY"): return left().evaluate() * right().evaluate();
    }

    return 0;

  }


  @Override
  public String postfixString() {
    // UNFINISHED (See superclass javadocs for requirements.)
    //preorder
    
    if (!(this.left() instanceof OperandNode) && !(this.right() instanceof OperandNode))
    {

      s += left().postfixString();
      s += right().postfixString();
    }
    else
    {
      s += (this.left().evaluate() + " " + this.right().evaluate() + " ");
    }
    
    if (op.toString().equals("ADD"))
    {
      s += "+ ";
    }
    else if (op.toString().equals("SUBTRACT"))
    {
      s += "- ";
    }
    else if (op.toString().equals("DIVIDE"))
    {
      s += "/ ";
    }
    else if (op.toString().equals("MULTIPLY"))
    {
      s += "* ";

    }

    String temp = s;
    s = "";
    return temp;
  }

  @Override
  public String prefixString() {
    // UNFINISHED
    if (op.toString().equals("ADD"))
    {
      s += "+ ";
    }
    else if (op.toString().equals("SUBTRACT"))
    {
      s += "- ";
    }
    else if (op.toString().equals("DIVIDE"))
    {
      s += "/ ";
    }
    else if (op.toString().equals("MULTIPLY"))
    {
      s += "* ";

    }

    if (!(this.left() instanceof OperandNode) && !(this.right() instanceof OperandNode))
    {

      s += left().prefixString();
      s += right().prefixString();
    }
    else
    {
      s += (this.left().evaluate() + " " + this.right().evaluate() + " ");
    }

    String temp = s;
    s = "";
    return temp;
  }

  @Override
  public String infixString() {
    
    // UNFINISHED
    
    if (!(this.left() instanceof OperandNode)) 
    {

      s += left().infixString();
    } else {
      s += (this.left().evaluate() + " ");
    }
    
    if (op.toString().equals("ADD"))
    {
      s += "+ ";
    }
    else if (op.toString().equals("SUBTRACT"))
    {
      s += "- ";
    }
    else if (op.toString().equals("DIVIDE"))
    {
      s += "/ ";
    }
    else if (op.toString().equals("MULTIPLY"))
    {
      s += "* ";

    }

   
    if (!(this.right() instanceof OperandNode)) 
    {

      s += right().infixString();
    } else {
      s += (this.right().evaluate() + " ");
    }

    String temp = s;
    s = "";
    return temp;
  }


}
