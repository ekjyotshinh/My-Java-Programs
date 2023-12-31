
/*
 name: EKJYOT SINGH SHINH
 Date:June 12, 2022
 My expected grade for this assignment is 100 since all the requirements are fulfilled
 */
import java.util.*;

public class DocumentShinh // <-------add your last name here
{
  // no code goes here. Must leave empty
}

class Document {
  // list of the instnace variables
  private String content;

  public Document(String text) {
    content = text;// This code assigns the values to content
  }

  // getter methods: implement all the getter methods
  public String getContent() // Meathod that returns the content(type string)
  {
    return content;
  }

  // setter methods: implement all the setter methods
  public void setContent(String text) // This meathod replace the old Content by the new Content
  {
    content = text;
  }

  // toString method
  public String toString() {

    String s = "Content : " + getContent();

    return s;
  }

  public int getDocumentLength() // This meathod calculates the number of letters in the content and return it
  {

    int length = content.length();

    return length;
  }

  // This meathod checks if the content containts the word
  public Boolean contains(String keyword) {
    return content.contains(keyword);
  }

  // This meathod checks if the content is equal to this
  public Boolean equals(Document other) {
    return this.content.equalsIgnoreCase(other.content);
  }

}

class Email extends Document {
  // your code, read the provided documnet before implementing
  // list of the instnace variables
  private String sender = "";
  private String recipient = "";
  private Date date;
  private String subject = "";
  private String cc = "";
  private boolean iSent;

  public Email(String text, String sender, String recipient, String subject, String cc) { // This code assigns the
                                                                                          // values to the variables
                                                                                          // created above
    super(text);// using supereference
    this.sender = sender;
    this.recipient = recipient;
    this.subject = subject;
    this.cc = cc;
    date = new Date();// using the date class

  }

  public void send()// this meathod sends the mail ie. sets the iSent boolean to true
  {
    iSent = true;
  }

  // getter methods: implement all the getter methods
  public boolean getSent() // returns the instance variable isSent
  {
    return iSent;
  }

  public String getSender() // returns the instance variable sender
  {
    return sender;
  }

  public String getRecipient() // returns the instance variables recipient
  {
    return recipient;
  }

  public String getSubject() // returns the instance variable subject
  {
    return subject;
  }

  public String getCC() // returns the instance variable cc
  {
    return cc;
  }

  public Date getDate() // returns the date instance variable
  {
    return date;
  }
  // setter methods: implement all the setter methods

  public void setSender(String s) // changes the string value of sender to the new one
  {
    sender = s;
  }

  public void setRecipient(String r) // changes the string value of recipient to the new one
  {
    recipient = r;
  }

  public void setSubject(String s)// changes the string value of subject to the new one
  {
    subject = s;
  }

  public void setCC(String c)// sets the string value of CC to the new one if the email wasn't sent
  {

    if (iSent = false) // checking if the mail was sent or not
    {
      cc = c; // if the mail wasnt sent then the value of cc can be set
    } else {
      System.out.println("This email has been sent and the CC cannot be modified");
    }

  }

  // toString method
  public String toString() {
    String s = "Sender : " + getSender();
    s = s + "\nRecipient : " + getRecipient();
    s = s + "\nSubject:  " + getSubject();
    s = s + "\nCC:  " + getCC();
    s = s + "\nDate:  " + getDate();
    s = s + "\nContent:  " + super.toString();// using super reference
    return s;

  }

  // this meathod modify the content of the mail if the mail hasnt been sent
  public void modifyContent(String s) {
    if (iSent = false)// checking if the mail was sent or not
    {
      super.setContent(s);// if the mail wasnt sent then the value of content can be set

    } else // if the mail wasnt sent then the value of content cannot be set
    {
      System.out.println("This email has been sent and the content cannot be modified");
    }

  }

  // this meathod forwards the email
  public Email forward(String rec, String sender, String cc) {
    Email f = new Email(this.getContent(), sender, rec, this.subject, cc);
    f.date = new Date();
    f.iSent = true;
    return f;
  }

}

// ****************************************************************************************

// uncommnet this driver class once you have implemented the Documnet class and
// the Email class

class EmailDriver {
  // public Email(String text, String sender,String recipiant, String subject,
  // String cc)
  public static void main(String[] args) {
    // creating an Email object
    Email e1 = new Email("Hello everyone, we will have a meeting tomorrow at 10", "Gita Faroughi", "Alex", "Meeting",
        "");

    // sending the email
    e1.send();

    // disply the details about the email
    System.out.println(e1);
    System.out.println("\n\n");

    // searching the email for the email for the word tomorrow
    boolean b = e1.contains("tomorrow");
    if (b)
      System.out.println("The word tomorrow was  found in the email");
    else
      System.out.println("The word tomorrow was found in the email");

    // displaying just the content(text) of the email
    System.out.println("\nThe content of this email is: " + e1.getContent());
    System.out.println();
    // modifying the content of the email
    e1.modifyContent("bye");

    // modifying the cc of the email
    e1.setCC("Nick");

    // changing the recipient of the e1 email
    e1.setRecipient("Jose@yahoo.com,Mary@gmail.com");
    System.out.println();

    // forwarding the email
    Email forward = e1.forward("Alex", "Gita", "Maria");
    System.out.println();

    // printing the forwarded email
    System.out.println("forwarded message\n" + forward);
    System.out.println();

    // display the length of the text in the email
    System.out.println("The number of the letters in the email is: " + e1.getDocumentLength());

    // ***********************************************************************
    // your turn, refer to the provided documnet on the codes you need to write

  }
}