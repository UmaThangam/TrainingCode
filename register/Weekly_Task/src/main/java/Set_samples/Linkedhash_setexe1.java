package Set_samples;

/*
    set avoid duplicate element
    Linked set maintain insertion order
 */
import java.util.LinkedHashSet;

public class Linkedhash_setexe1 {
    public static void main(String args[]) {
        LinkedHashSet<String> obj = new LinkedHashSet<>();
        obj.add("CBG");
        obj.add("HCL");
        obj.add("BST");
        obj.add("TCS");//duplicates will not be added.
        obj.add("IVTL");
        obj.add("INFOSYS");
//        ArrayList<Integer> list=new ArrayList<Integer>(obj);
//        System.out.println(obj.get(0));
        System.out.println("size of the LinkedHashSet "+obj.size());
        System.out.println(obj.contains("CBG"));//check the value present in list
       System.out.println("--Set value are : ---");
       for(String itr:obj){
            System.out.println(itr);
      }
        obj.remove("BST");//remove
        System.out.println(obj.contains("BST"));//check bts is present in list  or not
    }
}
