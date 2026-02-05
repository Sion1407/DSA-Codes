package Exercises.dsaProblems.arrays;

import java.util.*;

public class FindMaxAvg {
    public static void main(String[] args) {
        String[][] s = new String[][]{{"jerry","65"},{"bob","91"}, {"jerry","23"}, {"Eric","83"}};
//        List<int[]> to int[0]: runningSum and int[1]: cnt
        Map<String, int[]> hm = new HashMap<>();
        int maxAvg = Integer.MIN_VALUE;
        for (String[] str : s){
            if (hm.containsKey(str[0])){
                int[] t = hm.get(str[0]);
                t[0]+=Integer.parseInt(str[1]);
                t[1]+=1;
                maxAvg = Math.max(maxAvg, t[0] /t[1]);
                hm.put(str[0],t);
            }
            else {hm.put(str[0], new int[]{Integer.parseInt(str[1]), 1});
                maxAvg = Math.max(maxAvg, Integer.parseInt(str[1]));
            }
        }

        System.out.println(maxAvg);
    }
}
