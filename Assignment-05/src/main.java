import java.util.Scanner;

public class main {
	
public static void main(String[] args) {
		
		int size;
		int option;
		
		hashing h = new hashing();
		Scanner scan = new Scanner(System.in);
		
		size = 20;
		
		System.out.println("PhoneBook");
		System.out.println("\n1.Create record\n2.Display record\n3.Search record\n4.Update record\n5.Delete record");
		System.out.println("\nEnter your option : ");
		option = scan.nextInt();
		
		if ( option == 1 ) {
			
			h.create_record(size);
		}
		else if ( option == 2 ) {
			
			h.display_record(size);
		}
		else if ( option == 3 ) {
			
			h.search_record(size);
		}
		else if ( option == 4 ) {
	
			h.update_record(size);
		}
		else {
			
			h.delete_record(size);
		}
	}
}
