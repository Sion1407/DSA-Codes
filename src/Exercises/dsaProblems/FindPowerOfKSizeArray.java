package Exercises.dsaProblems;

import java.util.Arrays;

public class FindPowerOfKSizeArray {
    public static void main(String[] args) {
        int [] res = resultsArray(new int[]{1,2,3,4,3,2,5},3);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] resultsArray(int[] nums, int k) {
//        int l = 0,itr = 0;
//        int []res = new int[(nums.length-k)+1];
//        while (l<= nums.length-k){
//            int tem = k-1;
//            boolean f = true;
//            int r = l;
//            while(tem!=0){
//                if(nums[r] != nums[r+1]-1) {
//                    f=false;
//                    break;
//                }
//                tem--;
//                r++;
//            }
//            if (f){
//                res[itr] = nums[l+k-1];
//                itr++;
//            }
//            else{
//                res[itr] = -1;
//                itr++;
//            }
//            l++;
//        }
//        return res;
//        1,2,3,4,3,2,5},3
//        Approach 2
        int cnt = 1,l = 1;
        int res[] = new int[(nums.length-k)+1];
        if (k==1) return nums;
        Arrays.fill(res,-1);
        while (l<nums.length){
            if (nums[l]!=nums[l-1]+1)
                cnt = 1;
            else{
                cnt++;
                if (cnt>=k)
                    res[l-k+1] = nums[l];
            }
            l++;
        }
        return res;
    }
}
