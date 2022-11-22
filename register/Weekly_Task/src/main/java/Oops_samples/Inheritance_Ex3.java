package Oops_samples;

public class Inheritance_Ex3 extends CC {
    public static void main(String[] args) {
        AA A1 = new AA();
        BB B1 = new BB();
        CC C1 = new CC();
        //calling aa class method
        A1.method1();
        A1.method2();
        // calling aa and bb class method
        B1.method1();
        B1.method2();
        B1.method3();
        B1.method4();
        //calling aa and bb and cc class method
        C1.method1();
        C1.method2();
        C1.method3();
        C1.method4();
        C1.method5();
        C1.method6();
    }


}
