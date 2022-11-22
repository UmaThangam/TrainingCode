package List_samples;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayInteger {
    public static  void main(String args[]) {
        ArrayList<Integer> obj = new ArrayList<>();
        obj.add(23);
//        obj.add(12);
//        obj.add(02);
//        obj.add(67);
//        obj.add(45);
        int start=1,end=3;
        if(start==end){
            end=start+1;
        }
        else{
            start=start;
            end=end;
        }
        System.out.println(obj.subList(start,end));
        System.out.println("empty");
//        System.out.println("Size of arraylist1:" + obj.size());
//        System.out.println("Arraylist1 values are :" + obj);
//        System.out.println("a specific value present : " + obj.contains(02));
//        System.out.println("index position :" + obj.indexOf(67));
//        // System.out.println("Array values are :"+obj);
//         Collections.sort(obj); // it is used to sort arraylist in directly
//        System.out.println(obj);
//        System.out.println("two arraylist size :" + obj.size());
    }
}
