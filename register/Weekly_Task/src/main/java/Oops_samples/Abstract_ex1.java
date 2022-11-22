package Oops_samples;

abstract class phone1 {
    void unlock(int age){ //method define
        System.out.println("parrent class method "+age);
    }
    abstract void display(String name); //method declared
}
public class  Abstract_ex1 extends phone1 {
    void display(String name){
        super.unlock(23);
        System.out.println("this is from abstract method "+name);
    }
    public static void main(String args[]){
        Abstract_ex1 abstract_ex1=new Abstract_ex1();
        abstract_ex1.display("cbg");
    }
}
