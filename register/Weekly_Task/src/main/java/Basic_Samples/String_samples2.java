package Basic_Samples;

public class String_samples2 {
    public  void main(String args[]){
        StringBuffer course1=new StringBuffer("welcome java program ");
        StringBuffer course2=new StringBuffer("welcome php program ");
        StringBuilder obj=new StringBuilder("buffered class ");
        System.out.println(course1.append("class"));
        System.out.println(course2);
        System.out.println(obj);
        System.out.println(course1.capacity());
    }
}
