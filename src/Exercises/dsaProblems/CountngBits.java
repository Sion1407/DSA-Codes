package Exercises.dsaProblems;

public class CountngBits {
    public static void main(String[] args) {
        int [] res = countBits(5);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+ " ");
        }
    }
    public static int[] countBits(int n) {
        int res[] = new int[n+1];

//        for (int i = 0; i < res.length; i++) {
//            int cnt = 0,t = i;
//            while (t>0) {
//                if (t % 2 == 1)
//                    cnt++;
//                t = t/2;
//
//            }
//            res[i] = cnt;
//        }
        for (int i = 1; i <= n; ++i)
            res[i] = res[i / 2] + (i % 2);
        return res;
    }
}
