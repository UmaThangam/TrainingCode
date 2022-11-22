package Thread_samples;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization_demo {
    public void serialization() {
        try{
            //Creating the object
            demo_pojo s1 =new demo_pojo(211,"uma");
            //Creating stream and writing the object
            FileOutputStream fout=new FileOutputStream("d.txt");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(s1);
            out.flush();
            //closing the stream
            out.close();
            System.out.println("success");
        }catch(Exception e){
            System.out.println(e);}
    }
    public void deserialization(){
        try{
            //Creating stream to read the object
            FileInputStream in=new FileInputStream("d.txt");
            ObjectInputStream input=new ObjectInputStream(in);
            demo_pojo s=(demo_pojo)input.readObject();
            //printing the data of the serialized object
            System.out.println(s.id+" "+s.name);
            //closing the stream
            in.close();
        }catch(Exception e){System.out.println(e);}
    }
    public static void main(String args[]) {
        Serialization_demo obj=new Serialization_demo();
        obj.serialization();
        obj.deserialization();
    }
}



