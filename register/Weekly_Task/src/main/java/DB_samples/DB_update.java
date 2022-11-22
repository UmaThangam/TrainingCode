package DB_samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB_update {
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","Chargeback@123");
            Statement statement = con.createStatement();//create obj for execute the sql quries
            statement.execute("update employee_details set experience='1' where id = 2");//execute the updated query in the mysql
            con.close();
            System.out.println("update completed");
        }catch(Exception e) {
            System.out.println(e);
        }
}
}
