
import java.util.*;

public class Example4
{
    public static void main(String[] args)
    {
       double                 leftOperand, result, rightOperand;
       String                 leftString, operator, rightString;
       StringTokenizer        tokenizer;
       Scanner in = new Scanner(System.in);

       tokenizer = new StringTokenizer(in.nextLine(), "+*/- ", true);
     in.close();
       try
       {
    	   leftString   = tokenizer.nextToken();
           operator     = tokenizer.nextToken();
           rightString  = tokenizer.nextToken();
    	   try {
    		   leftOperand  = Double.parseDouble(leftString);
    	   }
    	   catch (NumberFormatException nfe)
           {
              System.out.println(leftString+ " is not number");
           }
    	   
    	   try {
    		   rightOperand = Double.parseDouble(rightString);
    	   }
    	   catch (NumberFormatException nfe)
           {
              System.out.println(rightString+ " is not number");
           }
          
         
          leftOperand  = Double.parseDouble(leftString);
          rightOperand = Double.parseDouble(rightString);

          if (operator.equals("+"))
             result = leftOperand + rightOperand;
          else if(operator.equals("-"))
        	  result = leftOperand - rightOperand;
          else if(operator.equals("/"))
        	  result = leftOperand / rightOperand;
          else if(operator.equals("*"))
        	  result = leftOperand * rightOperand;
        	  
          else
             result = 0.0;
          System.out.println("Result: " + result);
          
          while(tokenizer.hasMoreTokens()) {
          operator     = tokenizer.nextToken();
            
        	  
           if(operator.equals(" ")) {
        	   
        	   leftString   = tokenizer.nextToken();
               operator     = tokenizer.nextToken();
               rightString  = tokenizer.nextToken();
               try {
        		   leftOperand  = Double.parseDouble(leftString);
        	   }
        	   catch (NumberFormatException nfe)
               {
                  System.out.println(leftString+ " is not number");
               }
        	   
        	   try {
        		   rightOperand = Double.parseDouble(rightString);
        	   }
        	   catch (NumberFormatException nfe)
               {
                  System.out.println(rightString+ " is not number");
               }
         	  leftOperand  = Double.parseDouble(leftString);
               rightOperand = Double.parseDouble(rightString);
               
              if (operator.equals("+"))
                  result = leftOperand + rightOperand;
               else if(operator.equals("-"))
             	  result = leftOperand - rightOperand;
               else if(operator.equals("/"))
             	  result = leftOperand / rightOperand;
               else if(operator.equals("*"))
             	  result = leftOperand * rightOperand;
               else
                   result += 0.0;
               
               
            	   
               
          }

          System.out.println("Result: " + result);
          }
       }
       catch (NoSuchElementException nsee)
       {
          System.out.println("Invalid syntax");
       }
       catch (NumberFormatException nfe)
       {
          System.out.println("One or more operands is not a number");
       }


    }
}
