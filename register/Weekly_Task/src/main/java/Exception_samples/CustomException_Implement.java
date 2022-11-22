package Exception_samples;

public class CustomException_Implement {
    public void checkAge(int age) throws Custom_Exeception {
        if(age >10){
            throw new Custom_Exeception("Age is greater than 10");
        }else{
            System.out.println("ok..");
        }
    }
    public static void main(String args[]) {
        CustomException_Implement obj =new CustomException_Implement();
    }
}
