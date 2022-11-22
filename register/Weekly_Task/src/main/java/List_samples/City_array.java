package List_samples;

import java.util.ArrayList;
import java.util.Collections;

public class City_array {
    public static void main(String args[]){
        ArrayList<City_pojo> list1=new ArrayList<City_pojo>();
        City_pojo city_pojo1=new City_pojo();
        city_pojo1.setName("namakkal");
        city_pojo1.setPeople_count(500);

        City_pojo city_pojo2=new City_pojo();
        city_pojo2.setName("salem");
        city_pojo2.setPeople_count(120);

        City_pojo city_pojo3=new City_pojo();
        city_pojo3.setName("chennai");
        city_pojo3.setPeople_count(1200);
        //addind all pojo object to arraylist
        list1.add(city_pojo1);
        list1.add(city_pojo2);
        list1.add(city_pojo3);
        City_pojo listzero = list1.get(1);//access specific object value from   multiple object value
        System.out.println(listzero.getName());
        // arraylist with pojo in sorting concept
        System.out.println("After Sorting id ....... : ");
        Collections.sort(list1,new City_Sort());
            for(City_pojo sp:list1){
                System.out.println(sp.getName()+" "+sp.getPeople_count());
        }
    }
}
