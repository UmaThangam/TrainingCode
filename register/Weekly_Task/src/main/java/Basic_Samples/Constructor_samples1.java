package Basic_Samples;

public class Constructor_samples1 {
    Constructor_samples1(){
        this(10);
        System.out.println("0-arg constructor");
    }

    Constructor_samples1(int a){
        this(10,20);
        System.out.println("1-arg constructor");
    }
    Constructor_samples1(int a,int b){
        System.out.println("2-arg consructor");

    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Constructor_samples1 cEx = new Constructor_samples1();
    }
}
