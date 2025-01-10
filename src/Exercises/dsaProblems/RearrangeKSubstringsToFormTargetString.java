package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RearrangeKSubstringsToFormTargetString {
    public static void main(String[] args) {
        System.out.println(isPossibleToRearrange("aabbcc","bbaacc",2));
    }

    public static boolean isPossibleToRearrange(String s, String t, int k) {
        Map<String,Integer> div = new HashMap<>();
        Map<String,Integer> divt= new HashMap<>();
        int j = 0,divideAt = s.length()/k;

        for (int i = 0; i < k; i++) {
            String subStr = s.substring(j,j+divideAt);
            div.put(subStr,div.getOrDefault(subStr,0)+1);
            j = j+divideAt;
        }
        j=0;
        for (int i = 0; i < k; i++) {
            String subStr = t.substring(j,j+divideAt);
            divt.put(subStr,divt.getOrDefault(subStr,0)+1);
            j = j+divideAt;
        }

        if (divt.equals(div))
            return true;
        return false;
    }
}
