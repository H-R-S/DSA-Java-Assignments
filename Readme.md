# Data Structure & Algorithm (Java) Assignmets Solved
___
## Index:
- ### [Assignment: 01](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-01/Readme/Assignment-01.md)
- ### [Assignment: 02](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-02/Readme/Assignment-02.md)
- ### [Assignment: 03](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-03/Readme/Assignment-03.md)
- ### [Assignment: 04](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-04/Readme/Assignment-04.md)
- ### [Assignment: 05](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-05/Readme/Assignment-05.md)
___
# [Assignment: 01](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-01/Readme/Assignment-01.md)
#### Assignment 01 word file (with Code & ScreenShots) : [DSA_Assignment-01.docs](https://github.com/H-R-S/DSA-Java-Assignments/tree/main/Assignment-01/WordFile)
## Question:
```
function insertion(Array A)
i ← 1
while i < length(A)
    j ← i
    while j > 0 and A[j-1] > A[j]
        swap A[j] and A[j-1]
        j ← j - 1
    end while
    i ← i + 1
end while
end function

```
### Code:
#### main.java:
```
public class main {
	
	public static void main(String args[]) {
		
        int arr[] = { 34, 67, 5, 12, 6, 72, 1, 29 };
        
        InsertionSort is = new InsertionSort();
        
        is.sort(arr);
        
        is.printArray(arr); 
     
	}
}
```
#### InsertionSort.java:
```
public class InsertionSort {
	
	public void sort(int arr[])  {
		
        int n = arr.length;
        int i = 1; 
        
        while (i < n) {
        	
            int key = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] > key) {
            	
                arr[j + 1] = arr[j];
                j = j - 1;     
            }
            
            arr[j + 1] = key;
            i++;   
       }  
    }
	
    void printArray(int arr[]) {
    	
        int n = arr.length;
        
        for (int i = 0; i < n; ++i)
        	
            System.out.print(arr[i] + " ");
        
   
        System.out.println();    
   }
    
}
```
### Code Output:
```
1 5 6 12 29 34 67 72 
```
### Code Screen Shots:
#### main.java:
![main.java](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-01/ScreenShots/Code/main.JPG)
#### InsertionSort.java:
![InsertionSort.java](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-01/ScreenShots/Code/InsertionSort.JPG)
___
# [Assignment: 02](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-02/Readme/Assignment-02.md)
#### Assignment 02 word file (with Code & ScreenShots) : [DSA_Assignment-02.docs]()
## Question:
Q. Implement hash-table using separate chaining approach
### Code:
#### main.java:
```
public class main {
	
	public static void main(String[] args) {

		Map<String, Integer> map = new Map<>();
		
		map.add("Haris", 1);
		map.add("51379", 2);
		map.add("Sir Suffyan", 4);
		map.add("Data Structure & Algorithm", 5);

		System.out.println("\nMap Size : " + map.size());
		
		System.out.println("\nRemoving : " + map.remove("Sir Suffyan"));
		System.out.println("\nRemoving : " + map.remove("Data Structure & Algorithm"));

		System.out.println("\nMap Size : " + map.size());
		System.out.println("\nMap isEmpty : " + map.isEmpty());
	}	
}
```
#### HashNode.java:
```
import java.util.ArrayList;
import java.util.Objects;

class HashNode<K, V> {
	
	K key;
	V value;
	final int hashCode;

	HashNode<K, V> next;

	public HashNode(K key, V value, int hashCode) {

		this.key= key;
		this.value = value;
		this. hashCode = hashCode;
	}
}

class Map<K, V> {
	
		private ArrayList<HashNode<K, V>>bucketArray;
		private int numBuckets;
		private int size;

		public Map() {

			bucketArray= new ArrayList<>();
			numBuckets = 10;
			size = 0;

			for (int i= 0; i<numBuckets; i++)

				bucketArray.add(null);
		}
		
		public int size() { return size; }
		public boolean isEmpty() { return size () == 0;}
		private final int hashCode (K key) {
			
			return Objects.hashCode(key);
		}

		private int getBucketindex(K key) {
			
			int hashCode = hashCode(key);
			int index= hashCode % numBuckets;
			index = index < 0 ? index *- 1: index;

			return index;
		}

		public V remove(K key) {

			int bucketIndex= getBucketindex(key);
			int hashCode = hashCode(key);
			HashNode<K, V> head = bucketArray.get(bucketIndex);
			HashNode<K,V > prev= null;

			while (head != null) {

				if (head.key.equals(key) && hashCode == head.hashCode)
					break;

				prev = head;
				head = head.next;
			}
			
			if (head == null)

				return null;
			
			size--;

			if (prev != null) {

				prev.next = head.next;
			}
  			else {

				bucketArray.set(bucketIndex, head.next);
				return head.value;
  			}
			return head.value;
		}

		public V get(K key) {

			int bucketindex = getBucketindex(key);
			int hashCode = hashCode(key);
			HashNode<K, V> head = bucketArray.get(bucketindex);

			while (head != null) {

				if (head .key.equals(key) && head.hashCode==hashCode)
					
					return head.value;
				
				head= head.next;
			}

			return null;
		}

		public void add(K key, V value) {

			int bucketindex = getBucketindex(key);
			int hashCode = hashCode(key);
			HashNode<K, V> head = bucketArray.get(bucketindex);

			while (head != null) {

				if (head.key.equals(key) && head.hashCode == hashCode) {

					head.value = value;
					return;
				}
				
				head = head.next;
			}

			size++;
			
			head = bucketArray.get(bucketindex);
			HashNode<K, V> newNode = new HashNode<K, V> (key, value, hashCode);
			newNode.next= head;
			bucketArray.set(bucketindex, newNode);

			if ((1.0 * size) / numBuckets >= 0.7) {

				ArrayList<HashNode<K, V> > temp = bucketArray;
				bucketArray = new ArrayList<>();
				numBuckets = 2 * numBuckets;
				size = 0;

				for (int i=0; i<numBuckets; i++)

					bucketArray.add(null);

				for (HashNode<K, V> headNode : temp) {

					while (headNode != null) {

						add(headNode.key, headNode.value);
						headNode = headNode.next;
					}
				}
			}
		}
}
```
### Code Output:
```

```
### Code Screen Shots:
#### main.java:
![main.java](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-02/ScreenShots/Code/main.JPG)
#### HashNode.java:
![HashNode.java_ss1](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-02/ScreenShots/Code/HashNode_ss1.JPG)
![HashNode.java_ss2](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-02/ScreenShots/Code/HashNode_ss2.JPG)
![HashNode.java_ss3](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-02/ScreenShots/Code/HashNode_ss3.JPG)
![HashNode.java_ss4](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-02/ScreenShots/Code/HashNode_ss4.JPG)
### Code Output Screen Shot:
![output](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-02/ScreenShots/Output/output.JPG)
___
# [Assignment: 04](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-04/Readme/Assignment-04.md)
#### Assignment 04 word file (with Code & ScreenShots) : [DSA_Assignment-04.docs]()
## Question No 01:									5 Marks
Consider the set of 6 processes whose arrival time and burst time are given below-

