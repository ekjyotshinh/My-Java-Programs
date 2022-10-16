/*
 name: EKJYOT SINGH SHINH
 Date:June 8, 2022
 My expected grade for this assignment is 100 since all the requirements are fulfilled
 */

public class PayrollShinh
{   //list of the instnace variables
    private String employeeName="";
    private String ID="";
    private double payRate=0;
    private double hours=0;
    
    
    //constructor
    public PayrollShinh(String employeeName,String ID, double payRate, double hours)
    {
        //This code assigns the values to the variables created above
        this.employeeName=employeeName;
        this.ID = ID;
        this.payRate = payRate;
        this.hours=hours;
        
    }
    
   
    //getter methods: implement all the getter methods
    public String getName() //Meathod that returns the name(type string)
    {
        return employeeName;
    }
    
    public String getID() //Meathod that returns the ID(type string)
    {
        return ID;
    }
    
    public double getPayRate() //Meathod that returns the pay rate(typr double)
    {
        return payRate;
    }
    
    public double getHours() //Meathod that returns the number of hours worked(type double)
    {
        return hours;
    }
    
    
    //setter methods: implement all the setter methods
    public void setEmployeeName( String employeeName) // This meathod replace the old name by the new name
    {
        this.employeeName=employeeName;
    }
    
    public void setID( String ID) // This meathod replace the old ID by the new ID
    {
        this.ID=ID;
    }
    
    public void setPayRate( double payRate)  // This meathod replace the old pay rate by the new pay rate
    {
        this.payRate=payRate;
    }
    
    public void setHoursWorked( double hours) // This meathod replace the old number of hours by the new ones
    {
        this.hours=hours;
    }
        
    public  double getPay()  // This meathod calculates the pay of an individual by multipluing the hours worked by the pay rate
    {
        
        double total = payRate*hours;
        
        return total;
     }
     //toString method
   public String toString()
   {
    
      String s = "Name : " + getName();
      s = s + "\nID : " + getID();
      s= s+ "\nHours Worked:  " + getHours();
      s = s + "\nHourly Rate:  " + getPayRate();
      return s;
   }

    
    }

 
class PayrollDriver
{
  public static void main(String[] args)
  {
   
  // The code that was already given in the java shell
    System.out.println("Cretaing payroll objects");
    PayrollShinh p1 = new PayrollShinh("Alex Martinez" ,"123456", 25, 20);
    PayrollShinh p2 = new PayrollShinh("Ali Santos" ,"986747", 125, 45);
    PayrollShinh p3 = new PayrollShinh(" Jose Busta" ,"45678", 55, 30);
    System.out.println("testing the toString method");
    System.out.println("List of the employees");
    System.out.println(p1);
    System.out.println("Salary is : " + p1.getPay());  //calling the getPay method
    System.out.println("\n*******************");
    System.out.println(p2);
    System.out.println("Salary is : "+ p2.getPay());
    System.out.println("\n*******************");
    System.out.println(p3);
    System.out.println("Salary is : "+ p3.getPay());
    System.out.println("\n*******************");
    System.out.println("\nTesting the setter methods");
    System.out.println("The hourly pay of " + p1.getName()  + " is being chnaged");
    p1.setHoursWorked(80);  // changing the hours worked for the object p1
    System.out.println(p1);                   
    System.out.println("\n*******************");
    
    
    //***********************************************************************************
    
    
    /*        The code writtten by me following the instructions given       */
     
    //createing two objects of the payroll class
    PayrollShinh p4  = new PayrollShinh("Aman Aulakh","987654",160, 48);
    PayrollShinh p5 = new PayrollShinh("Ivan Ieara" ,"758666", 125, 45); 
    
   // displaying the objects on the screen 
    System.out.println(p4);
    System.out.println("Salary is : "+ p4.getPay());
    System.out.println("\n*******************");
    System.out.println(p5);
    System.out.println("Salary is : "+ p5.getPay());
    System.out.println("\n*******************");
    
    //changing the hourlyRate of the objects by using setter meathod
    System.out.println("\nTesting the setter methods by changing pay rates");
    p4.setPayRate(33);
    p5.setPayRate(34);
    
    
    //displaying the objects again to see the changes made using setter meathods
    System.out.println(p4);
    System.out.println("Salary is : "+ p4.getPay());
    System.out.println("\n*******************");
    System.out.println(p5);
    System.out.println("Salary is : "+ p5.getPay());
    System.out.println("\n*******************");
    
    
    //changing the hoursworked for the objects created by calling the setter methods
    System.out.println("\nTesting the setter methods by changing hours worked");
    p4.setHoursWorked(69);
    p5.setHoursWorked(96);
    
    
    //displaying the objects again to see the changes made using seter meathods
    System.out.println(p4);
    System.out.println("Salary is : "+ p4.getPay());
    System.out.println("\n*******************");
    System.out.println(p5);
    System.out.println("Salary is : "+ p5.getPay());
    System.out.println("\n*******************");
  }
}