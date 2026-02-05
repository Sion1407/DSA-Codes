package Exercises.dsaProblems.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueFreq {
    public static void main(String[] args) {
        int[] ar = new int[]{1,1,2,3,3,4};

        Map<Integer,Integer> hm = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int num: ar){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        for (int k : hm.keySet()){
            if (!set.add(k)){
                System.out.println(false);
                return;
            }
            set.add(k);
        }
        System.out.println(true);
    }
}
