package Exercises.dsaProblems;

//3226
public class NumberOfBitChanges {
    public static void main(String[] args) {
        System.out.println(minChanges(13, 4));
    }

    public static int minChanges(int n, int k) {
        if (n == k) {
            return 0;
        } else if ((n & k) != k) {
            return -1;
        } else {
            String sn = Integer.toBinaryString(n);
            String sk = Integer.toBinaryString(k);
            int cn = 0, ck = 0;
            for (int i = 0; i < sn.length(); i++) {
                if (sn.charAt(i) == '1')
                    cn++;
            }
            for (int i = 0; i < sk.length(); i++) {
                if (sk.charAt(i) == '1')
                    ck++;
            }
            return cn > ck ? (cn - ck) : ck - cn;
        }


    }
}
