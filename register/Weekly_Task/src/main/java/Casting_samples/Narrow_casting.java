package Casting_samples;

public class Narrow_casting {
    public static void main(String[] args) {
        double myDouble = 9.78d;
        int myInt = (int) myDouble; // Manual casting: double to int
        System.out.println(myDouble);   // Outputs 9.78
        System.out.println(myInt);      // Outputs 9

        double d = 166.66;
        long l = (long)d;
        int i = (int)l;
        System.out.println("Before conversion: "+d);
        System.out.println("After conversion into long type: "+l);
        System.out.println("After conversion into int type: "+i);
    }
}
