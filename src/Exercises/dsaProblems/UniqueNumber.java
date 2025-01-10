package Exercises.dsaProblems;

public class UniqueNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4,1,2,1,2,3}));
    }
    public static int singleNumber(int[] nums) {
        int res = 0,l=0;
        while(l<nums.length){
            res^=nums[l];
            l++;
        }
        return res;
    }
}
