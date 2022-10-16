/*
 name: EKJYOT SINGH SHINH
 Date:June 12, 2022
 My expected grade for this assignment is 100 since all the requirements are fulfilled
 */
import java.util.*;
public class AirplaneShinh
{
}
class Person{
	 //implement your code here
         //list of the instnace variables
  private String first;
  private String last;
  private String ticketID;
  
  
  
  //constructor
  public Person(String first, String last, String ticketID)
  {
      //This code assigns the values to the variables created above
        this.first = first;
        this.last = last;
        this.ticketID = ticketID;
        
  }
  
  
     
   //getter methods: implement all the getter methods
   public String getFirst()//Meathod that returns the name(type string)
  {
    return first;
  }
  public String getLast()//Meathod that returns the last name(type string)
  {
    return last;
  }
  public String getTicketID()//Meathod that returns the Ticket Id (type string)
  {
    return ticketID;
  } 
     
   //setter methods: implement all the setter methods
   public void setFirst(String first)
  {
    this.first = first;//Meathod that sets the new name
  }
  public void setLast(String last)
  {
    this.last = last;//Meathod that sets the last name
  }
  public void setTicketID(String ticketID)
  {
    this.ticketID = ticketID;// meathod thet sets the new id
  }
  
  public String toString()// To string meathod
   {
    
      String s = "First : " + first;
      s = s + "\nLast : " + last;
      s= s+ "\nTicketID:  " + ticketID;
      return s;
   }
   
   public boolean equals(Object o)// Checks if the first name is equal to the last name
   {
   return first.equalsIgnoreCase(last);
   }



}

class Passenger extends Person{
	//implement your code here
        //list of the instnace variables
    
    
    private int seatNumber;
    private String classType;
    
    
    
    //constructor
    public Passenger(String first, String last, String ticketID, int seatNumber,String classType)
    {
        //This code assigns the values to the variables created above
        super(first, last, ticketID);
        this.seatNumber = seatNumber;
        this.classType = classType;
        
    }
    
   
    //getter methods: implement all the getter methods
    public int getSeatNumber() 
    {
        return seatNumber;
    }
    
    public String getClassType() //Meathod that returns the ID(type string)
    {
        return classType;
    }
    
       
    
    //setter methods: implement all the setter methods
    public void setSeatNumber( int seatNumber) // This meathod replace the old name by the new name
    {
        this.seatNumber = seatNumber;
    }
    
    public void setClassType( String classType) // This meathod replace the old ID by the new ID
    {
        this.classType = classType;
    }
    
      public String toString()// To string meathod
   {
    
      String s =  super.toString();
      s = s + "\nSeat Number : " + getSeatNumber();
      s= s+ "\nClass Type:  " + getClassType();
      return s;
   }


}

interface list {   
		public boolean add(Object o);
		public Object search(Object o);
		public boolean delete(Object o);
		public void printLast();
		public void takeOff();
	}

class Airplane implements list{
	//declare the instance variable
        public static int count = 0;
        private Passenger[] plane = new Passenger[10]; 
        private Boolean takenOff = false;
        private int planeNum;
        
       
       
        public Airplane(int planeNum)
        {
        this.planeNum = planeNum;
        }

      
   
   
	public boolean add(Object o) {
		//complete this method
                if(o instanceof Passenger)  //check the class type before type casting
                       {
                         Passenger p = (Passenger) o; // type casting the object o to Passenger class
        
                         if(!takenOff)
                          {
                             count = count + 1;
                             plane[count-1] = p;
                             return true;
                          }
                          return false;
                         
                        }
                 else
       
		return false;
	}

	public Object search (Object o)
{         boolean b = o instanceof String; 
            if(!b) 
            {
                return null;
             }
            String name = (String)o; 
            for(int i = 0; i < plane.length; i++)
               {
                if(plane[i]!= null && plane[i].getLast().equalsIgnoreCase(name))
                   { 
                     return plane[i];   //returning the found object 
                   } 
               
               }
             return null;//returning null if the object is not found


           
}
	public boolean delete(Object o) {
		//complete this method
                boolean b = o instanceof String; //check the class type before type casting

            if(!b) 
            {
                return false;
             }
            String name = (String)o; 
            for(int i = 0; i < plane.length; i++)
               {
                if(plane[i]!= null && plane[i].getLast().equalsIgnoreCase(name))
                   { count = count - 1;
                     plane[i] = null;
                     return true;   //returning true
                   } 
               
               }
             return false;//returning null if the object is not found

	}

