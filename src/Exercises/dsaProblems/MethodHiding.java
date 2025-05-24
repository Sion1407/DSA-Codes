package Exercises.dsaProblems;

    class Complex extends Hello{
//        static Hello h = new Hello();
        public static void f1()
        {
            Hello.lokesh = 1;
            System.out.println(
                    "f1 method of the Complex class is executed.");
        }

//        public static void main(String[] args) {
//            h.lokesh
//        }
    }

    // class child extend Demo class
    class Sample extends Complex{
        public static void f1()
        {
            System.out.println(
                    "f1 of the Sample class is executed.");
        }
    }
    class Hello {
        public static int lokesh = 0;
    }
public class MethodHiding {
    public int lokesh = 0;
        public static void main(String args[])
        {
            Complex d1 = new Complex();

            // d2 is reference variable of class Demo that
            // points to object of class Sample
            Complex d2 = new Sample();

            // But here method will be call using type of
            // reference
            d1.f1();
            d2.f1();
        }

}
