package Basic_Samples;

import java.sql.SQLOutput;

public class String_samples {
    public static void main(String []args){
        String s1 = "person1";
        String s2 = "person1";
        String s3 = new String ("person1");
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s3));
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s1);
        String basic="this is java program";
        System.out.println(basic.substring(4));
        System.out.println(basic.substring(0,4));
        System.out.println(basic.toUpperCase());

    }
}
