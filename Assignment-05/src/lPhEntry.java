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
