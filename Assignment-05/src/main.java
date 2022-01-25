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
