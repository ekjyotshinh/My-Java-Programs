import java.util.*;

public class BookAppShinh {
}

class Book implements Comparable {
   private String title;
   private String author;
   private String ISBN;
   private double price;

   public Book(String title, String author, String ISBN, double price) {
      this.title = title;
      this.author = author;
      this.ISBN = ISBN;
      this.price = price;
   }

   public String getTitle() {
      return title;
   }

   public String getAuthor() {
      return author;
   }

   public String getISBN() {
      return ISBN;
   }

   public double getPrice() {
      return price;
   }

   public void setTitle(String t) {
      title = t;
   }

   public void setPrice(double p) {
      price = p;
   }

   public void setIsbn(String sb) {
      ISBN = sb;
   }

   public String toString() {
      return title + ", " + author + ", " + price + ", " + ISBN;
   }

   public boolean equals(Book other) {
      return this.ISBN.equals(other.ISBN);
   }

   /*
    * compares the book objects based on the title of the book
    * This compareTo method is called in the selection sort
    */
   // #1
   public int compareTo(Object o) {
      Book b = (Book) o;// setting the object type to book type(Tye Casting)
      return (this.title).compareTo(b.title);// comparing on the basis of the title
   }

   /*
    * compares objects of type book based on their author
    * This comapreTo method is called in the insertion sort
    * the paramter for this method is of type Book and the author of the book b
    * needed to be compared with the author of the Book object called this
    */
   // #2
   public int compares(Book b) {
      return (this.author).compareTo(b.author); // compariing the author
   }

   /*
    * compares the Book object based on the author, if the author is the same then
    * compares the
    * Book objects based on the price
    * this compareTo method is used in the bubbleSort method
    * conditional statemnet needs to be used in this method
    * if the authors of the book b is the same as the author of the Book object
    * this
    * return this.price - b.price
    * else
    * return return author.compareTo(b.author)
    */
   // #3
   public double compare(Book b) {
      if (compares(b) == 0) {
         return (int) (this.price - b.price);// commparing on the basis of price and author
      } else {
         return author.compareTo(b.author);
      }

   }
}

class BookStore {
   private ArrayList<Book> books;

   public BookStore() {
      books = new ArrayList<Book>();
   }

   public void add(String title, String author, double price, String isbn) {
      books.add(new Book(title, author, isbn, price));
   }

   public String toString() {
      String s = "";
      for (int i = 0; i < books.size(); i++) {
         s = s + books.get(i).toString() + "\n";
      }
      return s;
   }

   public boolean delete(String isbn) {
      for (int i = 0; i < books.size(); i++) {
         if (books.get(i).getISBN().equals(isbn)) {
            books.remove(i);
            return true;
         }
      }
      return false;
   }

   /*
    * sorts the books based on the title of the book
    * call the compareTo #1 in this method
    * remember the name of the ArrayList is books and it is not list
    * refer to the given selectionSort code in the modules
    */
   public void selectionSort() {
      for (int i = 0; i < books.size() - 1; i++) {
         int index = -1;
         Book min = books.get(i);
         boolean found = false;
         for (int j = i + 1; j < books.size(); j++) {
            // find the smallest value in the list
            int a = books.get(j).compareTo(min);
            if (a < 0) {
               index = j; // index of the next smallest element in the list
               min = books.get(j);
               found = true; // to check if there is any min value found
            }

         }

         // swapping the vlues
         if (found == true) {
            Book temp = books.get(i);
            books.set(i, min);
            books.set(index, temp);
         }
      }

   }

   /*
    * sorts the book objects based on the author of the book
    * remember the name of the ArrayList is books and it is not list
    * call compare method #2 in this method
    * refer to the provided insertionSort code in the modules
    */
   public void insertionSort() {
      for (int i = 0; i < books.size() - 1; i++) {

         int j = i + 1;

         Book n = books.get(j); // get the book at the index j

         // compare the element at the index j with the elements at the indexes j-1 to 0
         // until we find a proper location for the object n
         while (j > 0 && n.compares(books.get(j - 1)) < 0) {
            books.set(j, books.get(j - 1)); // shifting the element to the right
            j--;
         }
         books.set(j, n);

      }
   }

   /*
    * sorts the book objcts based on the author,
    * if the author is the same then sorts it based on the price
    * call comapre #3 method in this method
    * refer to the provided bubbleSort code for in the modules
    */
   public void bubbleSort() {
      for (int i = 0; i < books.size(); i++) {
         for (int j = 0; j < books.size() - 1 - i; j++) {
            // swap
            if (books.get(j + 1).compare(books.get(j)) < 0) {
               Book temp = books.get(j);// swapping the item
               books.set(j, books.get(j + 1));
               books.set(j + 1, temp);
            }
         }
      }

   }

