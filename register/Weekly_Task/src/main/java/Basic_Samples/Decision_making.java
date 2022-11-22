package Basic_Samples;

import java.util.Scanner;

public class Decision_making {
    public static void main(String args[]){
        // int mark2=0;
        System.out.print("Enter mark ");
        Scanner sc=new Scanner(System.in);
        int mark=sc.nextInt();
        if(mark<35)
            System.out.print("Your Are Fail");
        else if(mark>35 && mark<90)
            System.out.print("B Grade");
        else if (mark==100)
            System.out.print("A Grade");
        else
            System.out.print("Invalid Number");
    }
}
