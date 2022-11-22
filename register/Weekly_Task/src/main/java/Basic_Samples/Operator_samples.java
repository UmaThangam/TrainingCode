package Basic_Samples;

public class Operator_samples {
    int a=10, b=20;
    public void arithmetic(){
        System.out.println("arithmethic operator ...");
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.println(a%b);
        System.out.println("...........");
    }
    public void assignment(){
        System.out.println("assignment operator ...");
        System.out.println(a+=5);
        System.out.println(b-=13);
        System.out.println(a*=5);
        System.out.println(b/=5);
        System.out.println(a%=5);
        System.out.println("...........");
    }
    public void relation(int d){
        this.logic();
        System.out.println("relational operator .....");
        System.out.println(a==b);
        System.out.println(d!=a);
        System.out.println(a<b);
        System.out.println(d>b);
        System.out.println(a>=d);
        System.out.println(b<=a);
        System.out.println("..............");
    }
    public void logic(){
        System.out.println("logical operator ...");
        int c=7;
        System.out.println(a<b && a>c);
        System.out.println(b>a || c>b);
        System.out.println("........");
    }
    public static void main(String args[]){
        Operator_samples operator_samples=new Operator_samples();
        operator_samples.arithmetic();
        operator_samples.assignment();
        operator_samples.relation(7);
    }
}
