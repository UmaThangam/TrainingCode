package Exception_samples;

public class Try_exe {
    public void display() {
        try {
            int arr[]={3,5,6,7};
            System.out.println("try block execute :"+arr[5]);
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            System.out.println("finally will always execute");
        }
    }
    public static void main(String args[]) {
        Try_exe obj=new Try_exe();
        obj.display();

    }
}
