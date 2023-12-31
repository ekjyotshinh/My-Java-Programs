import java.util.Stack;
import java.util.ArrayList;

public class QueueShinh // <--- must change this name
{
   // no code here
}

class Queue {
   // attribute
   ArrayList<Integer> list;

   // constructor
   public Queue() {
      list = new ArrayList<Integer>();
   }

   public void enqueue(Integer num) {
      list.add(num);
   }

   public Integer dequeue() {
      return list.remove(0);
   }

   public String toString() {
      String s = "";
      Queue copy = new Queue();
      boolean b = false;
      while (!b) {
         try {
            int num = this.dequeue();
            copy.enqueue(num);
            s = s + " " + num;
         } catch (Exception e) {
            b = true;
         }
      }
      // System.out.println(copy.list+ "&&&&");
      restore(copy);
      return s;
   }

   public int getMax() {
      Queue copy = new Queue();
      boolean b = false;
      int max = 0;
      while (!b) {
         try {
            int num = this.dequeue();
            if (num > max)
               max = num;
            copy.enqueue(num);

         } catch (Exception e) {
            b = true;
         }
      }
      restore(copy);
      return max;
   }

   public void restore(Queue q) {
      boolean b = false;
      while (!b) {
         try {
            this.enqueue(q.dequeue());
         } catch (Exception e) {
            b = true;
         }
      }
   }

   // *******************implement the following methods***************
   public Integer getMin() {
      Queue copy = new Queue();
      boolean b = false;
      int min = getMax();// setting minimum value equal to the maximum value
      while (!b) {
         try {
            int num = this.dequeue();

            if (num < min)
               min = num;
            copy.enqueue(num);

         } catch (Exception e) {
            b = true;
         }
      }
      restore(copy);// restoring the original queue
      return min;

   }

   public void reverseOrder() {
      Stack<Integer> reverse = new Stack<Integer>();// Declare an extra storage of stack
      Boolean b = false;
      while (!b) {
         try {
            int num = this.dequeue();// dequeue an element
            reverse.push(num);// Push the element to the stack
         } catch (Exception e) {
            b = true; // Set b to true
         }
      }
      // Pop the elements from the stack and rebuild the queue.
      b = false;// Set b to false
      while (!b) {
         try {
            int num = reverse.pop();// pop an element from the stack
            this.enqueue(num);// enqueue the element that was popped

         } catch (Exception e) {
            b = true;// Set b to true
         }
      }
   }

   public double getAverage() {
      double sum = 0;
      double average = 0;
      int count = 0;
      Queue copy = new Queue();
      boolean b = false;
      while (!b) {
         try {
            int num = this.dequeue();// dequeue an element
            copy.enqueue(num);
            sum = sum + num;// adding all of them
            count = count + 1;// increasing the number of count

         } catch (Exception e) {
            b = true;// Set b to true
         }
      }
      restore(copy);// restoring the original queue
      average = sum / count;
      return average;
   }

   public boolean isSorted()// this meathod checks i fthe queue is sorted or not
   {
      Queue q = new Queue();
      boolean b = false;
      boolean sorted = true;

      while (!b) {
         try {
            int num1 = this.dequeue();
            int num2 = this.dequeue();
            q.enqueue(num1);
            q.enqueue(num2);
            if (num1 > num2)
               sorted = false;

         } catch (Exception e) {
            b = true;
         }
      }
      restore(q);
      return sorted;

   }

   // ****************************************************
   /*
    * add a method of your choice to this queue class
    * Method description
    * points for this method is 10
    */
   public int getProduct()// gives the product of all numbers
   {
      int product = 1; // as everthinh times one is the number itself so it wont affect the result
      Queue copy = new Queue();// creating a new queue
      boolean b = false;
      while (!b) {
         try {
            int num = this.dequeue();// dequeue an element
            copy.enqueue(num);
            product = product * num;

         } catch (Exception e) {
            b = true;// Set b to true
         }
      }
      restore(copy);
      return product;

   }

}

class Driver {
   public static void main(String[] args) {
      Queue m = new Queue();
      m.enqueue(10);
      m.enqueue(12);
      m.enqueue(15);
      m.enqueue(7);
      m.enqueue(100);
      m.enqueue(22);
      System.out.println("The queue is : " + m);
      m.reverseOrder();
      System.out.println("The queue in the reverse order is: " + m);
      m.reverseOrder();
      System.out.printf("Average = %.2f\n", m.getAverage());
      System.out.println(m);
      System.out.println("Max = " + m.getMax());
      System.out.println("Max = " + m.getMin());
      System.out.println("Product = " + m.getProduct()
            + "          (THIS IS MY METHOD, THIS CALCULATES THE PRODUCT OF THE ENTIRE QUEUE)");
      System.out.println("The list is sorted: " + m.isSorted());
      System.out.println("The queue is : " + m);

   }
}

class yourDriver {
   public static void main(String[] args) {

      Queue m2 = new Queue();
      m2.enqueue(-34);
      m2.enqueue(34);
      m2.enqueue(69);
      m2.enqueue(-7);
      m2.enqueue(99);
      m2.enqueue(21);
      System.out.println("The queue is : " + m2);
      m2.reverseOrder();
      System.out.println("The queue in the reverse order is: " + m2);
      m2.reverseOrder();
      System.out.printf("Average = %.2f\n", m2.getAverage());
      System.out.println(m2);
      System.out.println("Maximum number = " + m2.getMax());
      System.out.println("Minimum number = " + m2.getMin());
      System.out.println("Product of all the numbers is " + m2.getProduct()
            + "          (THIS IS MY METHOD, THIS CALCULATES THE PRODUCT OF THE ENTIRE QUEUE)");
      System.out.println("The list is sorted: " + m2.isSorted());
      System.out.println("The queue is : " + m2);

   }
}