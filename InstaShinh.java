
/*
 name: EKJYOT SINGH SHINH
 Date:June 19, 2022
 My expected grade for this assignment is 100 since all the requirements are fulfilled
 */
import java.util.*;

public class InstaShinh {
}

class User implements Comparable {
   // list of the instnace variables
   private String first;
   private String last;
   private String username;
   private boolean followBack;// set to true if you want to follow back the person

   public User(String first, String last, String username, boolean followBack) {

      // This code assigns the values to the variables created above
      this.first = first;
      this.last = last;
      this.username = username;
      this.followBack = followBack;

   }

   public boolean getFollow()// Meathod that returns the weather if you follow back or not (type boolean)
   {
      return followBack;
   }

   public void unfollow()// Meathod sets the follow back booleean to false
   {

      this.followBack = false;
   }

   public void follow() // Meathod sets the follow back booleean to true
   {
      this.followBack = true;
   }

   public String getFirst() // Meathod that returns the name(type string)
   {
      return first;
   }

   public String getLast() // Meathod that returns the last name(type string)
   {
      return last;
   }

   public void setFirst(String first) // Meathod that sets the new name
   {
      this.first = first;
   }

   public void setLast(String last) // Meathod that sets the new last name
   {
      this.last = last;
   }

   public String getUsername() // Meathod that returns the Username(type string)
   {
      return username;
   }

   public int compareTo(Object o) // Meathod that compare two username
   {
      User u = (User) o;// setting the object type to user type(Tye Casting)
      return (this.username).compareTo(u.username);
   }

   public boolean equals(User other)// Meathod that checks if two names and lat names are same or not
   {

      return this.first.equalsIgnoreCase(other.first) && this.last.equalsIgnoreCase(other.last);

   }

   public String toString() // To string meathod
   {
      String s = "First : " + first;
      s = s + "\nLast : " + last;
      s = s + "\nUsername:  " + username;
      s = s + "\nFolllow Back" + followBack;
      return s;
   }
}

class SocialMedia {
   private ArrayList<User> app;// An array that stores the User type

   public SocialMedia() {
      app = new ArrayList<User>();

   }

   public void followBack(String first, String last)// This method goes through the arraylist and finds the person with
                                                    // the given first and last name then follows that person
   {
      String s = first + " " + last;
      for (int i = 0; i < app.size(); i++) {
         String s1 = app.get(i).getFirst() + " " + app.get(i).getLast();
         if (s1.equalsIgnoreCase(s)) {
            app.get(i).follow();
         }
      }
   }

   public boolean follow(String first, String last, String username, boolean followBack)// This meathod adds the new
                                                                                        // follower to the list
   {
      User u = new User(first, last, username, followBack);
      boolean b = equals(u);
      boolean added = false;
      if (app.size() == 0) {
         app.add(u);
         return true;
      }

      for (int j = 0; j < app.size(); j++) {
         if (u.compareTo(app.get(j)) < 0) {
            app.add(j, u);
            added = true;
            break;
         }
      }
      if (!added) {
         app.add(u);
         added = true;
      }

      return added;

   }

   /*
    * This method removes the person from the list meaning that they are not
    * following you
    * and you are not following them
    */
   public boolean remove(String first, String last) {

      for (int i = 0; i < app.size(); i++) {
         if (app.get(i).getFirst().equals(first) && app.get(i).getLast().equals(last)) {
            app.remove(i);// removing this person from the list
            return true;
         }
      }
      return false; // This person was not found in the list
   }

   public boolean search(String first, String last)// This meathod search for a person in the followers list
   {
      for (int i = 0; i < app.size(); i++) {
         if (app.get(i).getFirst().equals(first) && app.get(i).getLast().equals(last)) {
            return true;
         }
      }
      return false;
   }

   public ArrayList<User> getList()// gives back the list of followers
   {
      return app;
   }

   public int followerCounts()// Gives back the number of followers
   {
      return app.size();
   }

   public int followingCounts()// Gives back the number of people you are folowing
   {
      int count = 0;
      for (int i = 0; i < app.size(); i++)// looping through the entire list
      {
         if (app.get(i).getFollow() == true)// checking if you follow that person
         {
            count = count + 1;
         }

      }

      return count;
   }

