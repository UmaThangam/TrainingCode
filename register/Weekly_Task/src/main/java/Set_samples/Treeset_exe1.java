package Set_samples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class Treeset_exe1 {
    public static void main(String args[]){
        TreeSet<String> set=new TreeSet<>();
        set.add("car");
        set.add("bike");
        set.add("car");//can't allow dublicate value
        set.add("bus");
        ArrayList<String> list=new ArrayList<String>(set); // for accessing specific values
        System.out.println(list.get(0));
        System.out.println("size of the tree 1set is :"+set.size());
        System.out.println("first element is :"+set.first());
        set.remove("bike");

    //creating a second set
        TreeSet<String> set2=new TreeSet<>();//syntax for treeset
        set2.add("Druck");
        set2.add("cycle");
        set2.add("bike");//
        set2.add("train");
        set.addAll(set2);//adding a two set
        Iterator<String> itr = set2.iterator();//we can't access specific value in set.for iterate value we need to use Iterator
        System.out.println("added two treeset the valuea are :");
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
