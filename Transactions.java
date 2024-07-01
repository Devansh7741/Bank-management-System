
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Transactions extends JFrame implements ActionListener{

    //Instance Variables
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,btnExit;
    String pin;
    //Parameterized Constructor
    public Transactions(String pin){
        setTitle("Transactions Page");
        this.pin=pin;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm3.jpg"));
        Image i2=i1.getImage().getScaledInstance(1000, 1100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel lblImage=new JLabel(i3);
        lblImage.setBounds(0,0,960,1000);
        add(lblImage);

        l1=new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.white);
        l1.setFont(new Font("Georgia",Font.BOLD,30));

        l1.setBounds(290,160,700,50);
        // add(l1);
        lblImage.add(l1);

        b1=new JButton("DEPOSIT");
        b2=new JButton("WITHDRAWL");
        b3=new JButton("FAST CASH");
        b4=new JButton("MINI STATEMENT");
        b5=new JButton("PIN CHANGE");
        b6=new JButton("BALANCE CHECK");
        btnExit=new JButton("EXIT");

        b1.setBounds(150,300,150,40);
        b1.setFont(new Font("Georgia",Font.BOLD,20));
        lblImage.add(b1);

        b2.setBounds(650,300,200,40);
        b2.setFont(new Font("Georgia",Font.BOLD,20));
        lblImage.add(b2);

        b3.setBounds(130,400,200,40);
        b3.setFont(new Font("Georgia",Font.BOLD,20));
        lblImage.add(b3);

        b4.setBounds(630,400,250,40);
        b4.setFont(new Font("Georgia",Font.BOLD,20));
        lblImage.add(b4);

        b5.setBounds(130,500,200,40);
        b5.setFont(new Font("Georgia",Font.BOLD,20));
        lblImage.add(b5);

        b6.setBounds(630,500,250,40);
        b6.setFont(new Font("Georgia",Font.BOLD,20));
        lblImage.add(b6);

        btnExit.setBounds(360,600,250,40);
        btnExit.setFont(new Font("Georgia",Font.BOLD,20));
        lblImage.add(btnExit);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        btnExit.addActionListener(this);

        setSize(960,1000);
        setLocation(300, 0);
        setUndecorated(true); //use to disable minimize,maximize and close button from frame.
        setVisible(true);
    }
    public static void main(String[] args) {
        new Transactions("");
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==btnExit){
            System.exit(0);
        }
        else if(ae.getSource()==b1){
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }
        else if(ae.getSource()==b2){
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
    }
}
}