   /*
    * the following search method searches the book based on the title of the book
    * therfore the first line of code should be a call to the selection sort to
    * sort the books
    * based on the title of the books
    * refer to the binarySearch code provided in the modules
    */
   public Book binarySearch(String title) {
      selectionSort();// first arranging the array list
      boolean found = false;
      int first = 0;// setting the first value
      int last = books.size() - 1;// setting the last value
      int mid = (first + last) / 2;// setting the mid value
      while (first <= last) {
         if (title.compareTo(books.get(mid).getTitle()) == 0)// when both of them are equal then it means we have found
                                                             // it
         {
            found = true;
            return books.get(mid);
         }
         if (title.compareTo(books.get(mid).getTitle()) > 0) // the element is on the right side
            first = mid + 1;// setting the new first
         else // the element is on the left side
            last = mid - 1;// setting the new last
         mid = (first + last) / 2;
      }
      return null;// if it wasnt found
   }

}

class Driver {
   public static void main(String[] args) {
      Scanner kb = new Scanner(System.in);
      BookStore myStore = new BookStore();
      myStore.add("Java", "Zoie", 23.56, "12345678");
      myStore.add("Python", "Elina", 23.56, "2");
      myStore.add("Advance Java", "Stewart", 98, "767676576");
      myStore.add("Build Java", "Liang", 45, "56786565y76");
      myStore.add("Zip lining", "Stewart", 12, "1234566576");
      myStore.add("C++", "Elina", 23.56, "2645556");
      myStore.add("Programming Java", "Stewart", 124, "75465666");
      myStore.add("Humanity", "Smith", 100.56, "234545657");
      boolean b = true;
      while (b) {
         System.out.println("Enter 1 to sort based on the title");

         System.out.println("Enter 2 to sort based on the author");
         System.out.println("Enter 3 to sort based on the author, and the price");
         System.out.print("Enter your choice: ");
         int option = kb.nextInt();
         System.out.println("\n*************");
         if (option == 1) {
            System.out.println("Sorted based on the title\n");
            myStore.selectionSort();
         } else if (option == 2) {
            System.out.println("Sorted based on the author\n");
            myStore.insertionSort();
         }

         else if (option == 3) {
            System.out.println("Sorted based on the author and price\n");
            myStore.bubbleSort();
         } else {
            b = false;
         }
         System.out.println(myStore);
         System.out.println("\n     **************     ");
         System.out.println("Enter the title of the book to search for it: ");
         kb.nextLine();
         String t = kb.nextLine();

         Book book = myStore.binarySearch(t);
         if (book != null)
            System.out.println(book);
         else
            System.out.println("Book not found");
         System.out.println("\n");

      }

   }
}

class MyDriver {

   public static void main(String[] args) {
      Scanner kb = new Scanner(System.in);
      BookStore myStore2 = new BookStore();// creatiing the book object
      myStore2.add("Harry potter 1", "Jk Rowling", 23.99, "12345678");// using the add function
      myStore2.add("Ben Ten", "Man of action", 19.99, "2");
      myStore2.add("Naruto", "Masashi Kishimoto", 9.99, "767676576");
      myStore2.add("Demon Slayer", "Koyoharu Gotouge", 11.99, "56786565y76");
      myStore2.add("Naruto Shipudden", "Masashi Kishimoto", 12.99, "1234566576");
      myStore2.add("Dragon Ball Z", "Akira Toriyama", 13.56, "2645556");
      myStore2.add("The Flash", "Greg Berlanti", 124, "75465666");
      myStore2.add("Kotenshu", "Ekjyot", 100.00, "234545657");
      boolean b = true;
      while (b) {
         System.out.println("Enter 1 to sort based on the title");
         System.out.println("Enter 2 to sort based on the author");
         System.out.println("Enter 3 to sort based on the author, and the price");
         System.out.println("Enter any other number to quit this");
         System.out.print("Enter your choice: ");
         int option = kb.nextInt();
         kb.nextLine();
         System.out.println("\n*************");
         if (option == 1) {
            System.out.println("Sorted based on the title\n");
            myStore2.selectionSort();// using selection sort
            System.out.println(myStore2);
         } else if (option == 2) {
            System.out.println("Sorted based on the author\n");
            myStore2.insertionSort();// using the insertion sort
            System.out.println(myStore2);
         }

         else if (option == 3) {
            System.out.println("Sorted based on the author and price\n");
            myStore2.bubbleSort();// using the bubble sort
            System.out.println(myStore2);
         } else {
            b = false;// if the user nolonger wants to do it
         }

         System.out.println("\n**************     ");
         System.out.println("Do you want to look up for any book, If yes type \"yes\"");
         String s = kb.nextLine();

         if (s.equalsIgnoreCase("yes")) {

            System.out.println("Enter the title of the book to search for it: ");
            String t = kb.nextLine();

            Book book = myStore2.binarySearch(t);// using the binary search
            if (book != null)
               System.out.println(book);
            else
               System.out.println("Book not found");
            System.out.println("\n");
         }
      }

   }
}
