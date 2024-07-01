import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import java.awt.*;

public class Withdrawl extends JFrame implements ActionListener{

    JTextField tf1,tf2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    String pin;

    public Withdrawl(String pin) {
        this.pin = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1000);
        add(l3);

        l1 = new JLabel("MAX. WITHDRWAL IS RS.10,000.");
        l1.setForeground(Color.white);
        l1.setFont(new Font("Georgia", Font.BOLD, 30));
        l1.setBounds(310, 140, 700, 50);
        l3.add(l1);

        l2 = new JLabel("Please Enter Your Amount:");
        l2.setForeground(Color.white);
        l2.setFont(new Font("Georgia", Font.BOLD, 30));
        l2.setBounds(310, 200, 700, 50);
        l3.add(l2);

        tf1=new JTextField();
        tf1.setFont(new Font("Georgia", Font.BOLD, 30));
        tf1.setBounds(335, 250, 400, 50);
        l3.add(tf1);

        b1=new JButton("WITHDRAW");
        b1.setFont(new Font("Georgia", Font.BOLD, 20));
        b1.setBounds(590, 500, 300, 50);
        l3.add(b1);

        b2=new JButton("BACK");
        b2.setFont(new Font("Georgia", Font.BOLD, 20));
        b2.setBounds(590, 580, 300, 50);
        l3.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(960, 1000);
        setLocation(300, 0);
        setVisible(true);

    }


    public void actionPerformed(ActionEvent ae) {
        try{
            String amount=tf1.getText();
            Date date=new Date();
            if(ae.getSource()==b1){
                if(tf1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter amount you want to withdraw!!");

                }
                else{
                    ConnectionFactory cf=new ConnectionFactory();
                    ResultSet rs=cf.stmt.executeQuery("select * from bank where pin='"+pin+"'");

                    int balance=0;
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance +=Integer.parseInt(rs.getString("amount"));
                        }
                        else{
                            balance-=Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    if(balance<Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String formattedDate = sdf.format(date);
                    cf.stmt.executeUpdate("INSERT INTO bank (pin, date, type, amount) VALUES ('" + pin + "', '" + formattedDate + "', 'Withdraw', '" + amount + "')");
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+"Debited Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }
            else if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }
        catch(Exception e){
            e.printStackTrace();
           
        }
    }
    
    public static void main(String[] args) {
        new Withdrawl("").setVisible(true);
    }
}
