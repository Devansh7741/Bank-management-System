import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener{

    //Instance Variables..
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton b1,b2;
    String formno;
    
    public SignupThree(String formno){
        this.formno=formno;
        setTitle("New ACcount Application Form-Page-3");
        setLayout(null);
        l1=new JLabel("Page-3: Account Details");
        l1.setFont(new Font("Georgia",Font.BOLD,25));
        l1.setBounds(280,40,400,40);
        add(l1);

        l2=new JLabel("Account Type:");
        l2.setFont(new Font("Georgia",Font.BOLD,18));
        l2.setBounds(100,140,200,30);
        add(l2);

        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Georgia",Font.BOLD,16));
        r1.setBackground(Color.white);
        r1.setBounds(100, 180, 180, 30);
        add(r1);

        r2=new JRadioButton("Fix Deposit Account");
        r2.setFont(new Font("Georgia",Font.BOLD,16));
        r2.setBackground(Color.white);
        r2.setBounds(300, 180, 200, 30);
        add(r2);

        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Georgia",Font.BOLD,16));
        r3.setBackground(Color.white);
        r3.setBounds(520, 180, 180, 30);
        add(r3);

        ButtonGroup bg1=new ButtonGroup();
        bg1.add(r1);
        bg1.add(r2);
        bg1.add(r3);

        l3=new JLabel("Card Number:");
        l3.setFont(new Font("Georgia",Font.BOLD,18));
        l3.setBounds(100, 240, 200, 30);
        add(l3);

        l4=new JLabel("XXXX-XXX-XXX-9568");
        l4.setFont(new Font("Georgia",Font.BOLD,18));
        l4.setBounds(300, 240, 250, 30);
        add(l4);

        l5=new JLabel("[Your 14-Digit Card No.]");
        l5.setFont(new Font("Arial",Font.BOLD,15));
        l5.setBounds(100, 270, 200, 20);
        add(l5);

        l6=new JLabel("It Would be Visible on ATM Card");
        l6.setFont(new Font("Georgia",Font.BOLD,15));
        l6.setBounds(300, 240, 300, 80);
        add(l6);

        l7=new JLabel("PIN:");
        l7.setFont(new Font("Georgia",Font.BOLD,18));
        l7.setBounds(100, 320, 200, 30);
        add(l7);

        l8=new JLabel("XXXX");
        l8.setFont(new Font("Georgia",Font.BOLD,18));
        l8.setBounds(200, 320, 200, 30);
        add(l8);

        l9=new JLabel("Service Required By You:");
        l9.setFont(new Font("Georgia",Font.BOLD,18));
        l9.setBounds(100, 370, 300, 30);
        add(l9);

        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Georgia",Font.BOLD,16));
        c1.setBounds(100,420,200,30);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Georgia",Font.BOLD,16));
        c2.setBounds(300,420,200,30);
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Georgia",Font.BOLD,16));
        c3.setBounds(100,470,200,30);
        add(c3);

        b1=new JButton("Submit");
        b1.setFont(new Font("Georgia",Font.BOLD,15));
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(100,520,200,30);
        add(b1);

        b2=new JButton("Cancel");
        b2.setFont(new Font("Georgia",Font.BOLD,15));
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(350,520,200,30);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(850,900);
        setLocation(350,120);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SignupThree("");
    }

    public void actionPerformed(ActionEvent ae) {
        String atype=null;
        if(r1.isSelected()){
            atype="Saving Account";
        }
        else if(r2.isSelected()){
            atype="Fix Deposit Account";
        }
        else if(r3.isSelected()){
            atype="Current Account";
        }
        Random random=new Random();
        //Number Generator Logic
        long num1=(random.nextLong()%90000000L)+50409360000000L;
        String cardNum=""+Math.abs(num1);

        long num2=(random.nextLong()%9000L)+1000L;
        String pinNum=""+Math.abs(num2);

        String facility="";
        if(c1.isSelected()){
            facility=facility+"ATM Card";
        }
        if(c2.isSelected()){
            facility=facility+"Internet Banking";
        }
        if(c3.isSelected()){
            facility=facility+"Mobile banking";
        }

        try{
            if(ae.getSource()==b1){
                if(atype.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Select the Account Type");
                }
                else{
                    ConnectionFactory con=new ConnectionFactory();
                    String query1="insert into Signupthree values('"+formno+"','"+atype+"','"+cardNum+"','"+pinNum+"','"+facility+"')";
                    String query2="insert into Login values('"+formno+"','"+cardNum+"','"+pinNum+"')";
                    con.stmt.executeUpdate(query1);
                    con.stmt.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card Number:"+cardNum+"\n PIN:"+pinNum);

                    new Deposit(pinNum).setVisible(true);
                    setVisible(false);

                }


            }
            else if(ae.getSource()==b2){
                //System.exit(0);
                setVisible(false);
                new Login().setVisible(true);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }

    
}
