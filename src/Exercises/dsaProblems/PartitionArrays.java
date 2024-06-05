package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.List;

public class PartitionArrays {
    public static void main(String[] args) {
        int[] nums = new int[]{9,12,5,10,14,3,10};
        int [] res = pivotArray(nums, 10);
        for (int i = 0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }

    public static int[] pivotArray(int[] nums, int x){
        int[] less = new int[nums.length],greater = new int[nums.length], equal = new int[nums.length];
        int j = 0,k=0, l = 0 ;
        for (int i = 0; i< nums.length;i++){
            if (nums[i]<x){
                less[j] = nums[i];
                j++;
            } else if (nums[i] == x) {
                equal[l] = x;
                l++;
            } else {
                greater[k] = nums[i];
                k++;
            }
        }
        int [] res = new int[nums.length];
        System.arraycopy(less,0,res,0,j);
        System.arraycopy(equal,0,res,j,l);
        System.arraycopy(greater,0,res,j+l,k);

        return res;

    }
}
