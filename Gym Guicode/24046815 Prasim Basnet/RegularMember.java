public class RegularMember extends GymMember {
    // child class attributes
    private final int attendanceLimit = 30;
    boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan = "basic";
    private double price = 6500;

    public RegularMember(int id, String name, String location, String phone, String email, String gender,
            String DateOfBirth, String membershipStartDate, String referralSource, String plan) {
        super(id, name, location, phone, email, gender, DateOfBirth, membershipStartDate);
        this.referralSource = referralSource;
        this.plan = plan;

    }

    // accesor method or getter method
    public int getAtendanceLimit() {
        return this.attendanceLimit;
    }

    public String getRemovalReason() {
        return this.removalReason;
    }

    public boolean getIsEligibleForUpgrade() {
        return this.isEligibleForUpgrade;
    }

    public String getReferralSource() {
        return this.referralSource;
    }

    public String getPlan() {
        return this.plan;
    }

    public double getPrice() {
        return this.price;

    }

    // abstract method not completed
    @Override
    void markAttendance() {
        // gets the value of attendance and loyaltyPints and increases attendance by 1
        // and loyalty points by 10
        int attendance = super.getAttendance();
        attendance += 1;
        this.attendance = attendance;
        double loyaltyPoints = super.getLoyaltyPoints();
        loyaltyPoints = loyaltyPoints + 5;
        this.loyaltyPoints = loyaltyPoints;
        System.out.println("Attendence recorded");

    }

    // gets the price of the plan
    public double getPlanPrice(String plan) {
        double planValue;
        switch (plan) {
            case ("basic"):
                planValue = 6500;
                break;
            case ("standard"):
                planValue = 12500;
                break;

            case ("deluxe"):
                planValue = 18500;
                break;
            // returns -1 as value if invalid plan
            default:
                planValue = -1;
        }
        return planValue;

    }

    public String upgradePlan(String plan) {
        String message = "";
        if (super.getAttendance() >= getAtendanceLimit()) {

            this.isEligibleForUpgrade = true;
            double planPrice = getPlanPrice(plan);

            if (planPrice == getPrice()) {
                message = "You selected the same plan. Please select different plans to upgrade ";
                return message;
            }

            if (planPrice != -1) {
                if (planPrice == 6500) {
                    this.plan = "Basic";
                    this.price = planPrice;
                    message = "You have sucessfully changed your plan to " + this.plan;

                } else if (planPrice == 12500) {
                    this.plan = "Standard";
                    this.price = planPrice;
                    message = "You have sucessfully changed your plan to " + this.plan;

                } else {
                    this.plan = "Deluxe";
                    this.price = planPrice;
                    message = "You have sucessfully changed your plan to " + this.plan;

                }
            }

        } else {
            message = "you have not completed 30 days of gym " + '\n'
                    + " Please Complete 30 days of attendence to upgrade";
        }
        return message;
    }

    public void revertRegularMember(String removalReason) {
        /*
         * calls the parent method
         * resets the value
         */
        super.revertMember();
        this.price = 0;
        this.plan = "Basic";
        this.isEligibleForUpgrade = false;
        this.removalReason = removalReason;

    }

    public String display() {
        String result = super.display() + "\n"; // Get the parent class's display output and add a newline
    
        result = result + "Your plan is: " + getPlan() + "\n";
        result = result + "Your plan Price: " + getPrice() + "\n";
        result = result + "Your source is: " + getReferralSource() + "\n";
    
        if (!getIsEligibleForUpgrade()) {
            result += "You are not eligible for upgrade\n";
        } else {
            result += "You are eligible for upgrade\n";
        }
    
        if (removalReason != null) {
            result += "Your attendance in gym is: " + getRemovalReason() + "\n";
        }
        
        result = result + "------------------------------------------" +"\n"; 
        return result;
    }

}