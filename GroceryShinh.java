/*
 name: EKJYOT SINGH SHINH
 Date:June 22, 2022
 My expected grade for this assignment is 100 since all the requirements are fulfilled
 */
public class GroceryShinh  
{
   // no code here
} 


class Item implements Comparable<Object>
{
   //list of the instnace variables
   private String food;
   private double price;
   private String expirationDate;
          
   public Item(String food, double price, String expirationDate)
   {
       
      //This code assigns the values to the variables created above
      this.food = food;
      this.price = price;
      this.expirationDate = expirationDate;
        
   
   }
      
   public String getFood() //Meathod that returns the food name(type string)
   {
      return food;
   }
   
   public double getPrice() //Meathod that returns the price of the item(type Double)
   {
      return price;
   }
   
   public String getExpirationDate() //Meathod that returns the expiration date(type string)
   {
      return expirationDate;
   }

             
   public void setFood(String food) //Meathod that sets the food name(type string)
   {
      this.food = food;
   }
  
   public void setPrice(double price) //Meathod that sets the price of the item(type Double)
   {
      this.price = price;
   }
   
   public void setExpirationDate(String expirationDate) //Meathod that sets the expiration date(type string)
   {
      this.expirationDate = expirationDate;
   }
   
      
   public int compareTo(Object o) //Meathod that compare two items on the basis of food
   {
      Item i = (Item)o;// setting the object type to item type(Tye Casting)
      return(this.food).compareTo(i.food) ; 
   }
   
   public boolean equals(Item other)// Meathod that checks if two are equal based on the basis of their food name and price
   {
   
      return this.food.equalsIgnoreCase(other.food) && this.price == other.price;
   
   }
   public String toString() // To string meathod
   {
      String s = "\nFood : " + food;
      s = s + "\nPrice : " + price;
      s= s+ "\nExpiration Date :  " + expirationDate + "\n";
      return s;
   }


	
}

class ListNode
{
   private Item I;
   private ListNode next;
    
   //Constructor 1 empty
   public ListNode()
   {
   }
   //constructor 2 one reference
   public ListNode( Object o)
   {
      if (o instanceof Item)
      {
         Item i = (Item)o;
         this.I  = i;
      }   
   }
   //constructor 3 two reference
   public ListNode(Object o, ListNode next)
   {
      if (o instanceof Item)
      {
         Item i = (Item)o;
         I = i;
         this.next = next;
      }    
   }
   //initializes the pointer to the next node in the list
   public void setNext(ListNode n)
   {
      this.next = n;
   }
   //setter method
   public Item getItem()
   {
      return I;
   }
   //getter method
   public ListNode getNext()
   {
      return next;
   }
}

interface List
{
   public void add(String food, double price, String expDate);
   public void add(int index, String food, double price, String expDate);
   public int indexOf(String food);
   public void remove(String food);
   public int size();
   public String toString();
   public Item get(int index);
   public Item mostExpensive();
}

class GroceryList implements List
{
   private ListNode front ;  //front of the list
   private static int size = 0;  //class variable keeping track of the number of the nodes
   
   //no argument constructor
   public GroceryList()
   {
      front = null;
   }
   public void add(String food, double price, String expDate) 
   {
      Item i = new Item(food,price,expDate); //creating the item object
   
     //making a copy of the front of the list
      ListNode curr = front;
   
      //check to see if the list is empty, if it is update the front node
      if(front == null)
      {
         front = new ListNode(i);   //creating a new node to add it to the list
         size++;
         return;
      }
      
      //create a new ListNode
      ListNode n = new ListNode(i);
   
       //need to find the end of the list and add it to the end
      while(curr.getNext()!= null)
      {
         curr = curr.getNext();
      }
      //addding the node to the end
      curr.setNext(n);
   
      size++;  //increment the size by 1
   	
   }

   public void add(int index, String food, double price, String expDate) 
   {
      Item i = new Item(food,price,expDate); //creating the Item object
      if(index > size)// if the index does not exist in the list
         return;
       
     //adding it to the beginning of the list
      if(index == 0)
      {
         ListNode n = new ListNode(i);
         n.setNext(front);
         front = n;
         size++;
         return;
      } 
   
     //adding it somewhere in the list 
      ListNode curr = front;   //make a copy of the front node
      int f = 0;
     //finding the proper index 
      while(curr.getNext() != null && f < index-1)
      {
         curr = curr.getNext();
         f++;
      }  
     //creating the new node
      ListNode n = new ListNode(i);
   
     //n needs to point to current.next
      n.setNext(curr.getNext());
   
     //current needs to point to n
      curr.setNext(n);
   
      size++;
   	
   }

