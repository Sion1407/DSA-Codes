package Exercises.dsaProblems;

//283
public class MoveZeroes {
    public static void main(String[] args) {
        int []res = new int[]{4,2,4,0,0,3,0,5,1,0};
        moveZeroes(res);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    public static void moveZeroes(int[] nums) {
        if (nums.length==0 || nums.length==1){
            return;
        }
        int l = 0, r= l+1;
        while (r< nums.length && l< nums.length){
            if (nums[l]==0 && nums[r]!=0){
                swap(nums, l ,r);
                l++;
                r++;
            }
            else if (nums[l]==0 && nums[r]==0){
                r++;
            } else if (nums[l]!=0 && nums[r]!=0) {
                l++;r++;
            } else {
                l++;
            }
        }
    }
    private static void swap(int[] nums, int l , int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
