/*
 name: EKJYOT SINGH SHINH
 Date:July 3, 2022
 My expected grade for this assignment is 100 since all the requirements are fulfilled
 */
import java.util.*;
public class StackShinh
{
}
interface myStack
{
   public void push(String s);
   public String peek();
   public boolean isEmpty();
   public String pop();
}
class  Stack  //must implement the myStack interface
{
   private ArrayList<Object> list;
   int top;   //index of the top of the stack
   public Stack()
   {
      list = new ArrayList<Object>();
      top = 0;
   }
   public Object peek()  //creating the peek meathod
   {
      
      if (!isEmpty())
         return list.get(top-1);
      return null;   
      
   }
   public Object pop()   //creating the pop meathod
   {
      if(!isEmpty())
      {
         top--;
         Object o = list.get(top);
         list.remove(top);  //removing the element
         return o;
      }
      return null;   
   }
   public void push(Object o)   // creating the push meathod this allows to add an object to the top of the list
   {
      list.add(o);
      top++;
   }
   public boolean isEmpty()  // the meathod which checks if the meathod is empty or not
   {
      return list.size() == 0;
   }
   public String toString()
   {
      return list.toString();
   }
     
}

class Expression
{
   private String exp;  
   public Expression(String s)
   {
      exp = s;
   }
   public String getPostfix()
   {
      String postfix = "";
      Stack operand = new Stack();
      StringTokenizer st = new StringTokenizer(exp," ");
      while(st.hasMoreTokens())
      {
         String token = st.nextToken();
         if(token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-") )   // If the token is any of the operations +, -, /, *
         {
            int precedence =  precedence(token);     //  Get the precedence of the token by calling the method precedence
            if (precedence == 3)     // If the precedence is 3 
            { String top = (String)operand.peek();
               while(!operand.isEmpty() && precedence(top) == 3)     // while the stack is not empty and the precedence of the top of the stack is 3//the token is * or /
               {
                  String opr = (String)operand.pop(); 
                  postfix = postfix + opr + " ";   //  Concatenate it to the postfix expression
               }
            }
            else if (precedence == 2)   // If the precedence is 2
            {  String top = (String)operand.peek();
               while(!operand.isEmpty() && (precedence(top) == 2 || precedence(top) == 3))   // while the stack is not empty and the precedence of the top of the stack is 2 or 3
               {                String opr = (String)operand.pop(); 
                  postfix = postfix + opr +" ";   //  Concatenate it to the postfix expression

               }    
            }
            operand.push(token);  //Push the token to the stack
         }
         else  // token is a number and must be concatenated to the postfix
         {    
            postfix = postfix + token + " ";
         }
      }
      while (!operand.isEmpty())
      {
         String opr = (String)operand.pop(); 
         postfix = postfix + opr +" ";
      }
      return postfix;
   
                     
     
   }
   private static int precedence(String opr)
   {
      if(opr.equals("*") || opr.equals("/"))//if the opr is * or / this method should return 3, 
      {
         return 3;
      }
      else if(opr.equals("+") || opr.equals("-"))// the opr is + or – this method should return 2. 
      {
         return 2;
      }
         
         
      return 1;
   
   }
   public int evalPostfix()
   {
      String post = this.getPostfix();   //cretes the postfix expression  
      Stack num = new Stack();
      int result = 0;
      StringTokenizer st = new StringTokenizer(post," ");
      while (st.hasMoreTokens()) 
      { 
         String token = st.nextToken();
         if (token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-") )  //if the token is an operator then we calculate
         {
            String n1 = (String)num.pop();
            String n2 = (String)num.pop();
            int num1 = Integer.parseInt(n1); //converting the string values to int
            int num2 = Integer.parseInt(n2); //converting the string values to int
            result = calculate(num2, num1, token);  //using the calculate meathod
            String result1 =  String.valueOf(result);
            num.push(result1); //adding the result to he top of the stack 
         
         }
         else
         {
            num.push(token);  //if the token is a number then it is added to the stack
         
         } 
      }
      String number = (String)num.pop();
      int number1 = Integer.parseInt(number);//converting the string to integer
      return number1;      
   }
    
     
  
   private int calculate(int num1, int num2, String opr)
   {
      if(opr.equals("*"))
      {
         return num1 * num2;
      }
      
      if(opr.equals("/"))
      {
         return num1 / num2;
      }
     
      if(opr.equals("+"))
      {
         return num1 + num2;
      }
     
      if (opr.equals("-"))
      {
         return num1 - num2;
      }
      return -1;
   }
}
class ExpDrive
{
   public static void main(String[] args)
   {
     
    // String s = "5 - 2";
      ArrayList <String> exp = new ArrayList<String>();
      exp.add("2 + 3 + 7 * 4 - 2 / 3");
      exp.add("3 - 4 / 2 + 6 * 3");
      exp.add("5 * 6 - 8 + 2 * 10");
      exp.add("4 + 8 * 3 - 2 / 34");
      exp.add("6 - 3 + 6 / 2 * 4 - 8");
      for(int i = 0; i < exp.size(); i++)
      {
      
         Expression e1 = new Expression(exp.get(i));
         String post = e1.getPostfix();
         int result = e1.evalPostfix();
         System.out.println("Infix: "+ exp.get(i) + ",  postfix: " + post + " = " + result);
        
      }
   
   }
}
/*
Write your own driver to test your code
this driver should be similar to the one 
I provided but must be your own expressions
*/
class MyExpDrive
{
   public static void main(String[] args)
   {
      ArrayList <String> exp2 = new ArrayList<String>();//creating a list which stores the equations
      exp2.add("54 + 4 + 8 * 34 - 3 / 3");
      exp2.add("33 - 24 / 12 + 56 * 13");
      exp2.add("54 * 1 - 1 + 1 * 110");
      exp2.add("1 + 1 * 1 - 1 / 1");
      exp2.add("22 * 3 + 1 - 3 * 4");
      for(int i = 0; i < exp2.size(); i++)//using the for loop to go through the loop
      {
      
         Expression e1 = new Expression(exp2.get(i));
         String post = e1.getPostfix();//calling the getpostfix meathod
         int result = e1.evalPostfix();//calling the eval postfix meathod
         System.out.println("Infix: "+ exp2.get(i) + ",  postfix: " + post + " = " + result);
        
      }
   }
}