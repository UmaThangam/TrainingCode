package Map_samples;

import java.util.Iterator;
import java.util.TreeMap;

public class Treemap_exe {
    public static void main(String args[]) {
        TreeMap<String, String> obj = new TreeMap<String, String>();
        obj.put("font_end", "html"); //key and value
        obj.put("back_end", "java");
        obj.put("database", "mysql");
        obj.put("back_end", "php");//value will overridden if key is duplicate.
        System.out.println("the first linkedhashmap is :"+obj);
        System.out.println(obj.get("back_end"));
        System.out.println("for iterator print values only .....");
        Iterator itr = obj.values().iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("using forloop the keys are .....");
        for (String tmp : obj.keySet()) {// access value only using forloop
            System.out.println(tmp);
        }
        System.out.println(obj.size());
    }
}
