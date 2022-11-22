package Oops_samples;

    class phone {
        void unlock(String pattern){
            System.out.println("parrent class method "+pattern);
        }
    }
    class Polirmorphism_ex2 extends phone{
//        void unlock(String pattern){
//            super.unlock("nimi");
//            System.out.println("child class method "+pattern);
//        }
        public static void main(String args[]){
            Polirmorphism_ex2 polimorphism_ex2=new Polirmorphism_ex2();
            polimorphism_ex2.unlock("uma");
        }
}

