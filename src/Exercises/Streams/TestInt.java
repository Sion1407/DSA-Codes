package Exercises.Streams;

public interface TestInt extends Runnable{
    static void test() {
        System.out.println("static");
    }
    default void test2(){
        System.out.println("def");
    }
}
