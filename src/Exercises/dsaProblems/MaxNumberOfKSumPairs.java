package Exercises.dsaProblems;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {
    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{1,2,3,4},5));
    }
    public static int maxOperations(int[] nums, int k) {
//        int l = 0, r = 1,cnt = 0;
//        boolean[] check = new boolean[nums.length];
//        while(l<nums.length){
//            if (r>=nums.length) {
//                l++;r=l+1;
//            }
//            else if((nums[l]+nums[r]==k) && check[l] == false && check[r]==false && r!=l){
//                check[l]=true; check[r]=true;
//                l++;r=l+1;
//                cnt++;
//            }
//            else if(check[l]==true && r==l){
//                l++; r = l+1;}
//            else if (check[l]==true) {
//                l++;
//            } else
//                r++;
//        }
//        return cnt;

        Arrays.sort(nums);
        int l = 0,r = 0,lst = 0,cnt = 0;
        while (lst< nums.length && k>nums[lst]){
            lst++;
        }
        boolean[] check = new boolean[nums.length];
        while(l<=lst){
            if (r>lst) {
                l++;r=l+1;
            }
            else if((nums[l]+nums[r]==k) && check[l] == false && check[r]==false && r!=l){
                check[l]=true; check[r]=true;
                l++;r=l+1;
                cnt++;
            }
            else if(check[l]==true && r==l){
                l++; r = l+1;
            }
            else if (check[l]==true) {
                l++;
            } else
                r++;
        }
        return cnt;

    }
}

