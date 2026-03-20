package DesignPattern;

import java.util.Arrays;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
//        List<?> is READ-ONLY (almost)
        List<Integer> genList = Arrays.asList(1,2,3,4);
        List<String> genList2 = Arrays.asList("1","2","3","4");
        method(genList2);method(genList);
    }

    private static void method(List<?> lst){
        //wildcard
        for (Object obj: lst){
            System.out.println(obj.getClass());
        }
    }


}
