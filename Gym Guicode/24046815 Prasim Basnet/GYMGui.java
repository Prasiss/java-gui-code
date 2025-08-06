import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JLabel;
import java.io.FileWriter;
import java.awt.Color;
import java.awt.Font;

public class GYMGui implements ActionListener {
    JFrame frame;
    JComboBox<String> dobMonthComboBox, msMonthComboBox,
            planComboBox;
    JComboBox<Integer> dobYearComboBox, dobDayComboBox, msYearComboBox, msDayComboBox;

    JTextField usernameTextFeild, planPriceTextFeild, discountTextFeild, phoneTextFeild, nameTextFeild, idTextFeild,
            refferalSourceTextFeild, emailTextFeild, trainerNameTextFeild,payDueAmountTextFeild,upgradePlanTextFeild;
    JTextArea locationTextArea,memberTextArea;
    JLabel welcomeTextLabel, discountLabel, planPriceLabel, welcomeMessageLabel, planLabel, welcomeLabel, nameLabel,
            idLabel, locationLabel, phoneLabel, emailLabel, genderLabel, refferalSourceLabel, removalReasonLabel,
            trainerNameLabel, paidAmountLabel, dateOfBirthLabel, membershipStartLabel,payDueAmountLabel,upgradePlanLabel;
    JPanel panel;
    JRadioButton maleButton, femaleButton, otherButton;
    JButton submitButton, clearButton,returnBackButton, displayRegularMemberButton, revertMemberButton, deactivateMemberButton,
            displayPremiumMemberButton, premiumMemberButton, activateMemberButton, regularMemberButton,upgradePlanButton,
            deactivateMembershipButton, activateMembershipButton, markAttendanceButton, revertButton,saveToFileButton,readFromFileButton,
            calculateDiscountButton,payDueAmountButton;
    // creating the aarraylist for the gymMember class
    ArrayList<GymMember> gymMember = new ArrayList<GymMember>();

