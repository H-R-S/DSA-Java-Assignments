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
