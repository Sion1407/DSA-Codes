package Exercises.dsaProblems;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] res = productExceptSelf(new int[]{1,2,3,4});
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] temp = new int[nums.length];
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];
        int i =1;
//        for left
        l[0] = 1;
        while (i<nums.length){
            l[i] = l[i-1] * nums[i-1];
            i++;
        }
        i = nums.length-2;
        r[nums.length-1] = 1;
        while (i>=0){
            r[i] = r[i+1] * nums[i+1];
            i--;
        }
        for (int j = 0; j < nums.length; j++) {
            temp[j] = l[j] * r[j];
        }

        return temp;
    }
}
