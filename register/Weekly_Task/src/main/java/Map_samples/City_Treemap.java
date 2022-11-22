package Map_samples;

import java.util.Map;
import java.util.TreeMap;

public class City_Treemap {
    public static void main(String args[]) {
        Map<String, City_pojo> map = new TreeMap<String, City_pojo>();
        City_pojo city_pojo1 = new City_pojo();
        city_pojo1.setName("uma");
        city_pojo1.setPeople_count(2);

        City_pojo city_pojo2 = new City_pojo();
        city_pojo2.setName("akila");
        city_pojo2.setPeople_count(6);
        map.put("key1", city_pojo1);
        map.put("key2",city_pojo2);

        for (Map.Entry<String, City_pojo> entry : map.entrySet()) {
            //String key = entry.getKey();
            City_pojo b = entry.getValue();
            System.out.println(b.name + " " + b.people_count);
        }
    }
  }
