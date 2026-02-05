package Exercises.dsaProblems.arrays;

public class MaxHoldWater {
    public static void main(String[] args) {
        System.out.println(maxHoldWater(new int[]{2, 1, 5, 3, 1, 0, 4}));
    }
    public static int maxHoldWater(int[] a){
        int l = 1, r = a.length-2, lMax = a[0], rMax = a[a.length-1];

        while (l<r){
            if (lMax<rMax){
                if (a[l] > lMax){
                    lMax = a[l];
                }
                l++;
            }
            else{
                if (a[r] > rMax){
                    rMax = a[r];
                }
                r--;
            }
        }
        return lMax+rMax;
    }
}
