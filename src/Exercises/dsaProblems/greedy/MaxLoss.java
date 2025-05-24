package Exercises.dsaProblems.greedy;

public class MaxLoss {
    public static void main(String[] args) {
        System.out.println(maxLoss(new int[]{9, 2, 4, 10}));
    }
    public static int maxLoss(int[] s){
        int res = 0,l = 0, r= 1;
        while (l< s.length){
            if (r>=s.length) {
                l++;
                r = l+1;
            }
            else{
                res = Math.max(res, s[l] - s[r]);
                r++;
            }
        }
        return res;
    }
}
