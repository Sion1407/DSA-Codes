package Exercises.dsaProblems;

public class MaxAverageSubarray1 {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
    }
    public static double findMaxAverage(int[] nums, int k) {
        double max=Integer.MIN_VALUE;
        double sum=0;
        int start=0;
        for(int end=0;end<nums.length;end++){
            sum=sum+nums[end];
            if(end-start+1==k){
                max=Math.max(max,sum/k);
                sum=sum-nums[start];
                start++;
            }
        }
        return max;
    }
}
