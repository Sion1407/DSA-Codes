package Exercises.dsaProblems;

public class SumOfGoodNums {
    public static void main(String[] args) {
        System.out.println(sumOfGoodNumbers(new int[]{1,3,2,1,5,4},2));
    }
    public static int sumOfGoodNumbers(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(i-k >= 0 && i+k < nums.length && nums[i] > nums[i-k] && nums[i] > nums[i+k]){
                sum+=nums[i];
            }
            if (i-k<0 || i+k >= nums.length){
                if(i-k >= 0 &&  nums[i] > nums[i-k]){
                    sum+=nums[i];
                }
                else if(i+k < nums.length && nums[i] > nums[i+k])
                    sum+=nums[i];
            }
        }
        return sum;
    }
}
