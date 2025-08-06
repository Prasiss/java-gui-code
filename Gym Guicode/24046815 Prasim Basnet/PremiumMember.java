public class PremiumMember extends GymMember {

    // assigning attributes and default value to child class attributes
    private final double premiumCharge = 50000;
    private String personalTrainer;
    private boolean isFullPayment = false;
    private double paidAmount = 0;
    private double discountAmount = 0;

    public PremiumMember(int id, String name, String location, String phone, String email, String gender,
            String dateOfBirth, String membershipStartDate, String personalTrainer) {
        super(id, name, location, phone, email, gender, dateOfBirth, membershipStartDate);
        this.personalTrainer = personalTrainer;
    }

    // accesor method or getter method
    public double getPremiumCharge() {
        return this.premiumCharge;
    }

    public String getPersonalTrainer() {
        return this.personalTrainer;
    }

    public boolean getIsFullPayment() {
        return this.isFullPayment;
    }

    public double getPaidAmount() {
        return this.paidAmount;
    }

    public double getDiscountAmount() {
        return this.discountAmount;
    }

    public String payDueAmount(double paidAmount) {

        this.paidAmount = paidAmount;
        String payAmount = "";

        if (getIsFullPayment() == true) {
            payAmount="Congratulations! You have already payed the price";
            return payAmount;
        } else {
            if (getPaidAmount() < getPremiumCharge()) {
                double remainingAmount = getPremiumCharge() - getPaidAmount();
                if (remainingAmount != 0) {
                    payAmount="you have to clear your dues" + '\n' + "your due amount is :" + remainingAmount;
                }
                this.isFullPayment = false;

            } else {
                if (getPaidAmount() == getPremiumCharge()) {
                    this.isFullPayment = true;
                }
            }
        }

        return payAmount;
    }

    public void calculateDiscount() {
        if (getIsFullPayment() == true) {
            double discountAmount = 0;
            discountAmount = 0.1 * getPaidAmount();
            this.discountAmount = discountAmount;
            System.out.println("you have got a discount of 10 percent on your plan. Thank you for attending our gym");

        }

    }

    public void revertPremiumMember() {
        // removes the persons id and deatils and sets the otehr into original form.
        super.revertMember();
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;

    }

    @Override
    void markAttendance() {
        // gets the value of attendance and loyaltyPints and increases attendance by 1
        // and loyalty points by 10
        int attendance = super.getAttendance();
        // increases the value by 1
        attendance += 1;
        // assign the updated value
        this.attendance = attendance;

        double loyaltyPoints = super.getLoyaltyPoints();
        // increases the value by 10
        loyaltyPoints = loyaltyPoints + 10;
        // assign the updated value
        this.loyaltyPoints = loyaltyPoints;

        System.out.println("Attendence recorded");

    }

    public String display() {
        double remainingAmount = getPremiumCharge() - getPaidAmount();
                
        String result = super.display() + "\n"; 
        
        result += "Personal Trainer: " + getPersonalTrainer() + "\n";
        result += "Paid Amount: " + getPaidAmount() + "\n";
        result += "Remaining Dues: " + remainingAmount + "\n";
        result += "Full Payment: " + (getIsFullPayment() ? "Yes" : "No") + "\n";
        
        if (getIsFullPayment()) {
            result += "You have paid the full amount.\n" +
                      "Your discount amount is: " + getDiscountAmount() + "\n";
        }
        
        return result;
    }


}
