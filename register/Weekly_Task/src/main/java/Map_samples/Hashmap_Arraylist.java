package Map_samples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Hashmap_Arraylist {
    public static void main(String args[]){
        HashMap<String, ArrayList<String>> hmap=new HashMap<>();
        //creating first object
        ArrayList<String> obj1=new ArrayList<>();
        obj1.add("html");
        obj1.add("css");
        obj1.add("js");
        //creating second object
        ArrayList<String> obj2=new ArrayList<>();
        obj2.add("java");
        obj2.add("python");
        obj2.add("php");
        //adding arraylist values into hashmap
        hmap.put("key1",obj1);
        hmap.put("key2",obj2);
        System.out.println("hashmap values are ..."+hmap);
        //iterating the hashmap value
        System.out.println("iterating values only ...");
        Iterator itr=hmap.values().iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println("for loop for accessing key only ...");
        for (String str :hmap.keySet())
        {
            System.out.println(str+" "+hmap.get(str));
        }
        for(ArrayList<String> tmp:hmap.values()) {//map iteration
            for (String tmpList : tmp) {//map's arraylist iteration.
                System.out.println(tmpList);
            }
        }
        //access for key and values
        for (String str :hmap.keySet())//hash map forloop
        {
            for (String tmpList : hmap.get(str)) {//map's arraylist iteration.
                System.out.println(str+" "+tmpList);
            }
            //System.out.println(str+" "+hmap.get(str));
        }
    }
}
