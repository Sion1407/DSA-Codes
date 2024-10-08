package Exercises.dsaProblems;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{0,0}));
    }
    public static String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        StringBuilder res = new StringBuilder();
        for (int i = 0;i< nums.length;i++){
            str[i] = String.valueOf(nums[i]);
//            System.out.print(str[i] + " ");
        }
        Arrays.sort(str,(a,b)->(b+a).compareTo(a+b));
        if (str[0] == "0")
            return "0";
        for (int i = 0; i < str.length; i++) {
            res.append(str[i]);
        }
        return res.toString();

    }
}
