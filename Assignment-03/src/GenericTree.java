import java.util.LinkedList;
import java.util.Scanner;

public class GenericTree {
    
	class Node {
        
		String data;
        LinkedList <Node> children;

        Node(String data) {
            
        	this.data = data;
            children = new LinkedList <> ();
        }
    }

    private Node root;

    GenericTree() {
        
    	Scanner s = new Scanner(System.in);
        this.root = constructGT(s, null, 0);
    }

    private Node constructGT(Scanner s, Node parent, int i) {
        
    	if (parent == null){
            
    		System.out.println("Enter CEO Name : ");
        }
        else {
        	
        	Scanner scan = new Scanner(System.in);
        	
        	System.out.println("Enter General Manager Name : ");
            String post = scan.nextLine();
            
            System.out.println("Enter Employee Name : " + post);
        }

    	Scanner scan=new Scanner(System.in);
    	
        String data = scan.nextLine();
        Node node = new Node(data);

        System.out.println("Enter the number of employees in its under : ");
        int n = s.nextInt();

        for(int j = 0; j<n; j++){
            Node child = constructGT(s,node,j);
            node.children.add(child);
        }
      
        return node;   
    }   
}
