/*

*/

/**
 The infixPrint() method takes a BTree that is an expression tree
 and converts it into a String with infix notation that is properly
 parenthesized.

 The expression tree can contain the following five binary operators,
 +, -, *, /, ^
 and two unary operators
 neg, sqrt.
 The unary operators have their operand in their right subtree.

 The unary operator "neg" should be printed out as a minus sign, "-".

 The unary operator "sqrt" should be printed out as "sqrt( )" with
 parentheses around its operand.

 The binary operators should be printed with a space on either side of
 them, except for the "^" operator. Since it has such high precedence,
 it is easier to read if this operator does not have spaces around it.

 You can assume that the expression tree in not empty and that it
 is properly formed (it doesn't have any "syntax errors").
 */
public class InfixPrinter
{
    /**
     This inlinePrint() method is essentially an
     inorder traversal of the tree.
     */
    public static String infixPrint(BTree tree)
    {


        String result = "";
        if ( tree != null )
        {
    //left branch
            if(tree.getLeftTree() != null)
            {
                if(precedence(tree.getElement()) < precedence(tree.getLeftTree().getElement()))
                {
                    result += "(";
                    result += infixPrint(tree.getLeftTree());
                    result = result.substring(0, result.length()-1) + ") ";
                }
                else
                {
                    result += infixPrint( tree.getLeftTree() );
                }
            }
            if(tree.getElement().equals("neg"))//handles when neg is used
                result += "-";
            else if(tree.getElement().equals("^"))//handles when exponent sign is used
                result = result.substring(0, result.length()-1) + "^";
            else if(tree.getElement().equals("sqrt"))
                result += tree.getElement();
            else
                result += tree.getElement() + " ";
    //right branch
            if(tree.getRightTree() != null)
            {
                if(precedence(tree.getRightTree().getElement()) >= precedence(tree.getElement()))
                {
                    result += "(";
                    result += infixPrint( tree.getRightTree() );
                    result = result.substring(0, result.length()-1) + ") ";
                }
                else
                {
                    result += infixPrint( tree.getRightTree() );
                }
            }
        }
        return result;
    }//infixPrint()


    // http://www.java-tips.org/java-se-tips/java.lang/what-is-java-operator-precedence.html
    // http://introcs.cs.princeton.edu/java/11precedence/
    public static int precedence(String op)
    {
        int result = 0;  // "highest" precedence (i.e., constants)

        if ( op.equals("sqrt") )
        {
            result = 1;
        }
        if ( op.equals("^") )
        {
            result = 2;
        }
        else if ( op.equals("neg") )
        {
            result = 3;
        }
        else if ( op.equals("*")
                || op.equals("/") )
        {
            result = 4;
        }
        else if ( op.equals("+")
                || op.equals("-") )
        {
            result = 5;
        }

        return result;
    }//precedence()

}//PrettyPrinter
