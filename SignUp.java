import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
public class SignUp extends JFrame implements ActionListener{
    
    //Instance Variables..
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
    JTextField tfName,tfFatherName,tfEmail,tfAddress,tfCity,tfPinCode,tfState;
    JRadioButton rbnMale,rbnFemale,rbnMarried,rbnSingle;
    JButton btnNext;
    JDateChooser dateChooser;

    Random r = new Random();
    long randNum = r.nextLong()%9000+1000;
    String number = Long.toString(Math.abs(randNum)); //Math.abs converts randomly generated negative no. to posititve no.

    public SignUp(){
        setTitle("New Account Application Form");
        setLayout(null);

        l1=new JLabel("Application Form: "+number);
        l1.setFont(new Font("Raleway",Font.BOLD,40));
        l1.setBounds(200, 20, 600,40);
        add(l1);

        l2=new JLabel("Personal Details of Customer");
        l2.setFont(new Font("Georgia",Font.BOLD,25));
        l2.setBounds(250, 80, 600,30);
        add(l2);

        l3=new JLabel("Your Name:");
        l3.setFont(new Font("Georgia",Font.BOLD,22));
        l3.setBounds(100, 150, 300,30);
        add(l3);
        tfName=new JTextField(20);
        tfName.setFont(new Font("Georgia",Font.BOLD,15));
        tfName.setBounds(300, 150, 400, 30);
        add(tfName);

        l4=new JLabel("Father Name:");
        l4.setFont(new Font("Georgia",Font.BOLD,22));
        l4.setBounds(100, 200, 600,30);
        add(l4);
        tfFatherName=new JTextField(20);
        tfFatherName.setFont(new Font("Georgia",Font.BOLD,15));
        tfFatherName.setBounds(300, 200, 400, 30);
        add(tfFatherName);

        l5=new JLabel("Date Of Birth:");
        l5.setFont(new Font("Georgia",Font.BOLD,22));
        l5.setBounds(100, 250, 600,30);
        add(l5);

        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,250,400,30);
        add(dateChooser);

        l6=new JLabel("Gender:");
        l6.setFont(new Font("Georgia",Font.BOLD,22));
        l6.setBounds(100, 300, 600,30);
        add(l6);

        rbnMale=new JRadioButton("Male");
        rbnMale.setFont(new Font("Georgia",Font.BOLD,14));
        rbnMale.setBackground(Color.white);
        rbnMale.setBounds(300,300,100,30);
        add(rbnMale);

        rbnFemale=new JRadioButton("Female");
        rbnFemale.setFont(new Font("Georgia",Font.BOLD,14));
        rbnFemale.setBackground(Color.white);
        rbnFemale.setBounds(400,300,100,30);
        add(rbnFemale);

        //Button Group is use to tick only one radio button..
        ButtonGroup bgGender=new ButtonGroup();
        bgGender.add(rbnMale);
        bgGender.add(rbnFemale);

        l7=new JLabel("Email Address:");
        l7.setFont(new Font("Georgia",Font.BOLD,22));
        l7.setBounds(100, 350, 600,30);
        add(l7);
        tfEmail=new JTextField(20);
        tfEmail.setFont(new Font("Georgia",Font.BOLD,15));
        tfEmail.setBounds(300, 350, 400, 30);
        add(tfEmail);

        l8=new JLabel("Marital Status:");
        l8.setFont(new Font("Georgia",Font.BOLD,22));
        l8.setBounds(100, 400, 600,30);
        add(l8);

        rbnMarried=new JRadioButton("Married");
        rbnMarried.setFont(new Font("Georgia",Font.BOLD,14));
        rbnMarried.setBackground(Color.white);
        rbnMarried.setBounds(300,400,100,30);
        add(rbnMarried);

        rbnSingle=new JRadioButton("Single");
        rbnSingle.setFont(new Font("Georgia",Font.BOLD,14));
        rbnSingle.setBackground(Color.white);
        rbnSingle.setBounds(400,400,100,30);
        add(rbnSingle);

