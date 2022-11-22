package Array_Samples;

import java.util.Arrays;

public class Array_String {
    public void add(String [] arr){
        String [] array=arr; //pass the arr argument to array
        Arrays.sort(array,new Arraystirng_sort());
        for(int i=0; i< array.length;i++){
            System.out.println(array[i]);
        }
    }
}
