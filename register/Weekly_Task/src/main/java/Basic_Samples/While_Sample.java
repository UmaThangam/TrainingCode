package Basic_Samples;

import java.util.Scanner;
public class While_Sample {
    public static void main(String args[]) {
        System.out.print("Enter number ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        while (number>=0){
            System.out.println(number);
            number--;
        }
    }
}
