package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public static void main(String[] args) {
        System.out.println(grayCode(3));
    }
    static List<Integer> res = new ArrayList<>();
    public static List<Integer> grayCode(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("0");
        }
        comb(sb.toString().toCharArray(),0);
        return res;
    }
    private static void comb(char[] c, int idx){
        if (idx==c.length) {
            res.add(Integer.parseInt(new String(c),2));
            return;
        }
            c[idx] = '0';
            comb(c,idx+1);

            c[idx] = '1';
            comb(c,idx+1);
    }
}
