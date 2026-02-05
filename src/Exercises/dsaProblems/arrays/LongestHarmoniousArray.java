package Exercises.dsaProblems.arrays;

import java.util.ArrayList;
import java.util.List;

public class LongestHarmoniousArray {
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int [] a = new int[]{1,3,2,2,5,2,3,7};
        subSeq(a,0,new ArrayList<>());
        System.out.println(res);
    }

    private static void subSeq(int[] a, int i,List<Integer> lst){
        if (i>=a.length){
            if (!res.contains(lst))
                res.add(new ArrayList<>(lst));
//            lst = new ArrayList<>();
            System.out.println(lst);
            return;
        }
        for (int j = i; j < a.length; j++) {
            lst.add(a[j]);
            subSeq(a,j+1,lst);
            lst.remove(lst.size()-1);
            subSeq(a,j+1,lst);
        }
    }
//    private int maxMinDiff(List<Integer> l){
//
//    }
}
