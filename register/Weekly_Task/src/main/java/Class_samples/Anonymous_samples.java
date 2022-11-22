package Class_samples;

abstract class Person{
    abstract void eat();
}
public class Anonymous_samples {
    public static void main(String args[]) {
        Person person = new Person() {
            @Override
            void eat() {
                System.out.println("person eat");
            }
        };
        person.eat();
    }
}
