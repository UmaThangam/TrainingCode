package Map_samples;

import java.util.Iterator;
import java.util.TreeMap;

public class Treemap_withpojo {
    public static void main(String args[]) {
        TreeMap<String, hashmap_pojo> obj = new TreeMap<String, hashmap_pojo>();
        hashmap_pojo hashmap_pojo=new hashmap_pojo();
        hashmap_pojo.setEmp_id(145);
        hashmap_pojo.setEmp_name("uff");
        hashmap_pojo hashmap_pojo2=new hashmap_pojo();
        hashmap_pojo2.setEmp_id(15);
        hashmap_pojo2.setEmp_name("mbn");
        hashmap_pojo hashmap_pojo3=new hashmap_pojo();
        hashmap_pojo3.setEmp_id(150);
        hashmap_pojo3.setEmp_name("lbn");
        obj.put("key3",hashmap_pojo3);
        obj.put("key2",hashmap_pojo2);
        obj.put("key1",hashmap_pojo);
        Iterator itr = obj.values().iterator();
        while (itr.hasNext()) {
            hashmap_pojo itr2= (Map_samples.hashmap_pojo) itr.next();
            System.out.println(itr2.getEmp_id()+" "+itr2.getEmp_name());
        }
        System.out.println("using forloop the keys are .....");
        for (String tmp : obj.keySet()) {// access value only using forloop
            System.out.println(tmp);
        }
        //System.out.println(obj.size());
    }
}
