package Oops_samples;

interface  rectangel{
    void area(int a,int b);
}
interface circule{
    void radius(double r);
}
public class Interface_ex1 implements rectangel,circule{

    @Override
    public void area(int a, int b) {
        this.radius(6);
        int result=(a*b);
        System.out.println("area of rectangular "+result);
    }
    @Override
    public void radius(double r) {
        double radius=(3.14*r*r);
        System.out.println("radius of circule "+radius);
    }
    public static void main(String args[]){
        Interface_ex1 interface_ex1=new Interface_ex1();
        interface_ex1.area(23,67);
    }
}
