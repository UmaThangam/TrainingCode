package Basic_Samples;

import java.util.Scanner;

public class Dowhile_Sample {
    public static void main(String args[]) {
        System.out.print("Enter number ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        do {
            System.out.println(number);
            number++;
        }
        while (number<=5);
    }
}
