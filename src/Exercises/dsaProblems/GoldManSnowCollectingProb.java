package Exercises.dsaProblems;

import java.util.Arrays;

public class GoldManSnowCollectingProb {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,3,0,1,2,0,4,2,0,3,0};
//        use prefix and suffix array

        int[] pre = new int[arr.length];
        int[] suf = new int[arr.length];

        pre[0] = arr[0];
        for (int i =1;i<arr.length;i++){
            pre[i] = Math.max(pre[i-1], arr[i]);
        }
        suf[arr.length-1] = arr[arr.length-1];
        for (int i =arr.length-2;i>=0;i--){
            suf[i] = Math.max(suf[i+1], arr[i]);
        }
        System.out.println(Arrays.toString(pre)+" - "+ Arrays.toString(suf));
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res+= Math.min(pre[i],suf[i]) - arr[i];
        }
        System.out.println(res);
    }
}
