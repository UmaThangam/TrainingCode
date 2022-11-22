package Set_samples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class Hashsetexe1 {
    public static <Int> void main(String args[]) {
        HashSet<Integer> mark = new HashSet<>();
        mark.add(471);
        mark.add(340);
        mark.add(260);
        mark.add(340);//duplicates will not be added.
        mark.add(380);
        mark.remove(260);//remove
        System.out.println("Set iterate using for loop --");
        for(int itr:mark){
            System.out.println(itr);
        }
        System.out.println("-- To store set to array---");
        ArrayList<Integer> itr=new ArrayList<>(mark);
        System.out.println(itr.get(0));
        Collections.sort(itr);
        System.out.println(itr);
        System.out.println("set itetator using inerator  ....");
        Iterator<Integer> itr2= mark.iterator();
        while(itr2.hasNext()){
            System.out.println(itr2.next());
        }
    }
}
