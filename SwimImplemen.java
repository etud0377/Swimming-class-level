
/*
   Name: Etu Das
   
  
   Description:
   
   This program offers swimming classes to children age of 6 to 11. This object oriented program allows the user to enter child name, child age, 
   parent name, parent phone number, and parent email. The phone number must be verified and in the format of YYY.YYY.YYYY. The email must have only one
   '@' and a '.' that is folllowed by at least two characters. The user will be given a menue to select the four classes offered. These classes are,
   Intro Level, Intermediate Level, Advance Level, and Expert Level. Each class is bill for $250 per course, except expert which costs $350. The user will also be prompted to
   choose if he/she has a scholarship. If they do, they will get a discount. The user will be given a main menue that has add child, enroll, child, remove enroll child, print summary,
   and quit option. The user may press 1 and select add child. This will allow the user to add a child based on the information provided before. The enroll child will enroll a child (if any)
   to one of the classes. The remove child will remove the enrolled child from that selective course. 
   The quit option (5) will quit the program. 
   
  */
 import javax.swing.JOptionPane;
public class SwimImplemen {
   public static void main (String[] args){
   
   Swimming[] swim1 = new Swimming[100];
        int childAge = 0;
        int childCounter = 0;
        String parentName = "";
        String userInput = "";
        String parentNumber = "";
        String childName = "";
        String email = "";
        //inside a do while because we looping again and again if they get wrong. 
        do{
            int opp = menu();
   //doing a switch for the menue and the class options for the user
            switch (opp) {
            //adding a child
                case 1:
                     char takeInput = JOptionPane.showInputDialog(null, "Do you have scholarships?(Y for yes, N for no) " ).charAt(0);
                     //calling the methods
                    childName = getChildName();
                    childAge = getChildAge();
                    parentName = getParentName();
                    parentNumber = getParentNumber();
                    email = getEmail();
                     Swimming swim2 = new Swimming(childName, childAge, parentName, parentNumber, email );
                     //inputting takeInput for the organization name/discount name.
                    if (takeInput == 'y' || takeInput == 'Y') {
                        String orgInput = JOptionPane.showInputDialog(null, "Enter the organization name: ");
                        double discInput = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter discount amount: "));
                        swim2 = new Scholarships( childName, childAge, parentName,  parentNumber, email, orgInput, discInput);
                    }
                    //setting maximum to 100.
                    childCounter++;
                      if(!(childCounter >= 100)) {
                       swim1 = addArr(swim1, swim2);
                      } else{
                                           
                        JOptionPane.showMessageDialog(null, "Full, can't add any more children");
                    }
                                      
                     
                    break;
                
                case 3:
                //I switched the cases, this will allow the user to delete an enrolled child.
                    if (childCounter == 0){
                        JOptionPane.showMessageDialog(null, "ERROR! No child to choose");
                        break;
                    }
                    swim1 = delClass(swim1);
                    childCounter--;
                    break;
                
                case 2: 
                    //enrolling a child
                    String out = "All Childs\n";
                    for (int i = 0; i < swim1.length; ++i){
                        if (swim1[i] == null){
                            out += i + " : Empty\n";
                        } else {
                            out += i + " : " + swim1[i]+ "\n" ;
                        }
                    }
     
                    int clockOp = Integer.parseInt(JOptionPane.showInputDialog(null, out + "Enter an option: "));
                    int chooseOp = Integer.parseInt(JOptionPane.showInputDialog(null, "\tCLASS MENU\n\n1.Intro Level\n2. Intermediate Level\n3. Advance Level\n4. Expert Level"));
                    //nice
                    swim1[clockOp].aSCounter(chooseOp - 1);
                    break;
                
                case 4:
                //Displays information about the children
                    String o = "All Childs\n";
                    for (int i = 0; i < swim1.length; i++){
                        if (swim1[i] == null){
                            o += i +" : Empty";
                        }else{
                            o += i +" : " + swim1[i]+"\n";
                        }
                    }
     
                    JOptionPane.showMessageDialog(null, o);
                    break;
                    
                case 5:
                // quits the program if they press 5.
                JOptionPane.showMessageDialog(null, "Thank you for using this program");
                  userInput = "n";
                 break;
                 
                default :
                    JOptionPane.showMessageDialog(null,"ERROR! Enter value 1-5");
 
                }

            }while(!userInput.equalsIgnoreCase("n"));
  }
     
