import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
public class SignupTwo extends JFrame implements ActionListener{
    
    //Instance Variables..
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
    JTextField tfAadhar,tfPan;
    JRadioButton rbnCitizenYes,rbnCitizenNo,rbnAccountYes,rbnAccountNo;
    JComboBox<String> jcbReligion,jcbCategory,jcbIncome,jcbEducation,jcbOccupation;
    JButton btnNext;
    JDateChooser dateChooser;

    
    String formno = "";

    public SignupTwo(String formno){
        this.formno=formno;
        setTitle("New Account Application Form-Page-2");
        setLayout(null);

        l2=new JLabel("Additional Details of Customer");
        l2.setFont(new Font("Georgia",Font.BOLD,25));
        l2.setBounds(250, 80, 600,30);
        add(l2);

        l3=new JLabel("Religion:");
        l3.setFont(new Font("Georgia",Font.BOLD,22));
        l3.setBounds(100, 150, 300,30);
        add(l3);

        String[] religion={"Hindu","Muslim","Sikh","Christian","Other"};
        jcbReligion=new JComboBox(religion);
        jcbReligion.setBackground(Color.white);
        jcbReligion.setFont(new Font("Georgia",Font.BOLD,15));
        jcbReligion.setBounds(300, 150, 400, 30);
        add(jcbReligion);

        l4=new JLabel("Category:");
        l4.setFont(new Font("Georgia",Font.BOLD,22));
        l4.setBounds(100, 200, 600,30);
        add(l4);

        String category[]={"General","SC","ST","OBC","OTHER"};
        jcbCategory=new JComboBox(category);
        jcbCategory.setBackground(Color.white);
        jcbCategory.setFont(new Font("Georgia",Font.BOLD,15));
        jcbCategory.setBounds(300, 200, 400, 30);
        add(jcbCategory);

        l5=new JLabel("Income:");
        l5.setFont(new Font("Georgia",Font.BOLD,22));
        l5.setBounds(100, 250, 600,30);
        add(l5);

        String income[]={"Null","<1,50,000","<2,50,000","<5,00,000","More than 5,00,000"};
        jcbIncome=new JComboBox(income);
        jcbIncome.setBackground(Color.white);
        jcbIncome.setBounds(300,250,400,30);
        add(jcbIncome);

        l6=new JLabel("Educational");
        l6.setFont(new Font("Georgia",Font.BOLD,22));
        l6.setBounds(100, 300, 600,30);
        add(l6);
        l7=new JLabel("Qualification:");
        l7.setFont(new Font("Georgia",Font.BOLD,22));
        l7.setBounds(100, 335, 600,30);
        add(l7);

        String education[]={"Non-Graduate","Graduate","Post-Graduate","Doctorate"};
        jcbEducation=new JComboBox(education);
        jcbEducation.setBackground(Color.white);
        jcbEducation.setFont(new Font("Georgia",Font.BOLD,15));    
        jcbEducation.setBounds(300, 335, 400, 30);
        add(jcbEducation);

        l8=new JLabel("Occupation:");
        l8.setFont(new Font("Georgia",Font.BOLD,22));
        l8.setBounds(100, 400, 600,30);
        add(l8);

        String occupation[]={"Salaried","Self-Employed","Business","Student","Retired","Others"};
        jcbOccupation=new JComboBox(occupation);
        jcbOccupation.setFont(new Font("Georgia",Font.BOLD,14));
        jcbOccupation.setBackground(Color.white);
        jcbOccupation.setBounds(300,400,100,30);
        add(jcbOccupation);

        l9=new JLabel("PAN Card no.:");
        l9.setFont(new Font("Georgia",Font.BOLD,22));
        l9.setBounds(100, 450, 600,30);
        add(l9);
        tfPan=new JTextField(30);
        tfPan.setFont(new Font("Georgia",Font.BOLD,15));
        tfPan.setBounds(300, 450, 400, 30);
        add(tfPan);

        l10=new JLabel("Aadhar Card no.:");
        l10.setFont(new Font("Georgia",Font.BOLD,22));
        l10.setBounds(100, 500, 600,30);
        add(l10);
        tfAadhar=new JTextField(20);
        tfAadhar.setFont(new Font("Georgia",Font.BOLD,15));
        tfAadhar.setBounds(315, 500, 400, 30);
        add(tfAadhar);

        
        l11=new JLabel("Senior Citizen:");
        l11.setFont(new Font("Georgia",Font.BOLD,22));
        l11.setBounds(100, 550, 600,30);
        add(l11);
        
        rbnCitizenYes=new JRadioButton("Yes");
        rbnCitizenYes.setFont(new Font("Georgia",Font.BOLD,14));
        rbnCitizenYes.setBackground(Color.white);
        rbnCitizenYes.setBounds(300,550,100,30);
        add(rbnCitizenYes);

        rbnCitizenNo=new JRadioButton("No");
        rbnCitizenNo.setFont(new Font("Georgia",Font.BOLD,14));
        rbnCitizenNo.setBackground(Color.white);
        rbnCitizenNo.setBounds(400,550,100,30);
        add(rbnCitizenNo);

        ButtonGroup bgCitizen=new ButtonGroup();
        bgCitizen.add(rbnCitizenYes);
        bgCitizen.add(rbnCitizenNo);

        l12=new JLabel("Existing Account:");
        l12.setFont(new Font("Georgia",Font.BOLD,22));
        l12.setBounds(100, 600, 600,30);
        add(l12);
        
        rbnAccountYes=new JRadioButton("Yes");
        rbnAccountYes.setFont(new Font("Georgia",Font.BOLD,14));
        rbnAccountYes.setBackground(Color.white);
        rbnAccountYes.setBounds(300,600,100,30);
        add(rbnAccountYes);

        rbnAccountNo=new JRadioButton("No");
        rbnAccountNo.setFont(new Font("Georgia",Font.BOLD,14));
        rbnAccountNo.setBackground(Color.white);
        rbnAccountNo.setBounds(400,600,100,30);
        add(rbnAccountNo);

        ButtonGroup bgAccount=new ButtonGroup();
        bgAccount.add(rbnAccountYes);
        bgAccount.add(rbnAccountNo);

        btnNext=new JButton("Next");
        btnNext.setFont(new Font("Georgia",Font.BOLD,15));
        btnNext.setBackground(Color.black);
        btnNext.setForeground(Color.white);
        btnNext.setBounds(750,620,80,30);
        add(btnNext);
        btnNext.addActionListener(this);


        getContentPane().setBackground(Color.white);
        setVisible(true);
        setSize(800,700);
        setLocation(400, 100);
    }
    public static void main(String[] args) {
        SignupTwo obj=new SignupTwo("");
    }

    public void actionPerformed(ActionEvent e){
       
        String religion=(String) jcbReligion.getSelectedItem();
        String category=(String) jcbCategory.getSelectedItem();
        String income=(String) jcbIncome.getSelectedItem();
        String education=(String) jcbEducation.getSelectedItem();
        String occupation=(String) jcbOccupation.getSelectedItem();
        String pan=tfPan.getText();
        String aadhar=tfAadhar.getText();
        String citizen="";
        if(rbnCitizenYes.isSelected()){
            citizen="Yes";
        }
        else if(rbnCitizenNo.isSelected()){
            citizen="No";
        }
        String account="";
        if(rbnAccountYes.isSelected()){
            account="Yes";
        }
        else if(rbnAccountNo.isSelected()){
            account="No";
        }

        try{
            ConnectionFactory cf=new ConnectionFactory();
            String query="insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+citizen+"','"+account+"')";
            cf.stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Successfully Created..");
            new SignupThree(formno).setVisible(true);
            setVisible(false);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}


