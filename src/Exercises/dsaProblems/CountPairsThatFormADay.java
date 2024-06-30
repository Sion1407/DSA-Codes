package Exercises.dsaProblems;

import java.util.HashMap;
import java.util.Map;
//3184
public class CountPairsThatFormADay {
    public static void main(String[] args) {
        System.out.println(countCompleteDayPairs(new int[]{72,48,24,3}));
    }
    public static int countCompleteDayPairs(int[] hours) {
        int[] freq = new int[24];
        int count = 0;
        int n = hours.length;
        for (int i = 0; i < n; i++) {
            int r = hours[i] % 24;
            if (r == 0) {
                count += freq[0];
            } else {
                count += freq[24 - r];
            }
            freq[r]++;
        }
        return count;
    }
}