     //method for menue/ validating
     public static int menu(){
      int showOption = 0;
      do{
         showOption = Integer.parseInt(JOptionPane.showInputDialog(null, "\tCLASS MENU\n\n1. Add Child\n2. Enroll Child\n3. Remove Enroll Child\n4. Print Child Record\n5. Quit"));

         if (showOption < 1 || showOption > 5) {JOptionPane.showMessageDialog(null, "Incorrect number, try again");}
      } while (showOption < 1 || showOption > 5);

      return showOption;
   }

   //method for deleting a child
     public static Swimming[] delClass(Swimming[] arr){

      String lol = "All classes\n";
      for (int i = 0; i < arr.length; i++){
            lol += i +" : " + arr[i];
         }
         
      JOptionPane.showMessageDialog(null, lol);

      int deleteOp = Integer.parseInt(JOptionPane.showInputDialog(null, "Which child would you like to delete: "));

      arr[deleteOp] = null;

      return arr;
      }
      //adding child   array method

      public static Swimming[] addArr(Swimming[] swim1, Swimming addEle){
         Swimming[] swim3 = new Swimming[swim1.length];
         boolean addCC = false;
         for (int i = 0; i < swim1.length; ++i){
            swim3[i] = swim1[i];
         if (swim1[i] == null && addCC == false){
            swim3[i] = addEle;
            addCC = true;
         }
      }
      
      return swim3;
      
   }
         //validating parentName
     public static String getParentName() {
        String parentName;
        do {
            try {
                parentName = JOptionPane.showInputDialog(null,"Please Enter Parent Name: ");
            }
            catch (IllegalArgumentException e) {
                parentName = "";
            }
            if (parentName.equals("") || parentName == null) {
              JOptionPane.showMessageDialog(null,"Please enter a valid name");               
            }
        }while (parentName.equals("") || parentName == null);
        return parentName;
   }
   //validating childName
   public static String getChildName() {
        String childName;
        do {
            try {
                childName = JOptionPane.showInputDialog(null,"Please Enter Your Child's Name: ");
            }
            catch (IllegalArgumentException e) {
                childName = "";
            }
            if (childName.equals("") || childName == null) {
              JOptionPane.showMessageDialog(null,"Please enter a valid name");               
            }
        }while (childName.equals("") || childName == null);
        return childName;
   }
   //validating childAge
   public static int getChildAge() {
        int childAge = 0;
        do {
            try {
                childAge = Integer.parseInt(JOptionPane.showInputDialog(null, "Please Enter Your Child's Age: "));
            }
            catch (IllegalArgumentException e) {
                childAge = -1 ;
                }
                if (childAge < 6 || childAge > 11){
                    JOptionPane.showMessageDialog(null, "Try Again");
               }
         }
        while (childAge < 6 || childAge > 11);
            return childAge;
        }
        //validating parentNumber
   public static String getParentNumber() {
      String parentNumber;
      do {
            try {
                parentNumber = JOptionPane.showInputDialog(null,"Please Enter Your Phone Number Using This Format 'yyy.yyy.yyyy' : ");
            }
            catch (IllegalArgumentException e) {
                parentNumber = "";
            }
            if( parentNumber.equals("")){
                JOptionPane.showMessageDialog(null,"Try again");
        }   
       } while (parentNumber.equals(""));
               return parentNumber;
   }
   
   //validating email.
   public static String getEmail() {
      String email;

      do {
            try {
                email = JOptionPane.showInputDialog(null,"Please Enter Your Email adress: ");
            }
            catch (IllegalArgumentException e) {
                email = "";
            }
 
            if (email.equals("") ){
               JOptionPane.showMessageDialog(null,"Try again");
               
            }
                         
        
        }   while (email.equals(""));
               return email;


}

}

   
   
   
   
   
   
   
   
   
   
   
   
   

