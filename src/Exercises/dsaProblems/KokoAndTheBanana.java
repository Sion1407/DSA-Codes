package Exercises.dsaProblems;

public class KokoAndTheBanana {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{312884470},312884469));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(piles[i],max);
        }
        int res = max, i =1;
        while (i<=max){
            int mid = i+(max-i)/2,s= 0;
            for (int j = 0; j < piles.length; j++) {
                int t = piles[j];
                while (t>0){
                    s++;
                    t-= mid;
                }
            }
            if (s==h)
                return mid;
            if (s>h) {
                i = mid+1;
            }
            else {
                res = Math.min(mid,res);
                max = mid-1;
            }
//            System.out.println(s);
        }
        return res;

    }
}
