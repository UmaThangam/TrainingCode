package Oops_samples;

public class Polimorphism_ex1 {
    void call(int a){
        this.call(25,54);
        System.out.println("one argument method :"+a);
    }
    void call(int a, int b){
        System.out.println("two arguments method :"+a+" "+b);
    }
    public static void main(String args[]){
        Polimorphism_ex1 polimorphism_ex1=new Polimorphism_ex1();
        polimorphism_ex1.call(5);
    }
}