        ButtonGroup bgStatus=new ButtonGroup();
        bgStatus.add(rbnMarried);
        bgStatus.add(rbnSingle);

        l9=new JLabel("Address:");
        l9.setFont(new Font("Georgia",Font.BOLD,22));
        l9.setBounds(100, 450, 600,30);
        add(l9);
        tfAddress=new JTextField(30);
        tfAddress.setFont(new Font("Georgia",Font.BOLD,15));
        tfAddress.setBounds(300, 450, 400, 30);
        add(tfAddress);

        l10=new JLabel("City:");
        l10.setFont(new Font("Georgia",Font.BOLD,22));
        l10.setBounds(100, 500, 600,30);
        add(l10);
        tfCity=new JTextField(20);
        tfCity.setFont(new Font("Georgia",Font.BOLD,15));
        tfCity.setBounds(300, 500, 400, 30);
        add(tfCity);

        l11=new JLabel("Pin Code:");
        l11.setFont(new Font("Georgia",Font.BOLD,22));
        l11.setBounds(100, 550, 600,30);
        add(l11);
        tfPinCode=new JTextField(30);
        tfPinCode.setFont(new Font("Georgia",Font.BOLD,15));
        tfPinCode.setBounds(300, 550, 400, 30);
        add(tfPinCode);

        l12=new JLabel("State:");
        l12.setFont(new Font("Georgia",Font.BOLD,22));
        l12.setBounds(100, 600, 600,30);
        add(l12);
        tfState=new JTextField(30);
        tfState.setFont(new Font("Georgia",Font.BOLD,15));
        tfState.setBounds(300, 600, 400, 30);
        add(tfState);

        btnNext=new JButton("Next");
        btnNext.setFont(new Font("Georgia",Font.BOLD,15));
        btnNext.setBackground(Color.black);
        btnNext.setForeground(Color.white);
        btnNext.setBounds(750,620,80,30);
        add(btnNext);
        btnNext.addActionListener(this);

        l13=new JLabel("Date:");
        l13.setFont(new Font("Georgia",Font.BOLD,22));
        l13.setBounds(100, 650, 600,30);
        add(l13);

        l14=new JLabel("Month:");
        l14.setFont(new Font("Georgia",Font.BOLD,22));
        l14.setBounds(100, 700, 600,30);
        add(l14);

        l15=new JLabel("Year:");
        l15.setFont(new Font("Georgia",Font.BOLD,22));
        l15.setBounds(100, 750, 600,30);
        add(l15);

        getContentPane().setBackground(Color.white);
        setVisible(true);
        setSize(800,700);
        setLocation(400, 100);
    }
    public static void main(String[] args) {
        SignUp obj=new SignUp();
    }

    public void actionPerformed(ActionEvent e){
        
        String formNum=number;
        String name=tfName.getText();
        String fname=tfFatherName.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(rbnMale.isSelected()){
            gender="Male";
        }
        else if(rbnFemale.isSelected()){
            gender="Female";
        }
        String email=tfEmail.getText();
        String maritalStatus=null;
        if(rbnMarried.isSelected()){
            maritalStatus="Married";
        }
        else if(rbnSingle.isSelected()){
            maritalStatus="Single";
        }
        String address=tfAddress.getText();
        String city=tfCity.getText();
        String pincode=tfPinCode.getText();
        String State=tfState.getText();

        try{
            if(tfName.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter your name");
            }
            else{
                ConnectionFactory cf=new ConnectionFactory();
                String query="insert into signup values('"+formNum+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+maritalStatus+"','"+address+"','"+city+"','"+pincode+"','"+State+"')";
                cf.stmt.executeUpdate(query);

               // JOptionPane.showMessageDialog(null,"Successfully Created..");
               //first signup page gets hide..
               setVisible(false);
               new SignupTwo(formNum).setVisible(true);
            }   
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}


