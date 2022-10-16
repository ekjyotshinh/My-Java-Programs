/*
 Name: EKJYOT SINGH SHINH
 Date:May 30,2022
 * My expected grade for this assignment is 100 since all the requirements are fulfilled
 */
import java.util.*;
public class NumberShinh
{
   public static void main(String[] args)
   {
     System.out.println("Welcome to the distinct numbers. \nI will remove the repeated numbers and display the numbers you just enetered");
     int[] num = getInput();
     display(num);
   }
   public static int[] getInput()//this meathod takes the input fron the user and further uses another meathod to check if it is a distinct number or not
   {
     Scanner kb = new Scanner(System.in);
     int[]num = new int[10];
     int number;
     for (int i = 0; i<num.length; i++)
     {
        System.out.println("Please enter a number");
        number = kb.nextInt();
        boolean found = isDistinct(num, number);
        
        if(found)
         {
           i--;
         }  
        else
          {
            num[i]=number; 
          } 
     
     
     }

      return num; 
    }
   public static void display(int[] num)//this meathod displayes the content of the array
   {
      System.out.println("I filtered out all the repeated numbers you entered and kept only one copy of each number.\nHere is the list of your numbers");
      System.out.print("{");
      for (int i = 0; i<num.length; i++)
     {  System.out.print(num[i]+" ");
     }
     System.out.print("}");
     }
     
   public static boolean isDistinct(int[] v, int n)// this meathod checks if the number is distict of duplicate
   {
       for (int i = 0; i<v.length; i++)
       { 
         if(v[i]==n)
         return true;
       }
       return false;
   }
 }