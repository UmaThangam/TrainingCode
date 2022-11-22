package Exception_samples;

public class Throw_exe {
    public void division() throws ArithmeticException  {
        int a = 4, b = 0;
        try {
            int c = a / b;
            System.out.println("division block execute :" + c);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void Empnull() throws Exception {
        String name = " ";
        try {
           String re_name= name.toString();
            System.err.println("null block execute :" +re_name);
        } catch (Exception e) {
           System.out.println(e);
           // e.printStackTrace();
            throw new Exception(e);
        }
    }
    public void Array_index() throws Exception {
        int a[] = {5, 7, 3, 4};
        try {
            System.out.println("Array block execute :" + a[5]);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
    public static void main(String args[]) throws Exception {
        Throw_exe obj=new Throw_exe();
        obj.division();
        obj.Empnull();
        obj.Array_index();
    }
}
