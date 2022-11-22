package DB_samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dbselect_condition {
    public static void main(String args[]) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","Chargeback@123");
            Statement stmt = con.createStatement();//create obj for execute the sql quries
            ResultSet resultSet = stmt.executeQuery("select * from employee_details where experience >5 ");//execute the query with limit
            if(resultSet.next()){
                System.out.println("given user is present.");
                System.out.println("id :"+resultSet.getString("id"));
                System.out.println("name :"+resultSet.getString("name"));
                System.out.println("designation :"+resultSet.getString("designation"));
                System.out.println("experince :"+resultSet.getString("experience"));
            }else{
                System.out.println("user is not exist.Please provide the proper credentials");
            }
//            //below loop will execute till last data
//            while(resDb.next()) {
//                //access the data using columnname from the table
//                System.out.println(resDb.getInt("id") + " " + resDb.getString("name") + " " + resDb.getString("email"));
//            }
        }catch(Exception e){ System.out.println(e);}
    }
}
