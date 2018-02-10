/**
   This very basic tokenizer only does part of the job of a real
   tokenizer. It takes an input string of characters and converts
   it to an array of tokens, but it does not classify the tokens
   into token types. And this tokenizer does not use a grammar to
   define tokens, it just uses white space to delimit the "tokens".
*/

public class Tokenizer
{
   private String[] tokens;
   private int currentToken;

   /**
      This constructor converts an array of char (i.e., a String)
      into an array of tokens. Whitespace characters are used as
      token delimiters.

      In other words, the split() method in the String class is our tokenizer!
   */
   public Tokenizer(String string)
   {
      tokens = string.trim().split("\\s+"); // create array of tokens
      currentToken = 0;
   }

   /**
      This method "consumes" the current token.
   */
   public String nextToken()
   {
      return tokens[currentToken++];
   }

   /**
      This method both tests and consumes the current token.
   */
   public boolean match(String tk)
   {
      return tk.equals( tokens[currentToken++] );
   }

   /**
      This method allows you to look at the current
      token without consuming it.
   */
   public String peekToken()
   {
      return tokens[currentToken];
   }

   /**
      This method allows you to look at the token after
      the current token (without consuming any token).
   */
   public String peek2Token()
   {
      return tokens[currentToken+1];
   }

   /**
      Returns false if all of the tokens have been "consumed".
   */
   public boolean hasToken()
   {
      return ( currentToken < tokens.length );
   }

   /**
      Use this method for information purposes. It
      allows you to see how a string gets "tokenized".
   */
   public String toString()
   {
      String result = "index = " + currentToken + ", tokens = [";
      result += tokens[0];
      for(int i = 1; i < tokens.length; i++)
         result += ", " + tokens[i];
      return result + "]";
   }

}//Tokenizer
