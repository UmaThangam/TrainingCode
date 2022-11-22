package Array_Samples;

import java.util.Arrays;

public class Array_sort {
    public static void main(String args[]){
        String [] array=new String[6];
        array[0]="g";
        array[1]="i";
        array[2]="a";
        array[3]="e";
        array[4]="h";
        array[5]="b";
       // System.out.println(array[2]); //get one element from array
        //Arrays.sort(array,new demo_sort());
        Arrays.sort(array);
        for(int i=0; i< array.length;i++){
            System.out.println(array[i]);
        }
    }
}
