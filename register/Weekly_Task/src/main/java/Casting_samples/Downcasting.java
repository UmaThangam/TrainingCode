package Casting_samples;

class Parent1 {
    String name;
    void showMessage()
    {
        System.out.println("Parent method is called");
    }
}
class Child1 extends Parent1 {
    int age;
    @Override
    void showMessage()
    {
        System.out.println("Child method is called");
    }
}
public class Downcasting {
    public static void main(String[] args)
    {
        Parent1 p = new Child1();
        p.name = "Shubham";
        Child1 c = (Child1)p;
        c.age = 18;
        System.out.println(c.name);
        System.out.println(c.age);
        c.showMessage();
    }
}
