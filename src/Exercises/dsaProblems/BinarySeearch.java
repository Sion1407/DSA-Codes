package Exercises.dsaProblems;

import java.util.Arrays;

public class BinarySeearch {
    public static void main(String[] args) {
        int []res = new int[]{9,8,7,5,4,3,21};
        int k = 3,l = 0,r = res.length-1,min=-1;
        Arrays.sort(res);

        while(l<=r) {
            int mid = l+(r-1)/2;

            if (res[mid]==k) {
                min = mid;
                break;
            }
            else if (res[mid]>k){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        System.out.println(min);
    }
}
