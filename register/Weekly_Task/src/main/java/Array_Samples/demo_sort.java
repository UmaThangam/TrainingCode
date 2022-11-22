package Array_Samples;

import java.util.Comparator;

public class demo_sort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return Integer.valueOf(o1).compareTo(Integer.valueOf(o2));
    }
}
