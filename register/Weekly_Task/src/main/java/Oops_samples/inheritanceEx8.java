package Oops_samples;

class parentcons1{
    // default 0-arg constructor Empty implementation
    parentcons1(){
        System.out.println("parent class constructor ..");
    }
}

public class inheritanceEx8 extends parentcons1{
    inheritanceEx8(){
        super();
    }

    public static void main(String[] args) {
        new inheritanceEx8();
    }

}
