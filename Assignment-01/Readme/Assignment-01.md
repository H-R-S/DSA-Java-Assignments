# Data Structure & Algorithm (Java) Assignmets 01 (Solved)
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
### Code Output Screen Shot:
![output](https://github.com/H-R-S/DSA-Java-Assignments/tree/main/Assignment-01/ScreenShots/Output)