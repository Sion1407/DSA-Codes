package Exercises.dsaProblems;

//55
public class JumpProblem {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length-1;
        for (int i = nums.length-2; i>=0; i--) {
            if (n-i<=nums[i]) {
                n=i;
            }
        }
        return n==0;

    }
}
