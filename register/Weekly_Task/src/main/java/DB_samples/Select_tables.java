package DB_samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select_tables {
    public static void main(String args[]) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","Chargeback@123");
            Statement statement = con.createStatement();//create obj for execute the sql quries
            ResultSet resultSet = statement.executeQuery("select * from employee_details");//execute the query in the mysql
            //below loop will execute till last data in employee_tables
            while(resultSet.next()) {
                //access the data using columnname from the table
                System.out.println("id :"+resultSet.getString("id"));
                System.out.println("name :"+resultSet.getString("name"));
                System.out.println("designation :"+resultSet.getString("designation"));
                System.out.println("experince :"+resultSet.getString("experience"));
                System.out.println("--------------------------");
            }
        }catch(Exception e){ System.out.println(e);}
    }
}
