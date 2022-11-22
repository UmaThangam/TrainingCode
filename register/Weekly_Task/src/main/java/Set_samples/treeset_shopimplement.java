package Set_samples;

import java.util.Iterator;
import java.util.TreeSet;

public class treeset_shopimplement {
    public static void main(String args[]) {
        TreeSet<treeset_shoppojo> obj = new TreeSet<>();

        treeset_shoppojo pen = new treeset_shoppojo();
        pen.setproduct_name("stylish");
        pen.setCount(100);

        treeset_shoppojo note = new treeset_shoppojo();
        note.setproduct_name("unroled");
        note.setCount(76);
        /*
        Syntax for iterator
        Iterator <pojo classname> newobj=set_objname.iterator
         */
        Iterator<treeset_shoppojo> itr =obj.iterator();
        while(itr.hasNext()){
            treeset_shoppojo o = itr.next();//this line for getting perticular value in a setlist
            System.out.println(o.getproduct_name()+" "+o.getCount());
        }
    }
}


   // Person personZero = list1.get(0);
       // System.out.println("0th index "+personZero.getAge()+" "+personZero.getName()+" -- "+personZero.getPhoneNo());