package Oops_samples;

    interface call{
        void call();
    interface Message{
        void msg();
    }
    }
class Nested_interface implements call.Message{
    public void msg()
        {
        System.out.println("Hello nested interface");
        }
        public void call(){
            System.out.println("hi");
        }
    public static void main(String args[]){
        call.Message message=new Nested_interface();//upcasting here
        message.msg();
    }
}
