# Data Structure & Algorithm (Java) Assignmets Solved
___
# [Assignment: 01](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-01/Readme/Assignment-01.md)
# [Assignment: 02](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-02/Readme/Assignment-02.md)
# [Assignment: 03]()
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