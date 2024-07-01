import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;

public class Deposit extends JFrame implements ActionListener {
    JTextField tf1;
    JButton b1, b2;
    JLabel l1, l3;
    String pin;

    public Deposit(String pin) {
        this.pin = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1000);
        add(l3);

        l1 = new JLabel("Enter amount you want to deposit.");
        l1.setForeground(Color.white);
        l1.setFont(new Font("Georgia", Font.BOLD, 30));
        l1.setBounds(310, 140, 700, 50);
        l3.add(l1);

        tf1 = new JTextField();
        tf1.setFont(new Font("Georgia", Font.BOLD, 30));
        tf1.setBounds(330, 200, 500, 50);
        l3.add(tf1);

        b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("Georgia", Font.BOLD, 20));
        b1.setBounds(590, 500, 300, 50);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setFont(new Font("Georgia", Font.BOLD, 20));
        b2.setBounds(590, 580, 300, 50);
        l3.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(960, 1000);
        setLocation(300, 0);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Deposit("").setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = tf1.getText();
            Date date = new Date();
            if (ae.getSource() == b1) {
                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter some amount");
                } else {
                    ConnectionFactory cf = new ConnectionFactory();
                    String query = "INSERT INTO bank (pin, date, type, amount) VALUES (?, ?, ?, ?)";
                    PreparedStatement pstmt = cf.con.prepareStatement(query);
                    pstmt.setString(1, pin);
                    pstmt.setTimestamp(2, new Timestamp(date.getTime()));
                    pstmt.setString(3, "Deposit");
                    pstmt.setString(4, amount);
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            } else if (ae.getSource() == b2) {
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
