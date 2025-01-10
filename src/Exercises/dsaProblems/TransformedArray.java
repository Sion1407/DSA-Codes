package Exercises.dsaProblems;

public class TransformedArray {
    public static void main(String[] args) {
        int [] res = constructTransformedArray(new int[]{-10});
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] constructTransformedArray(int[] nums) {
        int [] res = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            if(nums[i]==0)
                res[i] = nums[i];
            int targetIndex = (i + nums[i]) % nums.length;


            if (targetIndex < 0) {
                targetIndex += nums.length;
            }

            res[i] = nums[targetIndex];
        }
        return res;
    }
}
