/**
 ----------------------------------
 | Program created by Tushar Sharma.|
 | CS31600 Homework 2               |
 | Email: sharm191@pnw.edu          |
 | File Info: Evaluate.java         |
 ----------------------------------
 */

/**
   The eval() method takes a BTree that is an expression tree
   and evaluates it to a double value.

   The expression tree can contain the following five binary operators,
      +, -, *, /, ^
   and two unary operators
      neg, sqrt.
   The unary operators have their operand in their right subtree.
*/
public class Evaluate {
   /**
    * This eval() method is essentially a
    * postorder traversal of the tree.
    */
   public static double eval(BTree tree) {
      double result = 0.0;
      if (tree == null)
         return 0;
      else if (tree.getElement().equals("+"))
         return eval(tree.getLeftTree()) +
                 eval(tree.getRightTree());
      else if (tree.getElement().equals("sqrt"))
         return Math.sqrt(eval(tree.getRightTree()));

      else if (tree.getElement().equals("^"))
         return  Math.pow(eval(tree.getLeftTree()), eval(tree.getRightTree()));

      else if (tree.getElement().equals("neg"))
         return -eval(tree.getRightTree());

      else if (tree.getElement().equals("-"))
         return eval(tree.getLeftTree()) -
                 eval(tree.getRightTree());

      else if (tree.getElement().equals("*"))
         return eval(tree.getLeftTree()) *
                 eval(tree.getRightTree());

      else if (tree.getElement().equals("/")) {
         double right = eval(tree.getRightTree());

         if (right == 0.0)
            throw new ArithmeticException("Divide by zero is undefined!");
         return eval(tree.getLeftTree()) / right;
      }
      else if (tree.getElement().equals("%")) {
         double right = eval(tree.getRightTree());

         if (right == 0.0)
            throw new ArithmeticException("Mod by zero exception");
         return eval(tree.getLeftTree()) % right;
      }
      //Converting String type to double
      else
         return Double.parseDouble(tree.getElement());
   }//eval()

}//Evaluate
