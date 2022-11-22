package DB_samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/*
executequery _ select
executeupdate _update,insert,delete
 */
public class DB_ex1 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String name,designation;
        int experience;
        try {
            System.out.println("Enter employee Name");
            name=s.next();
            System.out.println("Enter The employee designation");
            designation=s.next();
            System.out.println("Enter The employee employee_experience");
            experience=s.nextInt();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","Chargeback@123");
            PreparedStatement preparedStatement=con.prepareStatement("insert into employee_details (name,designation,experience)values(?,?,?)");
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,designation);
            preparedStatement.setInt(3,experience);
            preparedStatement.executeUpdate();
            System.out.println("Data Saved....");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Data Not Saved.....");
        }
    }
}
