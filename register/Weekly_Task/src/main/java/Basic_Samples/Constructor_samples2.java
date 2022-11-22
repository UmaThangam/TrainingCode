package Basic_Samples;

public class Constructor_samples2 {
    int empid;
    String name;
    float salary;

    void disp() {
        System.out.println(empid);
        System.out.println(name);
        System.out.println(salary);
    }

    Constructor_samples2(){
        empid = 1;
        name = "aaa";
        salary = 100000f;
    }

//    Constructor_samples2(Constructor_samples2 c){ //construcot with arguments
// 		c.empid = 2;
// 		c.name = "bbb";
// 		c.salary = 200000f;
//       }

    public static void main(String[] args) {
        Constructor_samples2 cEx4 = new Constructor_samples2();
//		cEx4.disp();
//		constructorEx4 cEx41 = new constructorEx4(cEx4);
        cEx4.disp();
    }
}
