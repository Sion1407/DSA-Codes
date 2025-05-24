package Exercises.dsaProblems.greedy;

import java.util.PriorityQueue;

public class MinimumTimeToTypeWordUsingSpecialTypewriter {
    public static void main(String[] args) {
        System.out.println(minTimeToType("abc"));;
    }
    public static int minTimeToType(String word) {
        int res = 0;
        char curr = 'a';
        for(char c: word.toCharArray()){
            res+= Math.min(Math.abs(curr - c), 26 - Math.abs(curr - c));
            res+=1;
            curr = c;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = (int) Math.floor(9/2);
        return res;
    }
}
