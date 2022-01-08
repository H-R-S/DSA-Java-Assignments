public class main {
	
	public static void main(String args[]) {
		
        int arr[] = { 34, 67, 5, 12, 6, 72, 1, 29 };
        
        InsertionSort is = new InsertionSort();
        
        is.sort(arr);
        
        is.printArray(arr); 
     
	}
}
