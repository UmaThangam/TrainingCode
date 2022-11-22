package Map_samples;

import java.util.HashMap;
import java.util.Iterator;

public class Hashmap_implement {
    public static void main(String args[]){
        HashMap<Integer,hashmap_pojo> hashMap=new HashMap<Integer,hashmap_pojo>();
        hashmap_pojo cbg=new hashmap_pojo();
        cbg.setEmp_id(101);
        cbg.setEmp_name("akila");

        hashmap_pojo ivtl=new hashmap_pojo();
        ivtl.setEmp_id(103);
        ivtl.setEmp_name("uma");
        hashMap.put(1,cbg);
        hashMap.put(2,ivtl);
        System.out.println("hashmap values are .."+hashMap);
        System.out.println("for iterator......");
        Iterator itr=hashMap.values().iterator();
        while (itr.hasNext())
        {
            System.out.println(itr.next());
        }
        hashmap_pojo zero=hashMap.get(1);
        System.out.println(zero.getEmp_name());
    }
}
