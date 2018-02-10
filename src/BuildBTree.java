/**
   The static method parsePrefix() is essentially a recursive descent parser
   for strings that hold the prefix notation of an arithmetic expression.

   Input strings are "tokenized" by the very bare bones tokenizer contained
   in the file Tokenizer.java. This tokenizer requires that all tokens in
   the input string be surrounded by white space (which makes the tokenizer
   almost trivial to write).
*/
public class BuildBTree
{
   public static BTree buildBTree(String infix)
   {
      Tokenizer tokens = new Tokenizer(infix);  // Tokenizer defined in Tokenizer.java

      BTree result = parsePrefix(tokens);       // Parse the token stream

      if ( tokens.hasToken() )  // there shouldn't be any more tokens
         throw new Error("syntax error: unexpected input: "+tokens.peekToken()+"\n"+tokens);

      return result;
   }//buildBTree()


   private static BTree parsePrefix(Tokenizer tokens)
   {
      BTree result = null;

      String token = tokens.nextToken(); // consume one token

      if ( "neg sqrt".indexOf(token) != -1 ) // unary operator case
      {
         result = new BTree( token, null, parsePrefix(tokens) );
      }
      else if ( "+-*/^".indexOf(token) != -1 ) // binary operator case
      {
         result = new BTree( token, parsePrefix(tokens), parsePrefix(tokens) );
      }
      else // operand case (this case terminates the recursion)
      {
         result = new BTree( token );
      }
      return result;
   }//parsePrefix()

}//BuildBTree
