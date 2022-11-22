package List_samples;

import java.util.ArrayList;
import java.util.Collections;

public class Arraylist_child1pojo {
    public static void main(String args[]) {
        ArrayList <Arraylist_parentpojo> list1=new ArrayList<Arraylist_parentpojo>();
        Arraylist_parentpojo obj1=new Arraylist_parentpojo();
        obj1.setEmp_id(102);
        obj1.setName("Akila");
        obj1.setSalary(25000);
        list1.add(obj1); //adding the obj to array list
        System.out.println(obj1.getEmp_id()+" "+obj1.getName()+" "+obj1.getSalary());
        Arraylist_parentpojo listzero = list1.get(0);//access specific indix in specific value
        System.out.println(listzero.getEmp_id());
        //adding 2nd object in array list
        Arraylist_parentpojo obj2=new Arraylist_parentpojo();
        obj2.setEmp_id(99);
        obj2.setName("uma");
        obj2.setSalary(50000);
        System.out.println(obj2.getEmp_id()+" "+obj2.getName()+" "+obj2.getSalary());
        list1.add(obj2);
        Arraylist_parentpojo listone=list1.get(0); // getting singe object from multiple object in list
        System.out.println(listone.getName()+" "+listone.getSalary());

        for(Arraylist_parentpojo itr:list1){// iterating the all object with all field
            System.out.println(itr.getEmp_id()+" "+itr.getSalary()+" "+itr.getName());
        }
    }
}
