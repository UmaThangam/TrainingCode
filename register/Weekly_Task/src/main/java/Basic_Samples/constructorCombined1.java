package Basic_Samples;

public class constructorCombined1 {
    constructorCombined1(){
        System.out.println("------ constructor--------");
        instanceMethod();
        //staticMethod();
    }
    void instanceMethod() {
        staticMethod();
        System.out.println("-------Instance Method---------");
    }
    static void staticMethod() {
        System.out.println("------- Static Method---------");
    }
    public static void main(String[] args) {
        constructorCombined1 cc1 = new constructorCombined1();
        //staticMethod();
    }
}
