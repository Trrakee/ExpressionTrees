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
        if (tree == null)
            return "";   //don't try to do anything if tree is null
        else if (precedence(infixPrint(tree.getLeftTree())) < precedence(tree.getElement()))
        {

            result += "(" +infixPrint( tree.getLeftTree() ) +" "+ tree.getElement() + " ";
            result += infixPrint( tree.getRightTree()) + ")" ;
        }
        else
        {
          //
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
