package DB_samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Insert_tables {
    public static void main(String args[]) {
        // insertMUltipleData();
      //  public insertDataWithDate();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","Chargeback@123");
            Statement stmt = con.createStatement();//create obj for execute the sql quries
            stmt.execute("insert into employee_details(name,designation,experience)values('kowsi','system_work','2')");//execute the query in the mysql
            //con.close();
            System.out.println("insert completed");
            ResultSet resultSet=stmt.executeQuery("select * from employee_details");
            while(resultSet.next()) {
                //System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                System.out.println("id :" + resultSet.getString("id"));
                System.out.println("name :" + resultSet.getString("name"));
                System.out.println("designation :" + resultSet.getString("designation"));
                System.out.println("experince :" + resultSet.getString("experience"));
                System.out.println("-------------");
            }
        }catch(Exception e){ System.out.println(e);}

    }
}
