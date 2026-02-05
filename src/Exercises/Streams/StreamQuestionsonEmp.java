package Exercises.Streams;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamQuestionsonEmp {
    public static void main(String[] args) {
        List<Emp> ls = Arrays.asList(new Emp(1,"Sion",Arrays.asList(123456789L),24,"IT",12000.0),
                new Emp(2,"Adi",Arrays.asList(123456789L),24,"Factory",11000.0));
//        firstname and dept name
        List<String> md = ls.stream().map(emp-> emp.getName() +"||"+emp.getDept()).toList();
        System.out.println(md);

//        second highest sal
        Double sndHS = ls.stream().map(e->e.getSal()).sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(sndHS);

//        dept name with cnt of each dept
        Map<String,Long> dncnt = ls.stream().collect(Collectors.groupingBy(Emp::getDept,Collectors.counting()));
        System.out.println(dncnt);

        Predicate<Integer> p = x -> x>5;

//        print the second Highest number – use sorted, skip, findFirst
        Optional<Integer> s = List.of(1,5,-50,500,3,4,532).stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println(s.get());

//        print sum of all integers starts with 5.
        Predicate<Integer> startsWith5 = n -> String.valueOf(n).startsWith("5");
        Integer sum = List.of(1,5,-50,500,3,4,532).stream().filter(startsWith5).mapToInt(a->a).sum();
        System.out.println(sum);

        Map<Integer,Long> hm = List.of(1,5,-50,500,3,4,532,500).stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(hm);
    }
}
