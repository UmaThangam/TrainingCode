package Thread_samples;

public class Thread_ex1 extends Thread {
    public void run(){
        System.out.println("Run method called...");
        System.out.println("thread name is .."+Thread.currentThread().getName());
    }
    public static void main(String args[]){
        Thread_ex1 thread=new Thread_ex1();
        System.out.println(Thread.currentThread().getName());
        thread.start(); //thread are created
        //thread.run();//print same output.but thread not create
    }
}