    public GYMGui() {

        // creating a frame for our form page.
        frame = new JFrame("Welcome to GYm Membership Form");
        frame.getContentPane().setBackground(Color.decode("#A3D1C6"));
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(500, 300);
        
        welcomeLabel = new JLabel("Welcome!");
        welcomeTextLabel = new JLabel("Wanna be a member of Fitness Freak");
        welcomeMessageLabel = new JLabel("If yes click on the button....");

        premiumMemberButton = new JButton("Premium Member");
        regularMemberButton = new JButton("Regular Member");

        // setting the components

        welcomeLabel.setBounds(150, 20, 250, 30);
        welcomeTextLabel.setBounds(20, 60, 250, 30);
        welcomeMessageLabel.setBounds(60, 100, 250, 30);

        premiumMemberButton.setBounds(270, 50, 200, 35);
        regularMemberButton.setBounds(270, 150, 200, 30);
        regularMemberButton.setBackground(Color.decode("#E5D0AC"));
        premiumMemberButton.setBackground(Color.decode("#E5D0AC"));
        panel.add(premiumMemberButton);
        panel.add(regularMemberButton);
        panel.add(welcomeLabel);
        panel.add(welcomeTextLabel);
        panel.add(welcomeMessageLabel);

        // adding the componest to the frame
        frame.add(panel);
        frame.setLayout(null);
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // adding eventlistener to the buttons
        premiumMemberButton.addActionListener(this);
        regularMemberButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == regularMemberButton) {
            new RegularMemberFrame();

        } else if (e.getSource() == premiumMemberButton) {
            new PremiumMemberFrame();
        }

    }

    // creating a new frame for each button
    public class RegularMemberFrame extends JFrame implements ActionListener {

        public RegularMemberFrame() {
            this.getContentPane().setBackground(Color.decode("#A3D1C6"));
            this.setTitle("Regular Memebers");
            
            welcomeTextLabel = new JLabel("Welcome Regular members");
            welcomeTextLabel.setBounds(200, 20, 300, 30);
            welcomeTextLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
            
            idLabel = new JLabel("ID ");
            idTextFeild = new JTextField();

            idLabel.setBounds(40, 70, 100, 25);
            idTextFeild.setBounds(140, 70, 150, 25);
            
            //sets background color to text feilds
            idTextFeild.setBackground(Color.decode("#FBFFE4"));

            nameLabel = new JLabel("Name ");
            nameTextFeild = new JTextField();

             nameLabel.setBounds(40, 110, 100, 25);
            nameTextFeild.setBounds(140, 110, 150, 25);
            nameTextFeild.setBackground(Color.decode("#FBFFE4"));
            
            locationLabel = new JLabel("Location ");
            locationTextArea = new JTextArea();

            locationLabel.setBounds(40, 280, 150, 30);
            locationTextArea.setBounds(140, 280, 150, 40);
            locationTextArea.setBackground(Color.decode("#FBFFE4"));

            phoneLabel = new JLabel("Phone ");
            phoneTextFeild = new JTextField();

            phoneLabel.setBounds(40, 150, 100, 25);
            phoneTextFeild.setBounds(140, 150, 150, 25);
            phoneTextFeild.setBackground(Color.decode("#FBFFE4"));

            emailLabel = new JLabel("Email ");
            emailTextFeild = new JTextField();

            emailLabel.setBounds(40, 190, 100, 25);
            emailTextFeild.setBounds(140, 190, 150, 25);
            emailTextFeild.setBackground(Color.decode("#FBFFE4"));

            // used radio button for Gender
            genderLabel = new JLabel("Gender: ");
            maleButton = new JRadioButton("Male");
            femaleButton = new JRadioButton("Female");
            otherButton = new JRadioButton("Other");
            ///done to select only one item
            ButtonGroup genderLabelGroup = new ButtonGroup();
            genderLabelGroup.add(maleButton);
            genderLabelGroup.add(femaleButton);
            genderLabelGroup.add(otherButton);

            genderLabel.setBounds(40, 230, 100, 25);
            maleButton.setBounds(140, 230, 60, 25);
            femaleButton.setBounds(200, 230, 80, 25);
            otherButton.setBounds(280, 230, 70, 25);
            
            maleButton.setOpaque(false);
            femaleButton.setOpaque(false);
            otherButton.setOpaque(false);

            
            // combo box used for Date of Birth
            dateOfBirthLabel = new JLabel("Date Of Birth: ");

            dobYearComboBox = new JComboBox<>();
            for (int i = 1990; i <= 2030; i++) {
                dobYearComboBox.addItem(i);
            }

            String[] months = {
                    "January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"
            };

            dobMonthComboBox = new JComboBox<>(months);

            dobDayComboBox = new JComboBox<>();
            for (int i = 1; i <= 31; i++) {
                dobDayComboBox.addItem(i);
            }

            membershipStartLabel = new JLabel("Membership Start Date: ");

            msYearComboBox = new JComboBox<>();
            for (int i = 2015; i <= 2025; i++) {
                msYearComboBox.addItem(i);
            }

            msMonthComboBox = new JComboBox<>(months);

            msDayComboBox = new JComboBox<>();
            for (int i = 1; i <= 31; i++) {
                msDayComboBox.addItem(i);
            }
            
            dateOfBirthLabel.setBounds(350, 70, 120, 25);
            dobYearComboBox.setBounds(490, 70, 60, 25);
            dobMonthComboBox.setBounds(560, 70, 80, 25);
            dobDayComboBox.setBounds(650, 70, 40, 25);
            
            membershipStartLabel.setBounds(350, 110, 150, 25);
            msYearComboBox.setBounds(490, 110, 60, 25);
            msMonthComboBox.setBounds(560, 110, 80, 25);
            msDayComboBox.setBounds(650, 110, 40, 25);
            
            planLabel = new JLabel("Plan");
            String[] plan = { "Basic", "Standard", "Deluxe" };
            

            planComboBox = new JComboBox<>(plan);
            planComboBox.setEditable(false);

            planLabel.setBounds(330, 280, 150, 30);
            planComboBox.setBounds(480, 280, 150, 30);
            
            refferalSourceLabel = new JLabel("Refferal Source: ");
            refferalSourceTextFeild = new JTextField();
            
            refferalSourceLabel.setBounds(350, 230, 100, 25); 
            refferalSourceTextFeild.setBounds(490, 230, 150, 25);
            refferalSourceTextFeild.setBackground(Color.decode("#FBFFE4"));

            discountLabel = new JLabel("Discount");
            discountTextFeild = new JTextField("0.00");
            discountTextFeild.setEditable(false);
            
            discountLabel.setBounds(350, 150, 100, 25);
            discountTextFeild.setBounds(490, 150, 150, 25);
            discountTextFeild.setBackground(Color.decode("#FBFFE4"));
            

            planPriceLabel = new JLabel("Regular Plan Price");
            planPriceTextFeild = new JTextField("6500");
            planPriceTextFeild.setEditable(false);
            
            planPriceLabel.setBounds(350, 190, 130, 25);
            planPriceTextFeild.setBounds(490, 190, 150, 25);
            planPriceTextFeild.setBackground(Color.decode("#FBFFE4"));
           

            regularMemberButton = new JButton("Add Regular Member");
            displayRegularMemberButton = new JButton("Display Regular Members");
            clearButton = new JButton("Clear");
            
            markAttendanceButton = new JButton("Mark Attendance");
            activateMemberButton = new JButton("Activate Membership");
            deactivateMemberButton = new JButton("Deactivate Membership");
            revertMemberButton = new JButton("Revert Member");
            returnBackButton = new JButton("Return Back");
            saveToFileButton = new JButton("Save To File");
            upgradePlanButton = new JButton("Upgrade Plan");
            calculateDiscountButton = new JButton("Calculate Discount");
            payDueAmountButton = new JButton("Pay Due Amount");
            readFromFileButton = new JButton("Read From File");


            //using set bounds to allowcate the area for the buttons  in our frame
            regularMemberButton.setBounds(40, 340, 170, 30);
            upgradePlanButton.setBounds(250, 340, 170, 30);
            payDueAmountButton.setBounds(460, 340, 170, 30);
            activateMemberButton.setBounds(40, 380, 170, 30);
            markAttendanceButton.setBounds(250, 380, 170, 30);
            returnBackButton.setBounds(460, 380, 170, 30);
            displayRegularMemberButton.setBounds(40, 420, 170, 30);
            deactivateMemberButton.setBounds(250, 420, 170, 30);
            calculateDiscountButton.setBounds(460, 420, 170, 30);
            revertMemberButton.setBounds(40, 460, 170, 30);
            saveToFileButton.setBounds(250, 460, 170, 30);
            readFromFileButton.setBounds(460, 460, 170, 30);
            clearButton.setBounds(290, 500, 150, 30);
            
            //setting background color to the buttons
            regularMemberButton.setBackground(Color.decode("#E5D0AC"));
            displayRegularMemberButton.setBackground(Color.decode("#E5D0AC"));
            clearButton.setBackground(Color.decode("#E5D0AC"));
            markAttendanceButton.setBackground(Color.decode("#E5D0AC"));
            activateMemberButton.setBackground(Color.decode("#E5D0AC"));
            deactivateMemberButton.setBackground(Color.decode("#E5D0AC"));
            revertMemberButton.setBackground(Color.decode("#E5D0AC"));
            returnBackButton.setBackground(Color.decode("#E5D0AC"));
            saveToFileButton.setBackground(Color.decode("#E5D0AC"));
            upgradePlanButton.setBackground(Color.decode("#E5D0AC"));
            calculateDiscountButton.setBackground(Color.decode("#E5D0AC"));
            payDueAmountButton.setBackground(Color.decode("#E5D0AC"));
            readFromFileButton.setBackground(Color.decode("#E5D0AC"));

        
            this.setTitle("Regular Members");
            this.add(welcomeTextLabel);
            this.add(idLabel);
            this.add(idTextFeild);
            this.add(nameLabel);
            this.add(nameTextFeild);
            this.add(locationLabel);
            this.add(locationTextArea);
            this.add(phoneLabel);
            this.add(phoneTextFeild);
            this.add(emailLabel);
            this.add(emailTextFeild);
            this.add(genderLabel);
            this.add(maleButton);
            this.add(femaleButton);
            this.add(otherButton);
            this.add(discountTextFeild);
            this.add(discountLabel);
            this.add(planPriceLabel);
            this.add(planPriceTextFeild);

            this.add(dateOfBirthLabel);
            this.add(dobDayComboBox);
            this.add(dobMonthComboBox);
            this.add(dobYearComboBox);
            this.add(membershipStartLabel);
            this.add(msMonthComboBox);
            this.add(msDayComboBox);
            this.add(msYearComboBox);

            this.add(refferalSourceLabel);
            this.add(refferalSourceTextFeild);
            this.add(planLabel);
            this.add(planComboBox);
            this.add(regularMemberButton);
            this.add(displayRegularMemberButton);
            this.add(markAttendanceButton);
            this.add(clearButton);
            this.add(activateMemberButton);
            this.add(deactivateMemberButton);
            this.add(revertMemberButton);
            this.add(returnBackButton);
            this.add(saveToFileButton);
            this.add(upgradePlanButton);
            this.add(calculateDiscountButton);
            this.add(payDueAmountButton);
            this.add(readFromFileButton);

            this.setLayout(null);
            this.setResizable(false);
            this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
            this.setSize(750, 650);
            this.setVisible(true);

            //
            markAttendanceButton.addActionListener(this);
            clearButton.addActionListener(this);
            regularMemberButton.addActionListener(this);
            deactivateMemberButton.addActionListener(this);
            activateMemberButton.addActionListener(this);
            revertMemberButton.addActionListener(this);
            displayRegularMemberButton.addActionListener(this);
            returnBackButton.addActionListener(this);
            saveToFileButton.addActionListener(this);
            upgradePlanButton.addActionListener(this);
            calculateDiscountButton.addActionListener(this);
            payDueAmountButton.addActionListener(this);
            readFromFileButton.addActionListener(this);
            
            
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Add Regular Member")) {
                try {
                    if (idTextFeild.getText().trim().isEmpty() || phoneTextFeild.getText().trim().isEmpty() || nameTextFeild.getText().trim().isEmpty() || emailTextFeild.getText().trim().isEmpty() || refferalSourceTextFeild.getText().trim().isEmpty() ){
                        
                        JOptionPane.showMessageDialog(this, "FIll in all the text Feilds", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String idValue=idTextFeild.getText().trim();
                    int id;
                    try{
                         id = Integer.parseInt(idValue);
                    }catch (NumberFormatException numexception)
                    {
                        JOptionPane.showMessageDialog(this, "Id should contain only Integers ", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                    }
                    
                    for (GymMember member : gymMember) {

                        if (member instanceof RegularMember && (member.getId() == id)) {

                            JOptionPane.showMessageDialog(this, "Id in used try different one ", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if (member instanceof PremiumMember && (member.getId() == id)) {

                            JOptionPane.showMessageDialog(this, "Id in used try different one ", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                    }

                    String name = nameTextFeild.getText().trim();
            
                    if (name.contains("0") || name.contains("1") || name.contains("2") ||
                        name.contains("3") || name.contains("4") || name.contains("5") ||
                        name.contains("6") || name.contains("7") || name.contains("8") ||
                        name.contains("9")) {
                    
                        JOptionPane.showMessageDialog(this, "Name should not contain numbers. Please fill in proper name", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    

                    String location = locationTextArea.getText().trim();
                    String phone = phoneTextFeild.getText().trim();
                    int phoneNumber;
                    try{
                         phoneNumber = Integer.parseInt(phone);
                    }catch (NumberFormatException numexception)
                    {
                        JOptionPane.showMessageDialog(this, "PhoneNumber should contain only Integers ", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                    }
                    
                    if (phone.length() != 10){
                        JOptionPane.showMessageDialog(this, "Phone Number should contain 10 digits", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                    }
                    String email = emailTextFeild.getText().trim();
                    
                    if (email.contains("@gmail.com")){
                    }else{
                        JOptionPane.showMessageDialog(this, "Invalid Email. Should contain @gmail.com ", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                                    
                            return;
                    }
                    String gender = null;
                    if (maleButton.isSelected()) {
                        gender = "Male";
                    } else if (femaleButton.isSelected()) {
                        gender = "female";
                    } else {
                        gender = "other";
                    }
                    String referralSource = refferalSourceTextFeild.getText().trim();
                    
                    String dobMonth = (String) dobMonthComboBox.getSelectedItem();

                    String plan = (String) planComboBox.getSelectedItem();
                    int dobDay = (Integer) dobDayComboBox.getSelectedItem();
                    int dobYear = (Integer) dobYearComboBox.getSelectedItem();

                    String dateOfBirth = dobMonth + " " + dobDay + " " + dobYear;
                    String msMonth = (String) msMonthComboBox.getSelectedItem();
                    int msDay = (Integer) msDayComboBox.getSelectedItem();
                    int msYear = (Integer) msYearComboBox.getSelectedItem();
                    String membershipStartDate = msMonth + " " + msDay + " " + msYear;

                    RegularMember regularMember = new RegularMember(id, name, location, phone, email, gender,
                            dateOfBirth, membershipStartDate, referralSource, plan);

                    gymMember.add(regularMember);

                    JOptionPane.showMessageDialog(this, "Successfully Added regular Member", "Success",
                            JOptionPane.INFORMATION_MESSAGE);

                    }catch (NumberFormatException numError){
                    JOptionPane.showMessageDialog(this,"please Enter Valid Numerical Values","Error",JOptionPane.ERROR_MESSAGE);

                } catch (Exception error) {
                    JOptionPane.showMessageDialog(this, error.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            } else if (e.getActionCommand().equals("Clear")) {

                idTextFeild.setText(" ");
                nameTextFeild.setText(" ");
                locationTextArea.setText(" ");
                phoneTextFeild.setText(" ");
                emailTextFeild.setText(" ");
                refferalSourceTextFeild.setText(" ");

            } else if (e.getActionCommand().equals("Mark Attendance")) {

                new MarkAttendanceFrame();

            } else if (e.getActionCommand().equals("Revert Member")) {

                new RevertMemberFrame();

            } else if (e.getActionCommand().equals("Activate Membership")) {

                new ActivateMembershipFrame();

            } else if (e.getActionCommand().equals("Deactivate Membership")) {

                new DeactivateMembershipFrame();

            } else if (e.getActionCommand().equals("Display Regular Members")) {
                new DisplayRegularMemberFrame();

            }else if(e.getActionCommand().equals("Return Back" )){
                 frame.setVisible(true);
                
            }else if(e.getActionCommand().equals("Save To File")){
                new WriteFile();
                
            }else if(e.getActionCommand().equals("Read From File")){
                new ReadFile();
                
            }else if(e.getActionCommand().equals("Calculate Discount")){
                new CalculateDiscount();
            }else if(e.getActionCommand().equals("Upgrade Plan")){
                new UpgradePlanFrame();
            }else if(e.getActionCommand().equals("Pay Due Amount")){
                 new PayDueAmountFrame();   
            }

        }

    }

    public class DisplayRegularMemberFrame extends JFrame {
        
        public DisplayRegularMemberFrame() {
            setTitle("Member Information");
            getContentPane().setBackground(Color.decode("#A3D1C6"));
            setSize(500,400);
            setLayout(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            memberTextArea = new JTextArea();
            memberTextArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(memberTextArea);
            
            scrollPane.setBounds(30,30,420,300);
            add(scrollPane);
            
            if (gymMember.size() != 0) {
                memberTextArea.append("Regular Members");
                try {
                    for (GymMember member : gymMember) {
                        if (member instanceof RegularMember){
                            memberTextArea.append(member.display());
                        }
                    }
                } catch (Exception e) {
                    
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);

                }
            } else {
                
                JOptionPane.showMessageDialog(this, "No member is added till now", "Error", JOptionPane.ERROR_MESSAGE);
                
                return;
            }
            
            setVisible(true);
        }
    }
    
    public class DisplayPremiumMemberFrame extends JFrame {
        
        public DisplayPremiumMemberFrame() {
            
            this.setTitle("Member Information");
            this.getContentPane().setBackground(Color.decode("#A3D1C6"));
            this.setSize(500,400);
            this.setLayout(null);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            memberTextArea = new JTextArea();
            memberTextArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(memberTextArea);
            
            scrollPane.setBounds(30,30,420,300);
            this.add(scrollPane);
            
            if (gymMember.size() != 0) {
                memberTextArea.append(" Premium Members");
                try {
                    for (GymMember member : gymMember) {
                        if (member instanceof PremiumMember){
                            memberTextArea.append(member.display());
                        }
                    }
                } catch (Exception e) {
                    
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                    
                }
            } else {
                
                JOptionPane.showMessageDialog(this, "No member is added till now", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            this.setVisible(true);
        }
    }

    public class MarkAttendanceFrame extends JFrame implements ActionListener {

        public MarkAttendanceFrame() {

            this.setTitle("Mark Attendance");
            this.getContentPane().setBackground(Color.decode("#A3D1C6"));
            this.setLayout(null);
            this.setResizable(false);
            this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
            this.setSize(300, 300);
            welcomeTextLabel = new JLabel("Welcome Member");
            welcomeTextLabel.setBounds(90, 30, 160, 30);

            idLabel = new JLabel("ID ");
            idTextFeild = new JTextField();

            idLabel.setBounds(30, 80, 50, 30);
            idTextFeild.setBounds(90, 80, 160, 30);

            submitButton = new JButton("Submit");
            submitButton.setBounds(60, 130, 160, 30);
            submitButton.setBackground(Color.decode("#E5D0AC"));
            this.add(welcomeTextLabel);
            this.add(idLabel);
            this.add(idTextFeild);
            this.add(submitButton);

            this.setVisible(true);

            submitButton.addActionListener(this);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Submit")) {
                try {
                    int id = Integer.parseInt(idTextFeild.getText());
                    boolean checkValue=false;
                    if (gymMember.size() != 0) {
                        

                        for (GymMember m : gymMember) {

                            if (m instanceof RegularMember && (m.getId() == id)) {
                                if (m.getActiveStatus() == true){
                                    m.markAttendance();
                                    checkValue=true;
                                    JOptionPane.showMessageDialog(this, "Sucessfully Updated your attendance", "Sucess",
                                            JOptionPane.INFORMATION_MESSAGE);
                                    return;
                                }else{
                                    JOptionPane.showMessageDialog(this, "You are not active. First Be active in the gym ", "Error",
                                            JOptionPane.ERROR_MESSAGE);
                                    return;
                                }
                            } else if (m instanceof PremiumMember && (m.getId() == id)) {
                                if (m.getActiveStatus() == true){
                                    m.markAttendance();
                                    checkValue=true;
                                    JOptionPane.showMessageDialog(this, "Sucessfully Updated your attendance", "Sucess",
                                            JOptionPane.INFORMATION_MESSAGE);
                                    return;
                                }else{
                                    JOptionPane.showMessageDialog(this, "You are not active. First Be active in the gym ", "Error",
                                            JOptionPane.ERROR_MESSAGE);
                                    return;
                                }
                            }

                        }

                        if (checkValue == false) {

                            JOptionPane.showMessageDialog(this, "Gym memberId didnt match ", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "No gymMember recorded", "Error",
                                JOptionPane.ERROR_MESSAGE);

                    }
                } catch (Exception numError) {
                    JOptionPane.showMessageDialog(this, "please Enter Valid Id", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }

        }

    }
    
    public class UpgradePlanFrame extends JFrame implements ActionListener{
        
         public UpgradePlanFrame(){
            this.getContentPane().setBackground(Color.decode("#A3D1C6"));
            this.setTitle("Upgrade Plan");
            this.setLayout(null);
            this.setResizable(false);
            this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
            this.setSize(300, 300);
            welcomeTextLabel = new JLabel("Welcome Member");
            welcomeTextLabel.setBounds(90, 30, 160, 30);

            idLabel = new JLabel("Id : ");
            idTextFeild = new JTextField();
            upgradePlanLabel=new JLabel("Upgrade Plan");
            upgradePlanTextFeild = new JTextField();
            
            idLabel.setBounds(30, 80, 50, 30);
            idTextFeild.setBounds(90, 80, 160, 30);
            upgradePlanLabel.setBounds(30,130,90,30);
            upgradePlanTextFeild.setBounds(120,130,100,30);
            submitButton = new JButton("Submit");
            submitButton.setBounds(60, 200, 160, 30);
            submitButton.setBackground(Color.decode("#E5D0AC"));
            
            this.add(welcomeTextLabel);
            this.add(idLabel);
            this.add(idTextFeild);
            this.add(upgradePlanLabel);
            this.add(upgradePlanTextFeild);
            this.add(submitButton);

            this.setVisible(true);

            submitButton.addActionListener(this);
            
        }
        
        @Override
        public void actionPerformed(ActionEvent e){
            if (e.getActionCommand().equals("Submit")) {
                try{
                    boolean checkArrayValue=false;
                    int id = Integer.parseInt(idTextFeild.getText());
                    String plan = upgradePlanTextFeild.getText();
                    
                    if (gymMember.size() != 0){
                            
                            for (GymMember member:gymMember){
                                if (member instanceof RegularMember && (member.getId() == id)) {
                                    checkArrayValue = true;
                                    RegularMember regularMember =(RegularMember) member;
                                    String planmessage =regularMember.upgradePlan(plan);
                                    JOptionPane.showMessageDialog(this, planmessage,
                                            "Sucess", JOptionPane.INFORMATION_MESSAGE);
                                    
                                    break;
                                } else if (member instanceof PremiumMember && (member.getId() == id)) {
                                    checkArrayValue=true;
                                    JOptionPane.showMessageDialog(this, "You are not allowed to upgrade the plan beacause your are a premium member.",
                                            "Sucess", JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                }
                            }
                            
                            if (checkArrayValue == false){
                                JOptionPane.showMessageDialog(this, "No gymMember with this id", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            }
                        
                        }else{
                            JOptionPane.showMessageDialog(this, "No gymMember recorded", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }catch(Exception error){
                        JOptionPane.showMessageDialog(this, error.getMessage(), "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    }
                }
        }
    }
    
    public class PayDueAmountFrame extends JFrame implements ActionListener{
        public PayDueAmountFrame(){
            this.getContentPane().setBackground(Color.decode("#A3D1C6"));
            this.setTitle("Pay Due Amount");
            this.setLayout(null);
            this.setResizable(false);
            this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
            this.setSize(300, 300);
            welcomeTextLabel = new JLabel("Welcome Member");
            welcomeTextLabel.setBounds(90, 30, 160, 30);

            idLabel = new JLabel("Id : ");
            idTextFeild = new JTextField();
            payDueAmountLabel=new JLabel("Pay Due Amount");
            payDueAmountTextFeild = new JTextField();
            
            idLabel.setBounds(30, 80, 50, 30);
            idTextFeild.setBounds(90, 80, 160, 30);
            payDueAmountLabel.setBounds(30,130,90,30);
            payDueAmountTextFeild.setBounds(120,130,90,30);
            submitButton = new JButton("Pay Due Amount");
            submitButton.setBounds(60, 200, 160, 30);
            submitButton.setBackground(Color.decode("#E5D0AC"));
            
            this.add(welcomeTextLabel);
            this.add(idLabel);
            this.add(idTextFeild);
            this.add(payDueAmountLabel);
            this.add(payDueAmountTextFeild);
            this.add(submitButton);

            this.setVisible(true);

            submitButton.addActionListener(this);
            
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Pay Due Amount")) {
                try {
                    //using try catch block to find any exception in the process
                    int id = Integer.parseInt(idTextFeild.getText());
                    String payAmount = payDueAmountTextFeild.getText();
                    double payDueAmount;
                    try{
                        //chekcs if value is only integer or not
                         payDueAmount = Integer.parseInt(payAmount);
                    }catch (NumberFormatException numexception)
                    {
                        //displaying error messgae
                        JOptionPane.showMessageDialog(this, "Value should be integer", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                    }
                    
                    boolean checkArrayValue = false;
                    if (gymMember.size() != 0){
                        /*
                         * using for each loop to go theough our array list
                         * The checking if the member is either regular or premium using instance od
                         * displying appropriate messgae for the operation done.
                         */
                        for (GymMember member:gymMember){
                            
                            if (member instanceof RegularMember && (member.getId() == id)) {
                                
                                checkArrayValue=true;
                                JOptionPane.showMessageDialog(this, "You are not allowed to pay the due amount be a premium member first.",
                                        "Sucess", JOptionPane.INFORMATION_MESSAGE);
                                return;
                            } else if (member instanceof PremiumMember && (member.getId() == id)) {
                                //object casting done so that the paydue amount method is called
                                checkArrayValue = true;
                                PremiumMember premiumMember =(PremiumMember) member;
                                String message=premiumMember.payDueAmount(payDueAmount);
                                JOptionPane.showMessageDialog(this, message,
                                        "Sucess", JOptionPane.INFORMATION_MESSAGE);
                                return;
                            }
                        }
                        
                        if (checkArrayValue == false){
                            JOptionPane.showMessageDialog(this, "No gymMember with this id", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        }
                    
                    }else{
                        JOptionPane.showMessageDialog(this, "No gymMember recorded", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    
                }
                catch(Exception NumError){
                    JOptionPane.showMessageDialog(this, "please Enter Valid Id", "Error", JOptionPane.ERROR_MESSAGE);
                }
                }
            }
        }     
        
    public class RevertMemberFrame extends JFrame implements ActionListener {

        public RevertMemberFrame() {
            this.getContentPane().setBackground(Color.decode("#A3D1C6"));
            this.setTitle("Revert Member");
            this.setLayout(null);
            this.setResizable(false);
            this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
            this.setSize(300, 300);
            welcomeTextLabel = new JLabel("Welcome Member");
            welcomeTextLabel.setBounds(90, 30, 160, 30);

            idLabel = new JLabel("ID ");
            idTextFeild = new JTextField();

            idLabel.setBounds(30, 80, 50, 30);
            idTextFeild.setBounds(90, 80, 160, 30);

            submitButton = new JButton("Submit");
            submitButton.setBounds(60, 130, 160, 30);
            submitButton.setBackground(Color.decode("#E5D0AC"));

            this.add(welcomeTextLabel);
            this.add(idLabel);
            this.add(idTextFeild);
            this.add(submitButton);

            this.setVisible(true);

            submitButton.addActionListener(this);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Submit")) {
                try {
                    //using try catch block to find any exception
                    int id = Integer.parseInt(idTextFeild.getText());
                    boolean checkArrayValue = false;
                    //checing if members are present in the array list or not
                    if (gymMember.size() != 0) {
                        
                        for (GymMember m : gymMember) {

                            if (m instanceof RegularMember && (m.getId() == id)) {
                                String reason="new id";
                                RegularMember regularMember =(RegularMember) m;
                                regularMember.revertRegularMember(reason);
                                checkArrayValue = true;
                                JOptionPane.showMessageDialog(this, "Sucessfully Removed your Id. See you soon",
                                        "Sucess", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            } else if (m instanceof PremiumMember && (m.getId() == id)) {
                                
                                PremiumMember premiumMember =(PremiumMember) m;
                                premiumMember.revertPremiumMember();
                                checkArrayValue = true;
                                JOptionPane.showMessageDialog(this, "Sucessfully Removed your Id. See you soon",
                                        "Sucess", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            }

                        }

                        if (checkArrayValue == false) {

                            JOptionPane.showMessageDialog(this, "Gym memberId didnt match ", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        
                    } else {
                        //displaying error message 
                        JOptionPane.showMessageDialog(this, "No gymMember recorded", "Error",
                                JOptionPane.ERROR_MESSAGE);

                    }
                } catch (Exception numError) {
                    // using excpetion class to find errors 
                    JOptionPane.showMessageDialog(this, "please Enter Valid Id", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }

        }
    }
    
    public class CalculateDiscount extends JFrame implements ActionListener{
        //constructor for this class
        public CalculateDiscount(){
            
            this.setTitle("Calculate Discount");
            //sets the background color to the frame and providing a user define color with hexa decimal value.
            this.getContentPane().setBackground(Color.decode("#A3D1C6"));
            this.setLayout(null);
            this.setResizable(false);
            this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
            this.setSize(300, 300);
            welcomeTextLabel = new JLabel("Welcome Member");
            welcomeTextLabel.setBounds(90, 30, 160, 30);

            idLabel = new JLabel("ID ");
            idTextFeild = new JTextField();

            idLabel.setBounds(30, 80, 50, 30);
            idTextFeild.setBounds(90, 80, 160, 30);

            submitButton = new JButton("Submit");
            submitButton.setBounds(60, 130, 160, 30);
            submitButton.setBackground(Color.decode("#E5D0AC"));
            
            this.add(welcomeTextLabel);
            this.add(idLabel);
            this.add(idTextFeild);
            this.add(submitButton);

            this.setVisible(true);

            submitButton.addActionListener(this);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            //perform the action listener when the submit button is clicked
            if (e.getActionCommand().equals("Submit")) {
                try {
                    int id = Integer.parseInt(idTextFeild.getText());

                    if (gymMember.size() != 0) {
                        boolean checkArrayValue = false;

                        for (GymMember m : gymMember) {
                            //dispyees appropriate message after completing the operation
                            if (m instanceof RegularMember && (m.getId() == id)) {
                                //object casting 
                                
                                checkArrayValue = true;
                                JOptionPane.showMessageDialog(this,
                                        "you are not a regular member to calculate discount", "Sucess",
                                        JOptionPane.INFORMATION_MESSAGE);
                                break;
                            } else if (m instanceof PremiumMember && (m.getId() == id)) {
                                
                                //object casting done so that the paydue amount method is called
                                checkArrayValue = true;
                                PremiumMember premiumMember =(PremiumMember) m;
                                double discountAmount=premiumMember.getDiscountAmount();
                                String message="your discount is: "+discountAmount;
                                JOptionPane.showMessageDialog(this,
                                        message, "Sucess",
                                        JOptionPane.INFORMATION_MESSAGE);
                                        
                                break;
                            }

                        }

                        if (checkArrayValue == false) {

                            JOptionPane.showMessageDialog(this, "Gym memberId didnt match ", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        
                    } else {
                        JOptionPane.showMessageDialog(this, "No gymMember recorded", "Error",
                                JOptionPane.ERROR_MESSAGE);

                    }
                } catch (Exception numError) {
                    JOptionPane.showMessageDialog(this, "please Enter Valid Id", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }

        }
    }
    
    public class DeactivateMembershipFrame extends JFrame implements ActionListener {

        public DeactivateMembershipFrame() {

            this.setTitle("Deactivate Membership");
            this.getContentPane().setBackground(Color.decode("#A3D1C6"));
            this.setLayout(null);
            this.setResizable(false);
            this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
            this.setSize(300, 300);
            welcomeTextLabel = new JLabel("Welcome Member");
            welcomeTextLabel.setBounds(90, 30, 160, 30);

            idLabel = new JLabel("ID ");
            idTextFeild = new JTextField();

            idLabel.setBounds(30, 80, 50, 30);
            idTextFeild.setBounds(90, 80, 160, 30);

            submitButton = new JButton("Submit");
            submitButton.setBounds(60, 130, 160, 30);
            submitButton.setBackground(Color.decode("#E5D0AC"));

            this.add(welcomeTextLabel);
            this.add(idLabel);
            this.add(idTextFeild);
            this.add(submitButton);

            this.setVisible(true);

            submitButton.addActionListener(this);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Submit")) {
                try {
                    int id = Integer.parseInt(idTextFeild.getText());

                    if (gymMember.size() != 0) {
                        boolean checkArrayValue = false;

                        for (GymMember m : gymMember) {

                            if (m instanceof RegularMember && (m.getId() == id)) {
                                m.deactivateMembership();
                                checkArrayValue = true;
                                JOptionPane.showMessageDialog(this,
                                        "Sucessfully deactivate Your membership. See you soon", "Sucess",
                                        JOptionPane.INFORMATION_MESSAGE);
                                break;
                            } else if (m instanceof PremiumMember && (m.getId() == id)) {
                                m.deactivateMembership();
                                checkArrayValue = true;
                                JOptionPane.showMessageDialog(this,
                                        "Sucessfully deactivated your membership. See you soon", "Sucess",
                                        JOptionPane.INFORMATION_MESSAGE);
                                break;
                            }

                        }

                        if (checkArrayValue == false) {

                            JOptionPane.showMessageDialog(this, "Gym memberId didnt match ", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "No gymMember recorded", "Error",
                                JOptionPane.ERROR_MESSAGE);

                    }
                } catch (Exception numError) {
                    JOptionPane.showMessageDialog(this, "please Enter Valid Id", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }

        }
    }

    public class ActivateMembershipFrame extends JFrame implements ActionListener {

        public ActivateMembershipFrame() {

            this.setTitle("Activate Membership ");
            this.getContentPane().setBackground(Color.decode("#A3D1C6"));
            this.setLayout(null);
            this.setResizable(false);
            this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
            this.setSize(300, 300);
            welcomeTextLabel = new JLabel("Welcome Member.");
            welcomeTextLabel.setBounds(90, 30, 160, 30);

            idLabel = new JLabel("ID ");
            idTextFeild = new JTextField();

            idLabel.setBounds(30, 80, 50, 30);
            idTextFeild.setBounds(90, 80, 160, 30);

            submitButton = new JButton("Submit");
            submitButton.setBounds(60, 130, 160, 30);
            submitButton.setBackground(Color.decode("#E5D0AC"));

            this.add(welcomeTextLabel);
            this.add(idLabel);
            this.add(idTextFeild);
            this.add(submitButton);

            this.setVisible(true);

            submitButton.addActionListener(this);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Submit")) {
                try {
                    int id = Integer.parseInt(idTextFeild.getText());

                    if (gymMember.size() != 0) {
                        boolean checkArrayValue = false;

                        for (GymMember member : gymMember) {

                            if (member instanceof RegularMember && (member.getId() == id)) {
                                member.activateMembership();
                                checkArrayValue = true;
                                JOptionPane.showMessageDialog(this, "Sucessfully activate your Membership", "Sucess",
                                        JOptionPane.INFORMATION_MESSAGE);
                                break;
                            } else if (member instanceof PremiumMember && (member.getId() == id)) {
                                member.activateMembership();
                                checkArrayValue = true;
                                JOptionPane.showMessageDialog(this, "Sucessfully activated your Membership", "Sucess",
                                        JOptionPane.INFORMATION_MESSAGE);
                                break;
                            }

                        }

                        if (checkArrayValue == false) {

                            JOptionPane.showMessageDialog(this, "Gym memberId didnt match ", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "No gymMember recorded", "Error",
                                JOptionPane.ERROR_MESSAGE);

                    }
                } catch (Exception numError) {
                    JOptionPane.showMessageDialog(this, "please Enter Valid Id", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }

        }
    }

    public class PremiumMemberFrame extends JFrame implements ActionListener {
        //constructor for this class
        public PremiumMemberFrame() {
            //sets titile and adds background color
            this.setTitle("Premium Members");
            this.getContentPane().setBackground(Color.decode("#A3D1C6"));
            
            welcomeTextLabel = new JLabel("Welcome Premium members");
            welcomeTextLabel.setBounds(200, 20, 300, 30);
            welcomeTextLabel.setFont(new Font("SansSerif", Font.BOLD, 18));

            idLabel = new JLabel("ID ");
            idTextFeild = new JTextField();

            idLabel.setBounds(40, 70, 100, 25);
            idTextFeild.setBounds(140, 70, 150, 25);
            
            //sets background color to text feilds
            idTextFeild.setBackground(Color.decode("#FBFFE4"));

            nameLabel = new JLabel("Name ");
            nameTextFeild = new JTextField();

            nameLabel.setBounds(40, 110, 100, 25);
            nameTextFeild.setBounds(140, 110, 150, 25);
            nameTextFeild.setBackground(Color.decode("#FBFFE4"));
            

            locationLabel = new JLabel("Location ");
            locationTextArea = new JTextArea();

            locationLabel.setBounds(40, 280, 150, 30);
            locationTextArea.setBounds(140, 280, 150, 40);
            locationTextArea.setBackground(Color.decode("#FBFFE4"));

            phoneLabel = new JLabel("Phone ");
            phoneTextFeild = new JTextField();

            phoneLabel.setBounds(40, 150, 100, 25);
            phoneTextFeild.setBounds(140, 150, 150, 25);
            phoneTextFeild.setBackground(Color.decode("#FBFFE4"));

            emailLabel = new JLabel("Email ");
            emailTextFeild = new JTextField();

            emailLabel.setBounds(40, 190, 100, 25);
            emailTextFeild.setBounds(140, 190, 150, 25);
            emailTextFeild.setBackground(Color.decode("#FBFFE4"));
            
            // used radio button for Gender
            genderLabel = new JLabel("Gender: ");
            maleButton = new JRadioButton("Male");
            femaleButton = new JRadioButton("Female");
            otherButton = new JRadioButton("Other");

            genderLabel.setBounds(40, 230, 100, 25);
            maleButton.setBounds(140, 230, 60, 25);
            femaleButton.setBounds(200, 230, 80, 25);
            otherButton.setBounds(280, 230, 70, 25);
            
            maleButton.setOpaque(false);
            femaleButton.setOpaque(false);
            otherButton.setOpaque(false);
            // combo box used for Date of Birth
            dateOfBirthLabel = new JLabel("Date Of Birth: ");

            dobYearComboBox = new JComboBox<>();
            for (int i = 1990; i <= 2030; i++) {
                dobYearComboBox.addItem(i);
            }
            //using months array for the month combo box
            String[] months = {
                    "January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"
            };

            dobMonthComboBox = new JComboBox<>(months);

            dobDayComboBox = new JComboBox<>();
            for (int i = 1; i <= 31; i++) {
                dobDayComboBox.addItem(i);
            }

            membershipStartLabel = new JLabel("Membership Start Date: ");

            msYearComboBox = new JComboBox<>();
            for (int i = 2015; i <= 2025; i++) {
                msYearComboBox.addItem(i);
            }

            msMonthComboBox = new JComboBox<>(months);

            msDayComboBox = new JComboBox<>();
            for (int i = 1; i <= 31; i++) {
                msDayComboBox.addItem(i);
            }
            

            dateOfBirthLabel.setBounds(350, 70, 120, 25);
            dobYearComboBox.setBounds(490, 70, 60, 25);
            dobMonthComboBox.setBounds(560, 70, 80, 25);
            dobDayComboBox.setBounds(650, 70, 40, 25);
            
            membershipStartLabel.setBounds(350, 110, 150, 25);
            msYearComboBox.setBounds(490, 110, 60, 25);
            msMonthComboBox.setBounds(560, 110, 80, 25);
            msDayComboBox.setBounds(650, 110, 40, 25);
            
            discountLabel = new JLabel("Discount");
            discountTextFeild = new JTextField("0.00");
            discountTextFeild.setEditable(false);
            
            discountLabel.setBounds(350, 150, 100, 25);
            discountTextFeild.setBounds(490, 150, 150, 25);
            discountTextFeild.setBackground(Color.decode("#FBFFE4"));

            planPriceLabel = new JLabel("Premium Plan Price");
            planPriceTextFeild = new JTextField("50000");
            planPriceTextFeild.setEditable(false);
            
            planPriceLabel.setBounds(350, 190, 130, 25);
            planPriceTextFeild.setBounds(490, 190, 150, 25);
            planPriceTextFeild.setBackground(Color.decode("#FBFFE4"));
            
            trainerNameLabel = new JLabel("Personal Trainer ");
            trainerNameTextFeild = new JTextField();
            
            trainerNameLabel.setBounds(350, 230, 100, 25); 
            trainerNameTextFeild.setBounds(490, 230, 150, 25);
            trainerNameTextFeild.setBackground(Color.decode("#FBFFE4"));

            premiumMemberButton = new JButton("Add Premium Member");
            displayPremiumMemberButton = new JButton("Display Premium Members");
            clearButton = new JButton("Clear");
            markAttendanceButton = new JButton("Mark Attendance");
            activateMemberButton = new JButton("Activate Membership");
            deactivateMemberButton = new JButton("Deactivate Membership");
            revertMemberButton = new JButton("Revert Member");
            returnBackButton=new JButton("Return Back");
            saveToFileButton = new JButton("Save To File");
            upgradePlanButton = new JButton("Upgrade Plan");
            calculateDiscountButton = new JButton("Calculate Discount");
            payDueAmountButton = new JButton("Pay Due Amount");
            readFromFileButton = new JButton("Read From File");
            
            //using set bounds to allowcate the area for the buttons  in our frame
            premiumMemberButton.setBounds(40, 340, 170, 30);
            upgradePlanButton.setBounds(250, 340, 170, 30);
            payDueAmountButton.setBounds(460, 340, 170, 30);
            activateMemberButton.setBounds(40, 380, 170, 30);
            markAttendanceButton.setBounds(250, 380, 170, 30);
            returnBackButton.setBounds(460, 380, 170, 30);
            displayPremiumMemberButton.setBounds(40, 420, 170, 30);
            deactivateMemberButton.setBounds(250, 420, 170, 30);
            calculateDiscountButton.setBounds(460, 420, 170, 30);
            revertMemberButton.setBounds(40, 460, 170, 30);
            saveToFileButton.setBounds(250, 460, 170, 30);
            readFromFileButton.setBounds(460, 460, 170, 30);
            clearButton.setBounds(290, 500, 150, 30);
            
            //setting background color to the buttons
            premiumMemberButton.setBackground(Color.decode("#E5D0AC"));
            displayPremiumMemberButton.setBackground(Color.decode("#E5D0AC"));
            clearButton.setBackground(Color.decode("#E5D0AC"));
            markAttendanceButton.setBackground(Color.decode("#E5D0AC"));
            activateMemberButton.setBackground(Color.decode("#E5D0AC"));
            deactivateMemberButton.setBackground(Color.decode("#E5D0AC"));
            revertMemberButton.setBackground(Color.decode("#E5D0AC"));
            returnBackButton.setBackground(Color.decode("#E5D0AC"));
            saveToFileButton.setBackground(Color.decode("#E5D0AC"));
            upgradePlanButton.setBackground(Color.decode("#E5D0AC"));
            calculateDiscountButton.setBackground(Color.decode("#E5D0AC"));
            payDueAmountButton.setBackground(Color.decode("#E5D0AC"));
            readFromFileButton.setBackground(Color.decode("#E5D0AC"));
            
            //adds the lables and text feilds into the frame.
            this.setTitle("Premium  Members");
            this.add(welcomeTextLabel);
            this.add(idLabel);
            this.add(idTextFeild);
            this.add(nameLabel);
            this.add(nameTextFeild);
            this.add(locationLabel);
            this.add(locationTextArea);
            this.add(phoneLabel);
            this.add(phoneTextFeild);
            this.add(emailLabel);
            this.add(emailTextFeild);
            this.add(genderLabel);
            this.add(maleButton);
            this.add(femaleButton);
            this.add(otherButton);

            this.add(dateOfBirthLabel);
            this.add(dobDayComboBox);
            this.add(dobMonthComboBox);
            this.add(dobYearComboBox);
            this.add(membershipStartLabel);
            this.add(msMonthComboBox);
            this.add(msDayComboBox);
            this.add(msYearComboBox);

            this.add(trainerNameLabel);
            this.add(trainerNameTextFeild);

            this.add(premiumMemberButton);
            this.add(displayPremiumMemberButton);
            this.add(markAttendanceButton);
            this.add(clearButton);
            this.add(activateMemberButton);
            this.add(deactivateMemberButton);
            this.add(revertMemberButton);
            this.add(discountTextFeild);
            this.add(discountLabel);
            this.add(planPriceLabel);
            this.add(planPriceTextFeild);
            this.add(returnBackButton);
            this.add(saveToFileButton);
            this.add(upgradePlanButton);
            this.add(calculateDiscountButton);
            this.add(payDueAmountButton);
            this.add(readFromFileButton);
            
            //make this frame visible and not resizable by making it false
            this.setLayout(null);
            this.setResizable(false);
            this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
            this.setSize(750, 600);
            this.setVisible(true);

            //aading event listener to the buttons
            markAttendanceButton.addActionListener(this);
            clearButton.addActionListener(this);
            premiumMemberButton.addActionListener(this);
            deactivateMemberButton.addActionListener(this);
            activateMemberButton.addActionListener(this);
            revertMemberButton.addActionListener(this);
            returnBackButton.addActionListener(this);
            saveToFileButton.addActionListener(this);
            upgradePlanButton.addActionListener(this);
            calculateDiscountButton.addActionListener(this);
            payDueAmountButton.addActionListener(this);
            readFromFileButton.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Add Premium Member")) {
                try {
                       /*
                        * Gets all the value from the text feilds and checks for any 
                        * invalid input and adds the member if all the values are valid into the array list.
                        */
                    if (idTextFeild.getText().trim().isEmpty() || phoneTextFeild.getText().trim().isEmpty() || nameTextFeild.getText().trim().isEmpty() || emailTextFeild.getText().trim().isEmpty() || trainerNameTextFeild.getText().trim().isEmpty() ){
                        JOptionPane.showMessageDialog(this, "FIll in all the text Feilds", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    String idValue=idTextFeild.getText().trim();
                    int id;
                    try{
                         id = Integer.parseInt(idValue);
                    }catch (NumberFormatException numexception)
                    {
                        JOptionPane.showMessageDialog(this, "Id should contain only Integers ", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                    }
                    
                    //using for each loop to check if id is used or not in either of the memberclass
                    for (GymMember member : gymMember) {
                        
                        if (member instanceof RegularMember && (member.getId() == id)) {

                            JOptionPane.showMessageDialog(this, "Id in used try different one ", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                        if (member instanceof PremiumMember && (member.getId() == id)) {

                            JOptionPane.showMessageDialog(this, "Id in used try different one ", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                    }
                    
                    String name = nameTextFeild.getText().trim();
                    if (name.contains("0") || name.contains("1") || name.contains("2") ||
                        name.contains("3") || name.contains("4") || name.contains("5") ||
                        name.contains("6") || name.contains("7") || name.contains("8") ||
                        name.contains("9")) {
                    
                        JOptionPane.showMessageDialog(this, "Name should not contain numbers. Please fill in proper name", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String location = locationTextArea.getText().trim();
                    String phone = phoneTextFeild.getText().trim();
                    int phoneNumber;
                    //checks for invalid inuput and length of phone number
                    try{
                         phoneNumber = Integer.parseInt(phone);
                    }catch (NumberFormatException numexception)
                    {
                        JOptionPane.showMessageDialog(this, "PhoneNumber should contain only Integers ", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                    }
                    
                    if (phone.length() != 10){
                        JOptionPane.showMessageDialog(this, "Phone Number should contain !0 digits", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                    }
                    
                    String email = emailTextFeild.getText().trim();
                    
                    if (email.contains("@gmail.com")){
                        
                    }else{
                        JOptionPane.showMessageDialog(this, "Invalid Email Should contain @gmail.com", "Error",
                                    JOptionPane.ERROR_MESSAGE);  
                            return;
                    }
                    //assigning null value to the gender so that the selected value can be ammemded
                    String gender = null;
                    if (maleButton.isSelected()) {
                        gender = "Male";
                    } else if (femaleButton.isSelected()) {
                        gender = "female";
                    } else {
                        gender = "other";
                    }
                    
                    String personalTrainer = trainerNameTextFeild.getText().trim();
                    String dobMonth = (String) dobMonthComboBox.getSelectedItem();
                    int dobDay = (Integer) dobDayComboBox.getSelectedItem();
                    int dobYear = (Integer) dobYearComboBox.getSelectedItem();

                    String dateOfBirth = dobMonth + " " + dobDay + " " + dobYear;
                    String msMonth = (String) msMonthComboBox.getSelectedItem();
                    int msDay = (Integer) msDayComboBox.getSelectedItem();
                    int msYear = (Integer) msYearComboBox.getSelectedItem();
                    String membershipStartDate = msMonth + " " + msDay + " " + msYear;

                    PremiumMember premiumMember = new PremiumMember(id, name, location, phone, email, gender,
                            dateOfBirth, membershipStartDate, personalTrainer);

                    gymMember.add(premiumMember);

                    JOptionPane.showMessageDialog(this, "Successfully Added to the list", "Success",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException numError) {
                    JOptionPane.showMessageDialog(this, "please Enter Valid Numerical Values", "Error",
                            JOptionPane.ERROR_MESSAGE);

                }catch (Exception exception) {
                    JOptionPane.showMessageDialog(this, exception.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                

            } else if (e.getActionCommand().equals("Clear")) {
                //clears the feild after the clear button has been clicked. 
                idTextFeild.setText(" ");
                nameTextFeild.setText(" ");
                locationTextArea.setText(" ");
                phoneTextFeild.setText(" ");
                emailTextFeild.setText(" ");
                trainerNameTextFeild.setText(" ");

            } else if (e.getActionCommand().equals("Mark Attendance")) {

                new MarkAttendanceFrame();

            } else if (e.getActionCommand().equals("Revert Member")) {

                new RevertMemberFrame();

            } else if (e.getActionCommand().equals("Activate Membership")) {

                new ActivateMembershipFrame();

            } else if (e.getActionCommand().equals("Deactivate Membership")) {

                new DeactivateMembershipFrame();

            } else if (e.getActionCommand().equals("Display Premium Members")) {
                new DisplayPremiumMemberFrame();

            }else if(e.getActionCommand().equals("Return Back" )){
                frame.setVisible(true);
                
            }else if(e.getActionCommand().equals("Save To File")){
                new WriteFile();
                
            }else if(e.getActionCommand().equals("Read From File")){
                new ReadFile();
                
            }else if (e.getActionCommand().equals("Upgrade Plan")){
                new UpgradePlanFrame();
                
            } else if(e.getActionCommand().equals("Pay Due Amount")){
                new PayDueAmountFrame();
                
            }else if(e.getActionCommand().equals("Calculate Discount")){
                new CalculateDiscount();
                
            }
        }

    }
    
    public class ReadFile {
        FileReader reader = null;
        public ReadFile(){
            
            try {
                
                reader = new FileReader("Membership.txt");
                StringBuilder fileData = new StringBuilder();
                int data;
                
                /*
                 * data is read from the file in the form of a interger(Ascii value)
                 * so we get the value in data and check with -1
                 * since -1 means end of the file
                 * then we convert the data using  inbuilt char function
                */
                while ((data = reader.read()) != -1){
                    //char gives us the charatcer of the aschi value present in the data varaiable
                    fileData.append((char)data);
                    
                }
                
                
                //since file data is a mutable string we change it to inmmutable using to string function
                String value=fileData.toString();
                if (value.trim().isEmpty()){
                    JOptionPane.showMessageDialog(null, value, "No values in the Text file", 
                    JOptionPane.INFORMATION_MESSAGE);
                    
                }else{
                    JOptionPane.showMessageDialog(null, value, "Membership.txt",
                    JOptionPane.INFORMATION_MESSAGE);
                return;
                }
                
                
            }catch(IOException e){
                /*
                 * so printStackTrace helps us find the exact line of code which gave us the erorr 
                 * form the class name to line number
                 * and in which class since it pin poits our error we can make necessary ammendments and debug easily
        
                 */
                e.printStackTrace();
            }finally{
                //this block of code runs even if exception is occured to close file is method id defined here 
                try
                {
                    //closes the file 
                    reader.close();
                }
                
                //using ioe expection to haldle exception related to file not being found in the folder.
                catch (java.io.IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
            
        }
        
    }
    
    public class WriteFile {
        FileWriter writer;
    
        public WriteFile(){
            try {
                //opens the file to write in it
                writer= new FileWriter("Membership.txt");
                   
                try{
                    if (gymMember.size() != 0){
                        
                        // writing the header as provided in the coursework
                        writer.write(String.format("%-5s %-15s %-15s %-15s %-25s %-10s %-15s %-20s %-10s %-10s %-15s %-20s %-20s %-15s %-10s %-15s %-15s %-20s %-20s\n",
                                                "Id", "Name", "Location", "Phone", "Email", "Gender", "Date Of Birth", "Membership Start Date","Attendance", "Active", "Loyalty Points",
                                                "Referral Source", "Personal Trainer", "Plan", "Price","Full Payment", "Discount Amount", "Total Amount Paid", "Removal Reason"));

                        for (GymMember member: gymMember){
                            
                            /*
                             * assignnig the value from get method to the varaiables.
                             * and using object casting to get the methods present to one class only 
                             * and assigns varables to respective value
                             * finanly writting the values into the file using the given string format
                             */
                            int id = member.getId();
                            String name = member.getName();
                            String location = member.getLocation();
                            String phone = member.getPhone();
                            String email = member.getEmail();
                            String gender = member.getGender();
                            String dateOfBirth = member.getDateOfBirth();
                            String membershipStartDate = member.getMembershipStartDate();
                            double attendance = member.getAttendance();
                            boolean activeStatus = member.getActiveStatus();
                            double loyaltyPoints = member.getLoyaltyPoints();
                            
                            //setting default or null value to the varaiable and later changing values through object casting
                            String referralSource = null;
                            String personalTrainer = null;
                            String plan = null;
                            double price = 0.0;
                            boolean fullPayment = false;
                            double discountAmount = 0.0;
                            double totalAmountPaid = 0.0;
                            String removalReason = null;
                                                    
                            if (member instanceof PremiumMember){
                                
                                //object casting done in member
                                PremiumMember premiumMember=(PremiumMember) member;

                                personalTrainer = premiumMember.getPersonalTrainer();
                                plan = "Premium";
                                price = premiumMember.getPremiumCharge();
                                fullPayment = premiumMember.getIsFullPayment();
                                discountAmount = premiumMember.getDiscountAmount();
                                totalAmountPaid = premiumMember.getPaidAmount();
                                
                            }else{
                                //object casting done in member
                                RegularMember regularMember =(RegularMember) member;
                                referralSource = regularMember.getReferralSource();
                                plan = regularMember.getPlan();
                                price = regularMember.getPlanPrice(plan);
                                removalReason = regularMember.getRemovalReason();                                
                            }
                            //writting the values to the file using inbuilt method of string named string.format
                            writer.write(String.format("%-5s %-15s %-15s %-15s %-25s %-10s %-15s %-20s %-10s %-10s %-15s %-20s %-20s %-15s %-10s %-15s %-15s %-20s %-20s\n",
                                    id, name, location, phone, email, gender, dateOfBirth, membershipStartDate,
                                    attendance, activeStatus, loyaltyPoints,
                                    referralSource, personalTrainer, plan, price, fullPayment,
                                    discountAmount, totalAmountPaid, removalReason));
                            
                        }
                        //displayes sucess message after all the data present in the array list is being added
                        JOptionPane.showMessageDialog(null, "The data has been added to the file" , "Sucess",
                                    JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }else{
                        
                        //displyes error message when no data is found
                        JOptionPane.showMessageDialog(null,"No member is persent in the List" , "Error",
                                    JOptionPane.ERROR_MESSAGE);
                                    
                        JOptionPane.showMessageDialog(null,"First add members" , "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }catch(IOException e){
                    JOptionPane.showMessageDialog(null,e.getMessage(), "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
            }catch(IOException e){
                /*
                 * so printStackTrace helps us find the exact line of code which gave us the erorr 
                 * form the class name to line number
                 * and in which class since it pin poits our error we can make necessary ammendments and debug easily
        
                 */
                e.printStackTrace();
            }finally{
                try
                {
                    //closes the file after every thing has been done writting
                    writer.close();
                }
                catch (java.io.IOException ioe)
                
                {
                    //handles the file no found erorr and pin points the error.
                    ioe.printStackTrace();
                }
            
            }
        }
        
    }
    
    public static void main(String[] args){
        new GYMGui();
    }
}
