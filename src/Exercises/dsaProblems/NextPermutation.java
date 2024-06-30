package Exercises.dsaProblems;

//31. Next Permutation

public class NextPermutation {
    public static void main(String[] args) {
        int [] nums = new int[]{1, 1, 5};
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void nextPermutation(int[] nums) {
        int rms = nums.length-2;
        while (rms>=0 && nums[rms]>=nums[rms+1]){
            rms--;
        }
        if (rms!=0){
            int j = nums.length-1;
            while (nums[rms]>=nums[j])
                j--;
            int temp = nums[rms];
            nums[rms] = nums[j];
            nums[j] = temp;
        }
        int i = rms+1, k = nums.length-1;
        while (i<k){
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
            k--;
            i++;
        }
    }
}
