# Data Structure & Algorithm (Java) Assignmets 05 (Solved)
___
# [Assignment: 05](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-05/Readme/Assignment-05.md)
#### Assignment 05 word file (with Code & ScreenShots) : [DSA_Assignment-05.docs]()
## Question No 01:	
Create A HashTable For This PhoneBook Class. hashtable stores  phone number, name of the user,  Phone number will be used for hash function . you are required to store 10 records .
Use double hashing for collision.
### Code:
#### main.java:
```
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		
		PhoneBook pb = new PhoneBook();

        pb.lphonebook = pb.lRead();

        int lch;
        char lcn = 'y';

        Scanner scan = new Scanner(System.in);

        while(lcn == 'y') {

            pb.lSMenu();

            System.out.println("Enter your choice:");

            lch = scan.nextInt();

            switch(lch) {

                 case 1:
              	   pb.lView();
              	   break;

                 case 2:
              	   pb.ladd();
              	   break;

                 case 3:
              	   pb.ldelete();
              	   break;

                 case 4:
              	   pb.lsName();
              	   break;

                 case 7:
              	   System.exit(0);
              	   break;

                 default: 
              	   System.out.println("\nInvalid choice!");

            }
            
            try {

          	  InputStreamReader lIsr=new InputStreamReader(System.in);

          	  System.out.println("\nPress 'y' to continue : ");

          	  lcn=(char)lIsr.read();

            }

            catch(IOException ie) { }
        }
   }
}
```
#### PhoneBook.java:
```
import java.awt.Desktop;
import java.io.*;
import java.util.Enumeration;
import java.util.Hashtable;

public class PhoneBook {

	static Hashtable<String,lPhEntry> lphonebook;

     public static void lView() {

          if (lphonebook != null) {

        	  for(Enumeration<String> e=lphonebook.keys(); e.hasMoreElements();) {
        		  
        		  lPhEntry entry=lphonebook.get(e.nextElement());

        		  entry.lprintInfo();
              }
          }
          
          System.out.println("\nThe phone book is empty!");
     }

     public static void ladd() {

          if(lphonebook==null)

        	  lphonebook=new Hashtable<String,lPhEntry>();

        	  try {

        		  BufferedReader lbr=new BufferedReader(new InputStreamReader(System.in));

        		  System.out.println("\nEnter Name : ");
        		  String lname = lbr.readLine();

        		  System.out.println("Enter Phone Number : ");
        		  String lphone=lbr.readLine();

        		  lPhEntry st=new lPhEntry(lname,lphone);

        		  lphonebook.put(lname,st);

        		  lwriteIt(lphonebook);
        	  }
        	  
        	  catch(IOException e) { }
     }

     public static void ldelete() {

          if(lphonebook!=null) {

              int lSi=lphonebook.size();

              try {

            	  BufferedReader lbr=new BufferedReader(new InputStreamReader(System.in));

            	  System.out.println("\nName : ");
            	  String lkey=lbr.readLine();

            	  lphonebook.remove(lkey);

            	  if(lphonebook.size()<lSi) {

                        lwriteIt(lphonebook);

                        System.out.println("\nThe Entry has been deleted.");
            	  }
            	  else

            		  System.out.println("\nInvalid User!");
              }
              catch(IOException ie) { }
          }
     }

     public static void lsName() {

          if(lphonebook!=null) {

              try {

            	  BufferedReader lbr=new BufferedReader(new InputStreamReader(System.in));

            	  System.out.println("\nSearch by name : ");
            	  String lkey = lbr.readLine();

            	  lPhEntry cu=lphonebook.get(lkey);

                   if(cu!=null)

                	   cu.lprintInfo();
                   
                   else
                   
                	   System.out.println("\nUser Not found!");
              }
              catch(IOException ie) { }            
          }
     }

     public static void lwriteIt(Hashtable<String,lPhEntry> obj) {
          
    	 try {

    		 FileOutputStream lfs=new FileOutputStream("phonebook.bin");
    		 ObjectOutputStream lOos=new ObjectOutputStream(lfs);

    		 lOos.writeObject(obj);
             lOos.flush();
             lOos.close();              
          }
          catch(IOException ie) { }
     }

     public static Hashtable<String,lPhEntry> lRead() {

    	 Hashtable<String,lPhEntry> phbook=null;

    	 try {
        
    		 FileInputStream lFis=new FileInputStream("phonebook.bin");
    		 ObjectInputStream lOis=new ObjectInputStream(lFis);
    		 
    		 phbook = (Hashtable<String,lPhEntry>)lOis.readObject();
    		 lOis.close();
          }
          catch(Exception ie) { }
          
    	 return phbook;
     }

     public static void lDReport(String lsrc) {

          try {

              if(Desktop.isDesktopSupported()) {
            	  
                   File lf=new File(lsrc);
                   Desktop.getDesktop().open(lf);
              }
          }
          
          catch(IOException ie){}
     }

     public static void lSMenu() {

          System.out.println("\n1. View all phonebook entries");
          System.out.println("2. Add entry ");
          System.out.println("3. Remove entry");
          System.out.println("4. Find entry");
          System.out.println("7. Exit");
     }
}
```
#### lPhEntry.java:
```
import java.io.Serializable;

class lPhEntry implements Serializable {

     private String lName;
     private String lPhone;

     lPhEntry(String lname,String lphone) {

          this.lName=lname;
          this.lPhone=lphone;
     }

     public String lgetName() {
          
    	 return lName;
     }

     public String lgetPhone() {

          return lPhone;
     }

     public void lprintInfo() {
    	 
          System.out.println("\nName : " + lName + ", Phone : " + lPhone);
     }
}
```
### Code Output:
```
1. View all phonebook entries
2. Add entry 
3. Remove entry
4. Find entry
7. Exit
Enter your choice:
1

The phone book is empty!

Press 'y' to continue : 
y

1. View all phonebook entries
2. Add entry 
3. Remove entry
4. Find entry
7. Exit
Enter your choice:
2

Enter Name : 
Haris
Enter Phone Number : 
03112224501

Press 'y' to continue : 
y

1. View all phonebook entries
2. Add entry 
3. Remove entry
4. Find entry
7. Exit
Enter your choice:
2

Enter Name : 
Amir Liaquat
Enter Phone Number : 
1234

Press 'y' to continue : 
y

1. View all phonebook entries
2. Add entry 
3. Remove entry
4. Find entry
7. Exit
Enter your choice:
2

Enter Name : 
Imran Khan
Enter Phone Number : 
1312312

Press 'y' to continue : 
y

1. View all phonebook entries
2. Add entry 
3. Remove entry
4. Find entry
7. Exit
Enter your choice:
2

Enter Name : 
Nawaz Shareef
Enter Phone Number : 
420

Press 'y' to continue : 
y

1. View all phonebook entries
2. Add entry 
3. Remove entry
4. Find entry
7. Exit
Enter your choice:
2

Enter Name : 
Ali
Enter Phone Number : 
231231

Press 'y' to continue : 
y

1. View all phonebook entries
2. Add entry 
3. Remove entry
4. Find entry
7. Exit
Enter your choice:
3

Name : 
Ali

The Entry has been deleted.

Press 'y' to continue : 
y

1. View all phonebook entries
2. Add entry 
3. Remove entry
4. Find entry
7. Exit
Enter your choice:
4

Search by name : 
Nawaz Shareef

Name : Nawaz Shareef, Phone : 420

Press 'y' to continue : 
y

1. View all phonebook entries
2. Add entry 
3. Remove entry
4. Find entry
7. Exit
Enter your choice:
1

Name : Imran Khan, Phone : 1312312

Name : Haris, Phone : 03112224501

Name : Amir Liaquat, Phone : 1234

Name : Nawaz Shareef, Phone : 420

The phone book is empty!

Press 'y' to continue : 
y

1. View all phonebook entries
2. Add entry 
3. Remove entry
4. Find entry
7. Exit
Enter your choice:
7
```
### Code Screen Shots:
#### main.java:
![main_ss1](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-05/ScreenShots/Code/main_ss1.JPG)
![main_ss2](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-05/ScreenShots/Code/main_ss2.JPG)
#### PhoneBook.java:
![PhoneBook_ss1](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-05/ScreenShots/Code/PhoneBook_ss1.JPG)
![PhoneBook_ss2](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-05/ScreenShots/Code/PhoneBook_ss2.JPG)
![PhoneBook_ss3](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-05/ScreenShots/Code/PhoneBook_ss3.JPG)
![PhoneBook_ss4](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-05/ScreenShots/Code/PhoneBook_ss4.JPG)
#### lPhEntry.java:
![lPhEntry](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-05/ScreenShots/Code/lPhEntry.JPG)
### Code Output Screen Shot:
![output_ss1](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-05/ScreenShots/Output/output_ss1.JPG)
![output_ss2](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-05/ScreenShots/Output/output_ss2.JPG)
![output_ss3](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-05/ScreenShots/Output/output_ss3.JPG)
![output_ss4](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-05/ScreenShots/Output/output_ss4.JPG)
![output_ss5](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-05/ScreenShots/Output/output_ss5.JPG)