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
}	}