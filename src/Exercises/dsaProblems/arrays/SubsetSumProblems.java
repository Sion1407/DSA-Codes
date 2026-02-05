package Exercises.dsaProblems.arrays;

import java.util.ArrayList;
import java.util.List;

public class SubsetSumProblems {
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,3,7,8,10};
        System.out.println(subssetPresent(arr,11));
    }
    static List<List<Integer>> s = new ArrayList<>();
    public static boolean subssetPresent(int[] a,int t){
        checkSubssets(a,new ArrayList<>(),0,0,t);
        return s.size()>0 ? true : false;
    }
    private static void checkSubssets(int[] a, List<Integer> temp,int idx,int sum,int t){
        if (sum == t) {
            s.add(new ArrayList<>(temp));
            return;
        }
        for (int i = idx; i < a.length; i++) {
            temp.add(a[i]);
            sum+=a[i];
            checkSubssets(a,temp,i+1,sum,t);
            sum-=a[i];
            temp.remove(temp.size()-1);
        }
    }
}
