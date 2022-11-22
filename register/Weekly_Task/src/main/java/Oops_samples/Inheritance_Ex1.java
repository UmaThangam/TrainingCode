package Oops_samples;

public class Inheritance_Ex1 {
    void print(){ // method(4)
        this.display();
        System.out.println("parent class method");
    }
    public Inheritance_Ex1(){ // constructor block (2)
        System.out.println("parent class constructor");
    }
    static{ // static block (1)
        System.out.println("static block 1");
    }
    void display(){  //intance block (3)
        System.out.println("instance block");
    }
}
