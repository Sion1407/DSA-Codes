package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.List;

public class StringPermutatoins {
    static List<String> res = new ArrayList<>();
    public static void main(String[] args) {
        String s = "ABC";
        StringBuilder sb = new StringBuilder(s);
        perm(sb,0);
        System.out.println(res);
    }

    private static void perm(StringBuilder s,int i){
        if (i==s.length()){
            res.add(s.toString());
        }
        for (int j = i; j < s.length(); j++) {
            char t = s.charAt(j);
            s.setCharAt(j, s.charAt(i));
            s.setCharAt(i,t);

            perm(s,i+1);

            t = s.charAt(j);
            s.setCharAt(j, s.charAt(i));
            s.setCharAt(i,t);
        }
    }

}
