package Thread_samples;

public class Synchronization {
    public static void main(String args[]){
        parent parent_obj=new parent();
       thread1 obj1=new thread1(parent_obj);
       thread2 obj2=new thread2(parent_obj);
        obj1.start();
        obj2.start();
    }
}
class parent{
    synchronized void display(int n){
        for(int i=0;i<=5;i++)
        {
            System.out.println(i*n);
            try{
                Thread.sleep(2000);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
class thread1 extends Thread{
    parent n;
    thread1(parent n){
      this.n=n;
    }
    public void run(){
        n.display(5);
    }
}
class thread2 extends Thread{
    parent n;
    thread2(parent n){
        this.n=n;
    }
    public void run(){
        n.display(50);
    }
}