package Exercises.dsaProblems;

import java.util.Arrays;

class Parent{
    void say(String... a){
        System.out.println("Parent says: "+ Arrays.toString(a));
    }
}

class Child extends Parent{
    void say(String a){
        System.out.println("child says: "+ a);
    }
}
public class UpCastingAndDownCasting {
    public static void main(String[] args) {
//        upstream
        Parent p = new Child();
        p.say("hola");

//        downstream
        Parent p1 = new Parent();
        Child c = (Child) p;
        c.say("hola");
    }
}
