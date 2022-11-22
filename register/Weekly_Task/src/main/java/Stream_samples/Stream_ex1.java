package Stream_samples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream_ex1 {
    public static void display(){
        ArrayList<People_pojo> people_pojo=new ArrayList<>();
        people_pojo.add(new People_pojo("chennai",3000));
        people_pojo.add(new People_pojo("namakkal",6000));
        people_pojo.add(new People_pojo("salem",9000));
        people_pojo.add(new People_pojo("erode",7000));
        List<People_pojo> list=people_pojo.stream().filter(conut->conut.getCount()>6000).collect(Collectors.toList());
        for(People_pojo itr:list)
        {
            System.out.println(itr.getCount()+" "+itr.getName());
        }
    }
    public static void main(String args[]){
       // display();
        Stream_ex1.display(); //call with class name
    }
}
