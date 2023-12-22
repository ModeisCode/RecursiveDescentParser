
public class RecurdiveDescentParser {
    private String input;
    private int position=0;
    private char currentChar;
    RecurdiveDescentParser(String input){
    this.input=input;
    this.position=0;
    this.currentChar=input.charAt(position);
    }
 public void rdParser(){
     if(expression())
     {
         System.out.println("Result: " + input + " is recognized by the grammar.");
     }
     else
     {
      System.out.println("Result: " + input + " is not recognized by the grammar.");
     }
 }
 private boolean expression(){
    if(term()){
        while(currentChar == '+' || currentChar == '-')
        {
            match(currentChar);
            operator(currentChar);
            if(!term())
            {
             return false;
            }
        }return true;
    }return false;
 }
  private boolean term(){
    if (!factor())
        return false;
          while (factor())
          {
              
              operator(currentChar);
              match(currentChar); 

          }return true;


  }
 private boolean factor()
 {
     if(Character.isLetter(currentChar))
     {
      identifier();
      return true;
     }else if(Character.isDigit(currentChar))
     {
         number();
         return true;
     }else if (operator(currentChar)){
         nextChar();
         return true;
     }
     return false;



 }
 
 private void identifier(){
     StringBuilder identifier = new StringBuilder();
     while(Character.isLetterOrDigit(currentChar))
     {
      identifier.append(currentChar);
      nextChar();
     }
     System.out.println( identifier.toString() + " is a identifier" );
 }
 private void number(){
    StringBuilder num = new StringBuilder();
    while(Character.isDigit(currentChar))
    {
        num.append(currentChar);
        nextChar();
    }
    System.out.println(num.toString() + " is a number" );
 }
 private void match(char expected){
     if(currentChar==expected)
     {
     nextChar();
     }else
     {
         System.out.println("Error: Expected'"+ expected +"'but found '"+ currentChar+"' ");
     } 
 }
 private void nextChar(){
     position++;
     if(position<input.length()){
     currentChar=input.charAt(position);
     }else{
     currentChar='\0';
     }
 }
    private boolean operator(char operator){
        boolean isOperator = false;
        switch(operator)
        {
            case '/': System.out.println(operator + " is a division operator");isOperator = true;break;
            case '*': System.out.println(operator + " is a multiply operator");isOperator = true;break;
            case '+': System.out.println(operator + " is a sum operator");isOperator = true;break;
            case '-': System.out.println(operator + " is a difference operator");isOperator = true;break;
            case '(': System.out.println(operator + " is a left paranthesis");isOperator = true;break;
            case ')': System.out.println(operator + " is a right paranthesis");isOperator = true;break;
        }
        return isOperator;
    }
}
