package Basic_Samples;

public class methodsEx1 {
    int k = 100;
    static int m = 1000;
    void add() { // instance method
        int i = 10;
        System.out.println("Instance Method");
        System.out.println("Instance Method Local Variable = "+i);
        System.out.println("Instance Method Instance Variable = "+k);
        methodsEx1 mEx11 = new methodsEx1();
        System.out.println("Instance Method Static Variable Direct = "+m);
        System.out.println("Instance Method Static Variable Object = "+mEx11.m);
        System.out.println("Instance Method Static Variable Class Name = "+methodsEx1.m);
    }
    static void multiply() { //static method
        int j = 100;
        System.out.println("Static Method Local Variable = "+j);
        methodsEx1 mEx1 = new methodsEx1();
        System.out.println("Static Method Instance Variable = "+mEx1.k);
        System.out.println("Static Method Static Variable Direct = "+m);
        System.out.println("Static Method Static Variable Object = "+mEx1.m);
        System.out.println("Static Method Static Variable Class Name = "+methodsEx1.m);
    }
    public static void main(String[] args) {     //// JVM
        String name="vdg";
        StringBuffer obj=new StringBuffer("blacky");
        System.out.println(obj.append("uma"));

        System.out.println("WELCOME");
        methodsEx1 mEx1 = new methodsEx1();
        mEx1.add();
        multiply();
        mEx1.multiply();
        methodsEx1.multiply();
    }
    String s1="uma";
    String s2="uma";
    String s=new String("uma");
}
