package DB_samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Insertdata_withdate {
    public static void insertDataWithDate() {
        try {
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date = simpleDateFormat.format(new Date());//current date
            System.out.println(date);
            Class.forName("com.mysql.cj.jdbc.Driver");//mysql driver from the exteranl jar
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Chargeback@123");
            Statement stmt = con.createStatement();//create obj for execute the sql quries
            stmt.execute("insert into user(name,email,password,dob)values('testdob','testdob1@gmail.com','testdobpwd','" + date + "')");
          //  stmt.execute("insert into employee_details(name,designation,experience)values('"+name+"','"+designation+"','"+experience+"')");
            con.close();
            System.out.println("insert completed");
//            ResultSet rs=stmt.executeQuery("select * from emp");
//            while(rs.next())
//                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
