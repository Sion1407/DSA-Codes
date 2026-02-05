package Exercises.dsaProblems.arrays;

import java.util.ArrayList;
import java.util.List;

// [3,1,2]
// 3
// 2
// 1
// [3 , 1] contagious subsequence/subarray
// [1,2]
// [3,2]  non-contagious
//subsequence can be a subarray but not all subarray can be subsequence
public class SubSequenceOfArray {
    public static void main(String[] args) {
        int[] a = new int[]{3,1,2};
        subarray(0, new ArrayList<>(), a);
    }
    private static void subarray(int i, List<Integer> t, int [] a){
        if (i>=a.length){
            System.out.println(t);
            return;
        }
        t.add(a[i]);
        subarray(i+1,t,a);
        t.remove(t.size()-1);
        subarray(i+1,t,a);
    }
}
