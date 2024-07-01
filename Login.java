import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class Login extends JFrame implements ActionListener{
    //Instance variable..

    JLabel lblWelcome,lblCardNumber,lblPinNumber;
    JTextField tfCardNumber;
    JPasswordField pfPinNumber;
    JButton btnLogin,btnClear,btnSignup;

    public Login(){
        setTitle("Bank Management System");
        //To disable the default layout of frame..
        setLayout(null);
        lblWelcome=new JLabel("Welcome to our Bank");
        lblWelcome.setFont(new Font("Georgia",Font.BOLD,35));
        lblWelcome.setBounds(200, 40, 430, 40);
        add(lblWelcome);

        lblCardNumber=new JLabel("Enter Card Number:");
        lblCardNumber.setFont(new Font("Georgia",Font.BOLD,25));
        lblCardNumber.setBounds(120, 140, 400, 30);
        add(lblCardNumber);

        tfCardNumber=new JTextField(20);
        tfCardNumber.setBounds(400, 140, 230, 30);
        tfCardNumber.setFont(new Font("Georgia",Font.BOLD,15));
        add(tfCardNumber);

        lblPinNumber=new JLabel("Enter Pin Number:");
        lblPinNumber.setFont(new Font("Georgia",Font.BOLD,25));
        lblPinNumber.setBounds(120, 240, 400, 30);
        add(lblPinNumber);

        pfPinNumber=new JPasswordField(20);
        pfPinNumber.setBounds(400, 240, 230, 30);
        pfPinNumber.setFont(new Font("Georgia",Font.BOLD,15));
        add(pfPinNumber);

        btnLogin=new JButton("Login");
        btnLogin.setBackground(Color.black);
        btnLogin.setForeground(Color.white);

        btnClear=new JButton("Clear");
        btnClear.setBackground(Color.black);
        btnClear.setForeground(Color.white);

        btnSignup=new JButton("Sign Up");
        btnSignup.setBackground(Color.black);
        btnSignup.setForeground(Color.white);

        btnLogin.setFont(new Font("Georgia",Font.BOLD,15));
        btnLogin.setBounds(400, 300, 100, 40);
        add(btnLogin);
        
        btnClear.setFont(new Font("Georgia",Font.BOLD,15));
        btnClear.setBounds(500, 300, 100, 40);
        add(btnClear);

        btnSignup.setFont(new Font("Georgia",Font.BOLD,15));
        btnSignup.setBounds(600, 300, 100, 40);
        add(btnSignup);

        btnLogin.addActionListener(this);
        btnClear.addActionListener(this);
        btnSignup.addActionListener(this);

        setVisible(true);
        setSize(800, 500);
        setLocation(400,200);
        //Changing the background color..
        getContentPane().setBackground(Color.white);
    }

    public static void main(String[] args) {
        Login obj=new Login();
    }
    //This method is automatically called when you click on any button..
    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource()==btnLogin){
                //Login Purpose
                ConnectionFactory cf=new ConnectionFactory();
                String cardNum=tfCardNumber.getText();
                String pinNum=pfPinNumber.getText();

                String query="Select * from Login where cardnumber='"+cardNum+"' and pin='"+pinNum+"'";
                ResultSet rs=cf.stmt.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNum).setVisible(true);
                }
                else{
                     JOptionPane.showMessageDialog(null, "Either Card Nmber or Pin Nmber is wrong!!");
                }
            }
            else if(ae.getSource()==btnClear){
                tfCardNumber.setText("");
                pfPinNumber.setText("");
            }  
            else if(ae.getSource()==btnSignup){
                this.setVisible(false);  //Use to close the login page and go on signup page
                new SignUp();//Sign up page
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
