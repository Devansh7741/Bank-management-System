import java.sql.*;
public class ConnectionFactory {
    Connection con;
    Statement stmt;

    public ConnectionFactory(){
        try{
            //Loading the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Establish the connection with database..
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagement", "root", "shravani8857");
            stmt=con.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
