package Exercises.dsaProblems;

public class IncreasingTripletSubseq {
    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{5,4,3,2,1}));
    }
    public static boolean increasingTriplet(int[] nums) {
        if (nums.length <3) return false;
        int i = Integer.MAX_VALUE, j = Integer.MAX_VALUE, l = 0;
        while (l < nums.length ){
            if (nums[l] < i) i = nums[l];
            else if (i < nums[l] && nums[l] < j) {
                j = nums[l];
            }
            else if (nums[l] > i && nums[l] > j){
                return true;
            }
            l++;
        }
        return false;

    }
}