![question](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-04/ScreenShots/Question/question.JPG)

If the CPU scheduling policy is Round Robin with time quantum = 2, 
calculate the average waiting time and average turnaround time. (Show all steps of solution)
Implement Round Robin policy in Java Programming language 
Note: C language code is already available in Lab Manual
### Code:
#### main.java:
```
public class main {
	
	public static void main(String args[]) throws Exception {

		scheduling ob = new scheduling();

		ob.roundrobin();

	}
}
```
#### scheduling.java:
```
import java.io.*;

public class scheduling {
	
	public void roundrobin() throws Exception, IOException {
	
		System.out.println("______Round Robin Algorithm______ (Name: Haris, Reg.No: 51379)");
		System.out.println("\nEnter the number of processes : ");

		int n;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		int a[] = new int[n],b[] = new int[n];
		int r[] = new int[n],e[] = new int[n],c,t,tq;

		for(c=0;c<n;c++) {

			System.out.println("\nEnter arrival time for process : " + (c+1));

			a[c] = Integer.parseInt(br.readLine());

			System.out.println("Enter burst time for process : " + (c+1));

			b[c] = Integer.parseInt(br.readLine());

			r[c]=b[c];

		}

		System.out.println("\nEnter quantum time (Q) : ");

		tq = Integer.parseInt(br.readLine());

		for(t=a[0];;) {

			for(c=0;c<n;c++) {

				if(a[c]<=t&&r[c]!=0) {

					if(r[c]<=tq) {

						t+=r[c];
						r[c]=0;
						e[c]=t;
					}
					else {

						r[c]-=tq;
						t+=tq;
					}
				}
			}
			for(c=0;c<n;c++)

				if(r[c]!=0)

					break;

			if(c==n)

				break;

		}

		float aw=0,at=0;

		System.out.println("\nProcess No.\tWaiting Time\tTurn Around Time");

		for(c=0;c<n;c++) {

			aw+=e[c]-a[c]-b[c];

			at+=e[c]-a[c];

			System.out.println((c+1)+"\t"+(e[c]-a[c]-b[c])+"\t"+(e[c]-a[c]));

		}
		System.out.println("\nAverage Waiting Time : "+(aw/n));
		System.out.println("\nAverage Turn Around Time : "+(at/n));
	}
}
```
### Code Output:
```
______Round Robin Algorithm______ (Name: Haris, Reg.No: 51379)

Enter the number of processes : 
8

Enter arrival time for process : 1
0
Enter burst time for process : 1
4

Enter arrival time for process : 2
1
Enter burst time for process : 2
5

Enter arrival time for process : 3
2
Enter burst time for process : 3
2

Enter arrival time for process : 4
3
Enter burst time for process : 4
1

Enter arrival time for process : 5
4
Enter burst time for process : 5
6

Enter arrival time for process : 6
6
Enter burst time for process : 6
3

Enter arrival time for process : 7
4
Enter burst time for process : 7
3

Enter arrival time for process : 8
2
Enter burst time for process : 8
1

Enter quantum time (Q) : 
2

Process No.	Waiting Time	Turn Around Time
1		12		16
2		17		22
3		2		4
4		3		4
5		15		21
6		12		15
7		15		18
8		11		12

Average Waiting Time : 10.875

Average Turn Around Time : 14.0
```
### Code Screenshots:
#### main.java:
![main](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-04/ScreenShots/Code/main.jpg)
#### scheduling.java:
![scheduling_ss1](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-04/ScreenShots/Code/scheduling_ss1.JPG)
![scheduling_ss2](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-04/ScreenShots/Code/scheduling_ss2.JPG)
![scheduling_ss3](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-04/ScreenShots/Code/scheduling_ss3.JPG)
### Code Output Screenshots:
![output_ss1](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-04/ScreenShots/Output/output_ss1.JPG)
![output_ss2](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-04/ScreenShots/Output/output_ss2.JPG)
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