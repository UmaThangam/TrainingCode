package List_samples;

import java.util.Comparator;

public class City_Sort implements Comparator <City_pojo> {
    @Override
    public int compare(City_pojo o1, City_pojo o2) {
        if(o1.getPeople_count()>o2.getPeople_count()){
            return 1;
        }
        else if(o1.getPeople_count()<o2.getPeople_count()){
            return -1;
        }
        else
            return 0;
    }
}
