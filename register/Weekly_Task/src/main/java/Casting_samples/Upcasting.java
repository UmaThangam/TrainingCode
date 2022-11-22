package Casting_samples;

/*
Upcasting is a type of object typecasting in which a child object is typecasted to a parent class object
 */
class  Parent{
    void PrintData() {
        System.out.println("method of parent class");
    }
}
class Child extends Parent {
    void PrintData() {
        System.out.println("method of child class");
    }
}
public class Upcasting {
    public static void main(String args[]) {
        Parent obj1 = (Parent) new Child();
        Parent obj2 = (Parent) new Child();
        obj1.PrintData();
        obj2.PrintData();
    }

}
