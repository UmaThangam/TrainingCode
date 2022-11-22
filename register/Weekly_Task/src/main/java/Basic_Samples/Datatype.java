package Basic_Samples;
/*
primitive data type - int,fload,double,short,long,char,bloolean
 */
public class Datatype {
    int age=12;  //instance varaible
    static int id=101;
    void display(){ //instance method
        Datatype object=new Datatype();
        System.out.println("Instance method ....");
        String name="cbg";
        System.out.println(name);
        System.out.println(age);
        System.out.println(id);
        System.out.println(Datatype.id);
        System.out.println(object.id);
        System.out.println(".............");
    }
    String add(){ //method with return type
        System.out.println("method with retrun type ...");
        float pf=34.56f;
        System.out.println(pf);
        System.out.println(age);
        System.out.println(id);
        System.out.println("...............");
        return "retrun from method";
    }
    static void printdata(char d){ //static method
        Datatype object=new Datatype();
        System.out.println("static method ....");
        System.out.println(d);
        System.out.println(object.age);
        System.out.println(id);
        System.out.println(Datatype.id);
        System.out.println(object.id);
        System.out.println(".............");
    }
  public static void main(String args[])  {
        Datatype datatype=new Datatype();
        datatype.display();
      String result=datatype.add();
        printdata('C');
      System.out.println(result);

  }
}