   public int indexOf(String food) 
   {
   	//if the list is empty
      if(front == null)
         return -1;
        
      if(food.equals(front.getItem().getFood()))
      {
         return 0;
      } 
   
      //node is somewhere in the list   
      ListNode curr = front;
      int index = 0;
      while(curr!= null && index <= size)
      {
         if(curr.getItem().getFood().equals(food)) 
            return index;
         curr = curr.getNext(); 
         index++;  
      }   
      return -1;   }

   public void remove(String food) 
   {
      if( front == null)
         return;
      //remove the first node
      if(front.getItem().getFood().equals(food))
      {
         front = front.getNext();
         return;
      } 
      ListNode pre = front;
      ListNode curr = front;
      while(curr != null && !(curr.getItem().getFood().equals(food)))
      {
         pre = curr;
         curr = curr.getNext();
      } 
      if (curr!= null && curr.getNext() == null &&(curr.getItem().getFood().equals(food) ))      
      {
         pre.setNext(null);
         size--;
         System.out.println("The last node is removed");
      } 
      else if (curr == null)
         System.out.println("Item not found");
      else
      {
         pre.setNext(curr.getNext());
         size--;
         System.out.println("A node in the middle is removed");
      }   
   	
   }

   public int size() 
   {
      return size+1;
   }

   public Item get(int index) 
   {	
      if(front == null)
         return null;
     //if the position is greater than the size
      if (index > size)
         return null;    
     
    //make a copy of the front of the list
      ListNode curr = front;
      int pos = 0;
      while(curr!= null && index != pos)
      {
         pos++; 
         curr = curr.getNext();    
      } 
     //the item was not found
      if(curr == null)   
         return null;
    // the item was found
      return curr.getItem();
   }
   
   public String toString()
   {
      if(front == null)  //checking to see if the list is empty
         return "";
      ListNode curr = front; // making a copy of the front node
      String s = "";
   
     //traverse through the list all the way to the end
      while(curr != null)
      {
         s = s + curr.getItem().toString() + " ";
         curr = curr.getNext();
      }   
      return s;
   
   }

   public Item mostExpensive() 
   {
   	
      ListNode curr = front;   //make a copy of the front node
      ListNode maxi = curr;    //list node that contains the info of the most expensive item
      int f = 0;
      double max = front.getItem().getPrice();//this will keep the highest value which can be used for comparison
      
      while(curr.getNext() != null && f < size)
      {
         curr = curr.getNext();
         f++;
         if (curr.getItem().getPrice() > max)
         { 
            max = curr.getItem().getPrice();//max value gets changed and so thus the list node maxi does
            maxi = curr;
         }
      } 
      return maxi.getItem(); 
   
   }
	
}

//Once you have completeed all the classes run your code with the given driver, then write your own driver
class Driver 
{
   public static void main(String []args) 
   {
      GroceryList list = new GroceryList();
   	
      list.add("Bread", 5.99, "3/20/2022");
      list.add("Milk", 3.99, "2/1/2002");
      list.add("Chips", 2.99, "12/30/2025");
      list.add("Rice", 35.50, "8/15/2030");
   	
      System.out.println("Here is the list of food items");
      System.out.println(list);
   	
      System.out.println("Here is the most expensive item on the list");
      System.out.println(list.mostExpensive());
   	
      System.out.println("Removing Milk from the list and adding a new expensive item on the list in the 2nd node");
      list.remove("Milk");
      list.add(1, "Truffle", 800, "4/20/2050");
      System.out.println(list);
   	
      System.out.println("Testing the mostExpensive method to see what is the most expensive item now");
      System.out.println(list.mostExpensive());
   	
      System.out.println("Testing the get method to get the item at the 3rd node");
      System.out.println(list.get(2));
   	
   }
}
/*
implement your own driver and test all the methods. Your driver must be very similar to the provided one*/
 
class MyDriver
{
   public static void main(String[] args)
   {
      GroceryList list2 = new GroceryList();//creating object of grocery list
   	
      list2.add("Milk", 4.99, "6/30/2022");//using the add function
      list2.add("Takis", 3.99, "12/30/2023");
      list2.add("Mango", 20.99, "6/30/2022");
      list2.add("Rice Flour", 15.50, "8/15/2030");
   	
      System.out.println("Here is the list of food items");
      System.out.println(list2);//printing out the list
   	
      System.out.println("Here is the most expensive item on the list");
      System.out.println(list2.mostExpensive());//finding the most expensive item
   	
      System.out.println("Removing Milk from the list and adding a new expensive item on the list in the 2nd node");
      list2.remove("Milk");//removing milk from the list 
      list2.add(1, "Wheat Flour", 21.99, "4/20/2030");//adding wheat flour to the list
      System.out.println(list2);//printing out the list
   	
      System.out.println("Testing the mostExpensive method to see what is the most expensive item now");
      System.out.println(list2.mostExpensive());//looking for the most expensive item
   	
      System.out.println("Testing the get method to get the item at the 4th node");
      System.out.println(list2.get(3));//gettig the 4th node item from the list
   }
}