   public String toString() // To string meathod
   {
      String s = "";
      for (int i = 0; i < app.size(); i++) {
         s = s + "\nFirst : " + app.get(i).getFirst();
         s = s + "\nLast : " + app.get(i).getLast();
         s = s + "\nUsername:  " + app.get(i).getUsername();
         s = s + "\nFollow Back:  " + app.get(i).getFollow();
         s = s + "\n**************************";

      }

      return s;

   }
}

class MyDriverInstaShinh {
   public static void main(String[] args) {
      SocialMedia myInsta2 = new SocialMedia();

      /* Adding followers to your list */
      /* the boolean field indicates whether you want to follow them back */
      myInsta2.follow("Sasuke", "Uchiha", "UchihaS", true);
      myInsta2.follow("Kakashi", "Hatake", "CopyNinja", true);
      myInsta2.follow("Itachi", "Uchiha", "bestCharacter", true);
      myInsta2.follow("Minato", "Namikaze", "YellowFlash", true);
      myInsta2.follow("Shisui", "Uchiha", "lessSreenTime", false);
      myInsta2.follow("Shikamaru", "Nara", "Smart", false);

      /* Displaying your followers */
      System.out.println("Your followers informations\n");
      System.out.println(myInsta2);

      /* Unfollowing a user */
      System.out.println("Removing Shikamaru Nara from your followers list");
      myInsta2.remove("Shikamaru", "Nara");

      /* Displaying the list */
      System.out.println("List of followers after removing Shikamaru Nara");
      System.out.println(myInsta2);

      /* adding a new follower */
      System.out.println("Adding Naruto Uzumaki to your list of followers");
      myInsta2.follow("Naruto", "Uzumaki", "Karuma", true);

      /* Dipslying the followers */
      System.out.println("List of your followers:");
      System.out.println(myInsta2);

      /* Searching for a follower */
      System.out.println("Searching for Danzo Shimura(Shadow) in your followers list");
      if (myInsta2.search("Danzo", "Shimura") == false) {
         System.out.println("Danzo Shimura is not in your list of followers");
         System.out.println("\n***************************");
         System.out.println("You are following " + myInsta2.followingCounts() + " people");

         System.out.println("You have " + myInsta2.followerCounts() + " followers");
         System.out.println(myInsta2);
         Scanner kb = new Scanner(System.in);
         System.out.println("Enter the first and  last name from the list bellow that you want to follow back: ");

         String first = kb.next();
         String last = kb.next();
         kb.close();
         myInsta2.followBack(first, last);

         System.out.println(myInsta2);

      }

   }
}

class DriverInstaShinh {
   public static void main(String[] args) {
      SocialMedia myInsta = new SocialMedia();

      /* Adding followers to your list */
      /* the boolean field indicates whether you want to follow them back */
      myInsta.follow("Matthew", "Philips", "MatPhil", true);
      myInsta.follow("Gary", "Kane", "GKane", false);
      myInsta.follow("Robert", "Kenny", "RKenny", true);
      myInsta.follow("Bill", "Fitch", "BillF", true);
      myInsta.follow("Trevor", "Schlulz", "TrevorS", false);

      /* Displaying your followers */
      System.out.println("Your followers informations\n");
      System.out.println(myInsta);

      /* Unfollowing a user */
      System.out.println("Removing Robert Kenny from your followers list");
      myInsta.remove("Robert", "Kenny");

      /* Displaying the list */
      System.out.println("List of followers after removing Robert Kenny");
      System.out.println(myInsta);

      /* adding a new follower */
      System.out.println("Adding Elon Musk to your list of followers");
      myInsta.follow("Elon", "Musk", "ElonM", true);

      /* Dipslying the followers */
      System.out.println("List of your followers:");
      System.out.println(myInsta);

      /* Searching for a follower */
      System.out.println("Searching for Stonewall Jackson(StonW) in your followers list");
      if (myInsta.search("Jackson", "Stonewall") == false) {
         System.out.println("Stonewall Jackson is not in your list of followers");
         System.out.println("\n***************************");
         System.out.println("You are following " + myInsta.followerCounts() + " people");

         System.out.println("You have " + myInsta.followingCounts() + " followers");
         System.out.println(myInsta);
         Scanner kb = new Scanner(System.in);
         System.out.println("Enter the first and  last name from the list bellow that you want to follow back: ");

         String first = kb.next();
         String last = kb.next();
         kb.close();
         myInsta.followBack(first, last);

         System.out.println(myInsta);

      }

   }
}