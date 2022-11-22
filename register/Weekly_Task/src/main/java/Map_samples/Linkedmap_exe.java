package Map_samples;
import java.util.Iterator;
import java.util.LinkedHashMap;
public class Linkedmap_exe {
    public static void main(String args[]) {
        LinkedHashMap<String, String> obj = new LinkedHashMap<String, String>();
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
        //creation one more object
        LinkedHashMap<String, String> obj2 = new LinkedHashMap<String, String>();
        obj2.put("nimi","Cloub");
        obj2.put("uma","cbg");
        System.out.println("the second linkedhashmap is :"+obj);
        System.out.println("Adding of two linkedhash map");
        obj.putAll(obj2);
        System.out.println(obj);
        //Linkedhasp_exe =obj.get(0);
        System.out.println(obj.size());
    }
}
