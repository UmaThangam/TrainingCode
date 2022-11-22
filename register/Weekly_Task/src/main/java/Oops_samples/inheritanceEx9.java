package Oops_samples;

class parentcons2{ // object class
    parentcons2(int a){
        //super(); executed by compiler object class constructor executed .the object class constructor is empty
        System.out.println("Parent 1-arg constructor = "+a);
    }
}
public class inheritanceEx9 extends parentcons2{
    inheritanceEx9(){
        super(8);
        System.out.println("Child 0-arg constructor");
    }
    public static void main(String[] args) {
        new inheritanceEx9();
    }
}

