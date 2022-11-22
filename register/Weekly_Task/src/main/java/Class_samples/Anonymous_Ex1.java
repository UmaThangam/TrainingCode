package Class_samples;

interface  Person2{
     void eat();
     void add();
}
public class Anonymous_Ex1 {
    public static void main(String args[]) {
        Person2 person = new Person2() {
            @Override
            public void eat() {
                System.out.println("person eat");
            }
            @Override
            public void add() {
                System.out.println("person add");
            }
        };
        person.eat();
        person.add();
    }
}
