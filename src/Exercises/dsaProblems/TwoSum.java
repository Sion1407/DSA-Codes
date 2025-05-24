package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{1,1,1,1,1,1,1,1,1},2));
    }
    private static List<List<Integer>> twoSum(int[] a,int t){
        Arrays.sort(a);
        int l = 0, r = a.length-1;
        List<List<Integer>> res = new ArrayList<>();
        while (l<r){
            int sum = a[l] + a[r];
            if (sum > t){
                r--;
            }
            else if (sum< t){
                l++;
            }
            else{
                List<Integer> temp = List.of(a[l],a[r]);
                res.add(temp);
                l++;r--;
            }
        }
        return res;
    }
}