	public void printLast() 
        {
		//complete this method
                for(int i = 0; i < plane.length; i++)
               {
               if(plane[i]!= null)
               {
               System.out.println(plane[i].getLast() );// prints the last name
               }
               }

	}

	public void takeOff() 
        {
		takenOff = true;//sets the taken off boolean to true
	}
	  public String toString()
          {String s = "";
            for(int i = 0; i < plane.length; i++)
               {  if(plane[i]!= null)
                 { 
                  s = s + plane[i] + "\n";
                  }
                }
              return s;
           }    

               
}

/*uncommnet the Driver class once you have implemented the above classes completely to avoid having errors*/
	
class Driver {
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		
		Airplane plane = new Airplane(20394);
		Passenger p1 = new Passenger("Bobby", "Smith", "123456789", 1, "First class");
		Passenger p2 = new Passenger("Johnny", "Apple", "987654321", 8, "Business class");
		Passenger p3 = new Passenger("Tom", "Jerry", "567123489", 32, "Economy class");
		Passenger p4 = new Passenger("Candy", "Cruz", "982134567", 15, "Premium Economy class");
		Passenger p5 = new Passenger("Kaloti", "Aaron", "762134589", 5, "First class");
		
		plane.add(p1);
		plane.add(p2);
		plane.add(p3);
		plane.add(p4);
		plane.takeOff();
		plane.add(p5);
		
		System.out.println("Here is the list of the passengers in this plane");
		System.out.println(plane+ "\n");
		
		 System.out.println("Testing the printLast method to display the last names");
		   plane.printLast(); //prints the last name of the passenger sin the train
		   System.out.println();
		   
		   System.out.println("Testing the static method getCount");
		   System.out.println("This plane has " + plane.count + " Passengers\n");
		   
		   System.out.print("Enter the last name of the passenger: ");
		   String lastName = in.nextLine();
		   System.out.println(plane.search(lastName));
		   System.out.println();
		   
		   System.out.println("Testing the delete method");
		   System.out.print("Enter the last name of the passenger: ");
		   String last = in.nextLine();
		   plane.delete(last);
		   System.out.println("Passenger " + last + " has been removed from the list\n");
		   
		   System.out.println("Here is the updated list");
		   System.out.println(plane);
		
	}
}

/*Cretae your own driver with the list of your passengers*/
/*This part has 10 points*/
class MyDriver
{
   public static void main(String[] args)
   {           Scanner in = new Scanner(System.in);
                Airplane plane2 = new Airplane(20394);// creating the new object
		Passenger p1 = new Passenger("Mirin", "Smo", "2875486789", 5, "First-class");
		Passenger p2 = new Passenger("John", "Depp", "9889643321", 3, "Business-class");
		Passenger p3 = new Passenger("Tommy", "hilfiger", "567345889", 192, "Economy-class");
		Passenger p4 = new Passenger("tom", "Cruz", "3458234967", 1, "Premium-Economy-class");
		Passenger p5 = new Passenger("ajab", "gajab", "7643543589", 8, "First-class");
		
                //adding the passengers
		plane2.add(p1);
		plane2.add(p2);
		plane2.add(p3);
		plane2.takeOff();// the plane took off
                plane2.add(p4);
		plane2.add(p5);
		
		System.out.println("Here is the list of the passengers in this plane");
		System.out.println(plane2+ "\n");
		
		 System.out.println("Testing the printLast method to display the last names");
		   plane2.printLast(); //prints the last name of the passenger sin the train
		   System.out.println();
		   
		   System.out.println("Testing the static method getCount");
		   System.out.println("This plane has " + plane2.count + " Passengers\n");
		   
		   System.out.print("Enter the last name of the passenger: ");
		   String lastName = in.nextLine();
		   System.out.println(plane2.search(lastName));
		   System.out.println();
		   
		   System.out.println("Testing the delete method");
		   System.out.print("Enter the last name of the passenger: ");
		   String last = in.nextLine();
		   plane2.delete(last);
		   System.out.println("Passenger " + last + " has been removed from the list\n");
		   
		   System.out.println("Here is the updated list");
		   System.out.println(plane2);
                   System.out.println("This plane now has " + plane2.count + " Passengers\n");

   }
}
