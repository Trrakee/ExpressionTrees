/*


*/

/**
 The prettyPrint() method takes a BTree and
 converts it into a well formated string.

 This prettyPrint() method should print a binary tree
 so that the root of a sub tree and the root of the sub
 tree's left child are on the same line (see the examples
 in the file output.txt). In addition, if the sub tree is
 small, and has depth one, then the whole sub tree should
 be printed on a single line (as in homework assignment 1).
 Finally, the closing parentheses should be lumped together
 as much as possible (again, see the examples).
 */
public class PrettyPrinter
{
   public static String prettyPrint(BTree tree)
   {
      return prettyPrint(tree, "  ", false);
   }

   /**
    This prettyPrint() method is essentially a
    preorder traversal of the tree.
    */
   private static String prettyPrint(BTree tree, String indentation, boolean inline)
   {
      String result = "";
      if (tree == null)  // empty tree (stops the recursion)
      {
         result += "()";
      } else if (tree.depth() == 0)  // depth==0 stops the recursion also
      {
         result += tree.getElement();
      } else if (tree.depth() == 1) {
         result += "(" + tree.getElement();
         result += " " + prettyPrint(tree.getLeftTree(), indentation,inline);
         result += " " + prettyPrint(tree.getRightTree(), indentation,inline);
         result += ")";
      } else {
         result += "(" + tree.getElement();
         String stringIndent = "";
         for (int t = 0; t < tree.getElement().length(); t++) {
            stringIndent = stringIndent + " ";
         }
         result += " " + prettyPrint(tree.getLeftTree(), indentation + "  " + stringIndent,inline);
         result += "\n" + indentation + stringIndent + prettyPrint(tree.getRightTree(), indentation + "  " + stringIndent,inline);
         result +=  indentation.substring(indentation.length()) + ")";
      }
      return result;
   }
}//PrettyPrinter
