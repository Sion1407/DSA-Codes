package Exercises.dsaProblems;

public class FinalArrayState {
    public static void main(String[] args) {
        int [] res = new int[]{2,1,3,5,6};
        getFinalState(res,5,2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        int i = 0, min = Integer.MAX_VALUE;
        while(k!=0){
            i = 0;
            int idx = 0;
            while(i<nums.length){
                if(min > nums[i] && min!=nums[i]){
                    min = nums[i];
                    idx = i;
                }
                i++;
            }
            nums[idx] *= multiplier;
            k--;
        }
        return nums;
    }
}
