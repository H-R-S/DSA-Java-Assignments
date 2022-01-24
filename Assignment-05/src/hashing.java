import java.util.Scanner;

public class hashing {
		
	Node node = new Node();
	Scanner scan = new Scanner(System.in);
	
	private Node[] data = new Node[100];
	private String n;
	private int t;
	private int i;
	private int index;
	
	public hashing() {
	
		i = 0;
		t = 0;
	}
	
	public void create_record(int size) {
			
		i = 1;
		n = "Muhammad Haris";
		t = 03112224501;
	
		System.out.print("\nEnter id : ");
		i = scan.nextInt();
			
		System.out.print("\nEnter Name : ");
		n = scan.next();
			
		System.out.print("\nEnter Telephone Number : ");
		t = scan.nextInt();
			
		index = i % size;
		
		for (int j = 0; j < size; j++) {
	
			if (data[index].id == 0) {
	
				data[index].id = i;
				data[index].name = n;
				data[index].tel = t;
			}
			else {
	
				index = (index + 1) % size;
			}
		}
	}
		
	public void search_record(int size) {
	
		int index1;
		int key;
		int flag = 0;
		key = 4;
	
		System.out.print("\nEnter record id to search : ");
		key = scan.nextInt();
	
		index1 = key % size;
		
		for (int a = 0; a < size; a++) {
	
			if (data[index1].id == key) {
					
				flag = 1;
	
				System.out.print("\nRecord found");
				System.out.print("\n\tID : " + data[index1].id);
				System.out.print("\tNAME : " + data[index1].name);
				System.out.print("\t\tTELEPHONE : " + data[index1].tel);
			}
			else {
				index1 = (index1 + 1) % size;
			}
				
			if (flag == 0) {
			
				System.out.print("\nRecord not found");
			}
		}
	}
			
	public void delete_record(int size) {

		int index1;
		int key;
		int flag = 0;
		key = 4;
		
		System.out.print("\nEnter record id to delete : ");
		key = scan.nextInt();
		
		index1 = key % size;
		
		for (int a = 0; a < size; a++) {
			
			if (data[index1].id == key) {
				
				flag = 1;
				data[index1].id = 0;
				data[index1].name = " ";
				data[index1].tel = 0;
					
				System.out.print("\nRecord deleted successfully");
			}
			else {
					
				index1 = (index1 + 1) % size;
			}
		}
			
		if (flag == 0) {
	
			System.out.print("\nRecord not found");
		}
	}
		
	public void update_record(int size) {
					
		int index1;
		int key;
		int flag = 0;
		key = 4;
		
		System.out.print("\nEnter record id to update : ");
		key = scan.nextInt();
		
		index1 = key % size;
			
		for (int a = 0; a < size; a++) {

			if (data[index1].id == key) {

				flag = 1;
			}
			else {
	
				index1 = (index1 + 1) % size;
			}
				
			if (flag == 1) {
				
				n = "Muhammad Haris";
				t = 03112224501;
				
				data[index1].name = n;
				data[index1].tel = t;
					
				System.out.print("\nEnter name : ");
				n = scan.next();
				
				System.out.print("\nEnter telephone number : ");
				t = scan.nextInt();
				
				System.out.print("\nDetails updated: ");
				System.out.print("\nID : " + data[index1].id);
				System.out.print("\nName : " + data[index1].name);
				System.out.print("\nTELEPHONE : " + data[index1].tel);
			}
		}
	}
		
	public void display_record(int size) {
		
		System.out.print("\n\tID \tNAME \t\tTELEPHONE ");
		
		for (int a = 0; a < size; a++) {
			
			if (data[a].id != 0) {
		
				System.out.print(data[a].id);
				System.out.print(data[a].name);
				System.out.print(data[a].tel);
			}
		}
	}
}