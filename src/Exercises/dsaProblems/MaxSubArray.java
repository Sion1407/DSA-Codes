package Exercises.dsaProblems;

public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    public static int maxSubArray(int[] nums) {
        int l = 0, max = Integer.MIN_VALUE,temp = 0;
        while(l< nums.length){
            temp+=nums[l];
            if(temp>max){
                max = temp;
            }
            if (temp<0)
                temp = 0;
            l++;
        }
        return max;

    }
}
