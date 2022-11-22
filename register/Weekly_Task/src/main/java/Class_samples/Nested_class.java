package Class_samples;

class Outer_Demo {
    int num;
    void display_Inner() {
        Inner_Demo inner = new Inner_Demo();
        inner.print();
    }
    private class Inner_Demo {
        public void print() {
            System.out.println("This is an inner class");
        }
    }
 }
public class Nested_class {
    public static void main(String args[]) {
        Outer_Demo outer = new Outer_Demo();
        outer.display_Inner();
    }
}
