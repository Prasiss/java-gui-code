

abstract class GymMember
{
    //main parent class
    //instalizing the main attributes for the abstract class
    protected int id ;
    protected String name;
    protected String location;
    protected String phone ;
    protected String email ;
    protected String gender ;
    protected String dateOfBirth;
    protected String membershipStartDate;
    protected int attendance = 0;
    protected double loyaltyPoints = 0;
    protected boolean activeStatus = false;
    
    //constructor
    public GymMember(int id,String name,String location, String phone, String email, String gender,String DateOfBirth,String membershipStartDate){
        this.id=id;
        this.name=name;
        this.location=location;
        this.phone=phone;
        this.email=email;
        this.gender=gender;
        this.dateOfBirth=DateOfBirth;
        this.membershipStartDate=membershipStartDate;
        
    
    }
    
    //accesor method or getter method
    public int getId (){
        return this.id;
        }
        
    public String getName(){
        return this.name;
        }
        
    public String getLocation (){
        return this.location;
        }
        
    public String getEmail (){
        return this.email;
        }
        
    public String getPhone (){
        return this.phone;
        }
        
    public String getGender (){
        return this.gender;
        }
        
    public String getDateOfBirth(){
            return this.dateOfBirth;
        }
        
    public String getMembershipStartDate(){
        return this.membershipStartDate;
        
    }
    
    public int getAttendance(){
        return this.attendance;
    }
    
    public boolean getActiveStatus(){
        return this.activeStatus;
    }
    
    public double getLoyaltyPoints(){
        return this.loyaltyPoints;
    }
    
    abstract void markAttendance();
    
    
    //method to change the active statusand deactivate it
    public void activateMembership(){
        this.activeStatus = true;
    }
    
    public void deactivateMembership(){
        //checks the active status
        if (this.activeStatus == true){
            this.activeStatus = false;
        }else{
            System.out.println("Please Get your membership inorder to deactivate it ");
        }
        
    }
    
    //resets the value 
    public void revertMember(){
        this.attendance =0;
        this.activeStatus=false;
        this.loyaltyPoints=0;
    }
    
    //method to display the data
    public String display() {
        String textValue="Your id is: " + getId() + "\n" +
               "Your Name is: " + getName() + "\n" +
               "Your location is: " + getLocation() + "\n" +
               "Your phone number is: " + getPhone() + "\n" +
               "Your email is: " + getEmail() + "\n" +
               "Your gender is: " + getGender() + "\n" + 
               "Your DOB is: " + getDateOfBirth() + "\n" +
               "You started your membership on: " + getMembershipStartDate() + "\n" +
               "Your attendance in gym is: " + getAttendance() + "\n" +
               "Your loyalty points are: " + getLoyaltyPoints() + "\n" +
               "Your status is: " + getActiveStatus();
        return textValue;
    }

}
