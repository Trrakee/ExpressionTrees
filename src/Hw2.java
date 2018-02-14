/**
 ----------------------------------
 | Program created by Tushar Sharma.|
 | CS31600 Homework 2               |
 | Email: sharm191@pnw.edu          |
 | File Info: Hw2.java              |
 ----------------------------------
 */

/**
  This program tests your two expression tree
  prettyprinting methods and your evaluation method.
*/
public class Hw2
{
   public static void main(String[] args)
   {
      String prefix[] =
            // prefix notation       // parenthesized infix notation
          { "+ 2 * 3 4",             // 2 + 3 * 4
            "* + 2 3 4",             // (2 + 3) * 4
            "+ - 2 3 4",             // 2 - 3 + 4
            "- 2 + 3 4",             // 2 - (3 + 4)
            "+ + 2 * 3 4 5",                     // 2 + 3 * 4 + 5
            "+ 2 + * 3 4 5",                     // 2 + (3 * 4 + 5)
            "* + 2 3 + 4 5",                     // (2 + 3) * (4 + 5)
            "+ 2 * 3 + 4 5",                      // 2 + 3 * (4 + 5)
            "neg ^ 2 3",             // -2^3
            "^ neg 2 3",             // (-2)^3
            "^ neg 2 ^ 3 4 ",                      // (-2)^(3^4)
            "^ ^ neg 2 3 4",                      // (-2)^3^4
            "- + 1 * 2 3 / ^ 4 5 6",                      // 1 + 2 * 3 - 4^5 / 6       FIX
            "* + / 1 2 3 ^ 3 2",                      // (1 / 2 + 3) * 3^2             FIX
            " / + neg -1 sqrt - ^ -1 2 * * 4 1 -1 * 2 1"
          };


      for (int i = 0; i < prefix.length; i++)
      {
         BTree expTree = BuildBTree.buildBTree( prefix[i] );
         System.out.println("Inorder traversal --> " + Traverse.inOrder( expTree ));
         System.out.println("Parenthesized exp --> " + InfixPrinter.infixPrint( expTree ));
         System.out.println("The value of this expression is = " + Evaluate.eval( expTree ));
         System.out.println( "\n" + PrettyPrinter.prettyPrint( expTree ) + "\n");
         System.out.println();
      }
   }//main()

}//Hw2
