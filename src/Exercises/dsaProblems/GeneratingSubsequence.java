package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.List;

public class GeneratingSubsequence {
    public static void main(String[] args) {
        int[] ar = new int[]{1,2,3};
        List<List<Integer>> res = new ArrayList<>();
        genSubseq(0,ar,new ArrayList<>(),res);
        System.out.println(res);
    }

    private static void genSubseq(int s, int[] arr, List<Integer> t, List<List<Integer>> res){
        if (s== arr.length){
            res.add(new ArrayList<>(t));
            return;
        }
        t.add(arr[s]);
//        with the start element
        genSubseq(s+1,arr,t,res);

        t.remove(t.size()-1);
        genSubseq(s+1,arr,t,res);
    }
}
