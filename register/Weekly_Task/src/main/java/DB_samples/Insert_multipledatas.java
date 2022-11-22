package DB_samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Insert_multipledatas {
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","Chargeback@123");
            Statement stmt = con.createStatement();//create obj for execute the sql quries
            for(int i = 1;i<3;i++){
                String name = "meera"+i;
                String designation = "TL"+i;
                String experience  = "3";
                stmt.execute("insert into employee_details(name,designation,experience)values('"+name+"','"+designation+"','"+experience+"')");
            }
            System.out.println("insert completed");
            ResultSet resultSet=stmt.executeQuery("select * from employee_details");
            while(resultSet.next()) {
                System.out.println("id :" + resultSet.getString("id"));
                System.out.println("name :" + resultSet.getString("name"));
                System.out.println("designation :" + resultSet.getString("designation"));
                System.out.println("experince :" + resultSet.getString("experience"));
                System.out.println("-------------");
            }
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
