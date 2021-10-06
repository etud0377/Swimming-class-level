public class Swimming {
    private String childName;
    private int childAge = 0;
    private String parentName;
    private String parentNumber;
    private String email;
    public static int MAX_CHILD = 100;
    private int cCounter = 0;
    //setting class options as boolean
    boolean[] classOptions = new boolean[4];
    
    

         
   //constructors for each parameter and validation.
    public Swimming(String childName,int childAge,String parentName, String parentNumber,String email ) {

        if (childName.equals("") || childName == null) {
            throw new IllegalArgumentException("Please enter a valid child name");
        }
        this.childName = childName;

        if (childAge < 6 || childAge > 11) {
            throw new IllegalArgumentException("You are not allowed to enroll in these classes");
        }
        this.childAge = childAge;
        if (parentName.equals("") || parentName == null) {
            throw new IllegalArgumentException("Please enter a valid parent name");
        }
        this.parentName = parentName;

        if (parentNumber.length() != 12 || parentNumber.charAt(3) != '.' || parentNumber.charAt(7) != '.') {
            throw new IllegalArgumentException("Please enter a valid number");
        }
        for (int i = 0; i < parentNumber.length(); i++) {
            if (!Character.isDigit(parentNumber.charAt(i)) && i != 3 && i != 7) {
                throw new IllegalArgumentException("Please enter a valid number");
            }
        }
        this.parentNumber = parentNumber;
        
        int position = email.indexOf('@');
            int dotposition = email.indexOf('.');
            int atCounter = 0;


        if (position <= 0 && dotposition <= 0 && (email.length() - 1) - dotposition >= 2 ){
                throw new IllegalArgumentException("Error! Try Again!");
            }
            for(char c : email.toCharArray())  {
                if( c == '@') {
                    atCounter++;
                }
                if (atCounter > 1 ) {
                    throw new IllegalArgumentException("Error! Try Again!");
                }
            }
            this.email = email;
        }




            //if email contains only one @, '.' need two characters after '.'
            //email must begin with a letter or digit
            
         //Accessors
        public String getChildName() {return this.childName;}
        public int getChildAge() {return this.childAge;}
        public String getParentName() {return this.parentName;}
        public String getParentNumber() {return this.parentNumber;}
        public String getEmail() {return this.email;}


        //Mutators
        
        public void setChildName(String childName) {
            if (childName.equals("") || childName == null) {
                throw new IllegalArgumentException("Please enter a valid child name");
            }
            this.childName = childName;
        }

        public void setChildAge(int childAge){
            if (childAge < 6 || childAge > 11) {
                throw new IllegalArgumentException("You are not allowed to enroll in these classes");
            }
                this.childAge = childAge;
        }

        public void setParentName(String parentName){
            if (parentName.equals("") || parentName == null) {
                throw new IllegalArgumentException("Please enter a valid parent name");
            }
            this.parentName = parentName;
        }

        public void setParentNumber(String parentNumber){
            if (parentNumber.length() != 12 || parentNumber.charAt(3) != '.' || parentNumber.charAt(7) != '.') {
                throw new IllegalArgumentException("Please enter a valid number");
            }
            for (int i = 0; i < parentNumber.length(); i++) {
                if (!Character.isDigit(parentNumber.charAt(i)) && i != 3 && i != 7) {
                    throw new IllegalArgumentException("Please enter a valid number");
                }
            }
            this.parentNumber = parentNumber;

        }


        public void setEmail(String email){
            int position = email.indexOf('@');
            int dotposition = email.indexOf('.');
            int atCounter = 0;

            if (position <= 0 || dotposition <= 0 || (email.length() - 1) - dotposition >= 2 ){
                throw new IllegalArgumentException("Error! Try Again!");
            }
            for(char c : email.toCharArray())  {
                if( c == '@') {
                    atCounter++;
                }
                if (atCounter > 1 ) {
                    throw new IllegalArgumentException("Error! Try Again!");
                }
            }
        }
        
        public boolean aSCounter(int optionLvl) {
            if (cCounter == 3 || classOptions[optionLvl]){
              return false;
              }
            if (optionLvl == 3 && (!classOptions[2])){
               return false;
            }
            else{
               cCounter++;
               classOptions[optionLvl] = true;
            }
            return true;
         }
            

        public String toString() {
            return "The Child's Name:" + this.getChildName() + "\nAge of the Child: " + this.getChildAge() + "\nParent's Name: " + this.getParentName() + "\nParent's Number: " + this.getParentNumber() +
                    "\nParent's Email: " + this.getEmail() + "\nTotal Cost: " + this.totalCost();
        }


        public double totalCost() {
            double total = 0.0;
         for(int i = 0; i < classOptions.length; i++) {
            
            if (classOptions[i] == true && i == 3){
                     total += 350;
            
            } if (classOptions[i]) {
               total +=  250;
             }
          }
               return total;
   }

 }