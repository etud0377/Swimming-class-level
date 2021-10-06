public class Scholarships extends Swimming {
   private String orgName;
   private double schoDiscount = 0.0;
   //scholarship extends Swimming and also has its own variables orgName and schoDiscount
   public Scholarships(String childName,int childAge,String parentName, String parentNumber,String email, String orgName, double schoDiscount){
      super (childName,childAge,parentName,parentNumber,email);
       if (orgName.equals("") || orgName == null) {
         throw new IllegalArgumentException("Please enter a valid child name");
       }else {
         this.orgName = orgName;
       }
       if (schoDiscount < 0) {
         throw new IllegalArgumentException("Please enter a valid number");
       } else {
         this.schoDiscount = schoDiscount;
       }
   }
   
   public String getOrgName() {return this.orgName;}
   public double getSchoDiscount() {return this.schoDiscount;}
   
   
   public void setOrgName (String orgName){
      if (orgName.equals("") || orgName == null) {
         throw new IllegalArgumentException("Please enter a valid child name");
       }else {
         this.orgName = orgName;
      }
  }
  
  public void setSchoDiscount (double schoDiscount) {
     if (schoDiscount < 0) {
         throw new IllegalArgumentException("Please enter a valid number");
       } else {
         this.schoDiscount = schoDiscount;
       }
  }
  
  public double getTotalDiscount() {
   return super.totalCost() * schoDiscount;
  }  
  
  public String toString() {
            return super.toString() + "Your organization name: " + this.getOrgName() +  "Your percentage: " + this.getSchoDiscount()
            + "Total Discount is: " + this.getTotalDiscount();
  }
  
  
}

  
  
      

  