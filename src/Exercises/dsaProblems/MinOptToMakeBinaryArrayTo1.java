package Exercises.dsaProblems;

public class MinOptToMakeBinaryArrayTo1 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{0,1,1,1}));
    }

    public static int minOperations(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i]==0) {
                res++;
                for (int j = i; j < nums.length && j < i+3; j++) {
                    if (nums[j]==0)
                        nums[j]=1;
                    else if (nums[j]==1) {
                        nums[j] = 0;
                    }
                }
            }
        }
        for (int i = 0;i<nums.length;i++){
            if (nums[i]==0)
                return -1;
        }
        return res;
    }
}
