package Exercises.dsaProblems.arrays;

public class KadensSubarraySumOrProduct {
    public static void main(String[] args) {
        int [] a = new int[]{2, 3, -8, 7, -1, 2, 3};

        int res = a[0], maxEnding = a[0];
        for (int i = 0; i < a.length; i++) {
//            either start a new array if maxending goes below 0 or less than current sum
//            or else continue adding a[i] in the current sum
            maxEnding = Math.max(maxEnding+a[i],a[i]);
            res = Math.max(res,maxEnding);
        }
        System.out.println(res);
    }

}
