package Oops_samples;

public class AA {
    int a=5,b=10;
        void method1(){
            System.out.println("classs A - method1");
        }
        void method2(){
            System.out.println("classs A - method2");
        }
    }

    class BB extends AA{
        void method3(){
            System.out.println("classs B - method3");
        }
        void method4(){
            System.out.println("classs B - method4");
        }

    }
    class CC extends BB{

        void method5(){
            System.out.println("classs C - method5");
        }
        void method6(){
            System.out.println("classs C - method6");
        }
    }



