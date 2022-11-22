package Thread_samples;

public class Threadmulti_class extends Thread {
    public void run(){
        for(int i=0;i<=5;i++)
        {
            System.out.println(i);
            try{
                Thread.sleep(2000);
            }catch (Exception e){
                System.out.println(e);
            }
        }
        System.out.println("thread class run method was called..");
    }
    public Threadmulti_class(){
        System.out.println("constructor method called..");
    }
//    public Threadmulti_class(String name){
//        super(name);
//        System.out.println("1 args constructor...");
//        //how to access the method
//    }
    public static void main(String args[]){
        Threadmulti_class thread=new Threadmulti_class();
        thread.start();
        //thread.interrupt();
        Threadmulti_class thread2=new Threadmulti_class();
        thread2.start();
    }
}
