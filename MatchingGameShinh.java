/*
 name: EKJYOT SINGH SHINH
 Date:June 5, 2022
 * My expected grade for this assignment is 100 since all the requirements are fulfilled
 */

import java.util.*;

public class MatchingGameShinh {
   public static void main(String[] args) {
      Random rand = new Random();// creating the random generator
      Scanner kb = new Scanner(System.in); // creating a Scanner object
      String answer = ""; // declareing a string variable

      description(kb);// calling the description meathod

      while (!answer.equalsIgnoreCase("q")) {
         play(rand);
      }

   }

   public static int getRand(Random rand)// meathod to create random numbers
   {
      int number = rand.nextInt(9) + 1;
      return number;
   }

   public static void play(Random rand) {

      Scanner kb = new Scanner(System.in);
      int total = 0;
      String answer = "";

      while (!answer.equalsIgnoreCase("q")) {
         int n1 = getRand(rand), n2 = getRand(rand), n3 = getRand(rand);// calling the method getRand(rand)

         System.out.println("You got n1 : " + n1 + " n2 : " + n2 + " n3 : " + n3);

         int match = match(n1, n2, n3);
         if (match == 2) {
            total = total + 100;// adding 100 to the total

            System.out.println("You got two matches, you won 100 dollars");
         } else if (match == 3) {
            total = total + 300;// adding 300 to the total
            System.out.println("You got three matches, you won 300 dollars");

         } else
            System.out.println("You got no matches");

         System.out.print("\nHit enter to continue or press q/Q to quit  ");
         answer = kb.nextLine();

      }
      System.out.println("\nTotal amount you won: " + total);
      System.out.println("\n");
      kb.nextLine();

   }

   public static int match(int n1, int n2, int n3) {
      if (n1 == n2 && n2 == n3)
         return 3;
      else if (n1 == n2 || n2 == n3 || n1 == n3)
         return 2;
      else
         return 1;

   }

   public static void description(Scanner kb) {
      System.out.println(
            "Welcome to the matching game. If TWO OF the numbers match then you win 100 and if Three of the numbers match then you win 300");
      System.out.println("What is your name : ");
      String name = kb.nextLine();
      System.out.println("Hello " + name + " lets start playing");

   }
}