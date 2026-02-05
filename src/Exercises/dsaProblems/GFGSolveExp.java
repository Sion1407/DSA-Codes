package Exercises.dsaProblems;

import java.util.*;

public class GFGSolveExp {
    public static void main(String[] args) {
        System.out.println(solveTheExpression(new int[]{3,7,6},new int[]{9,2,4},2));
    }
    public static long solveTheExpression(int[] a, int[] b, int k) {
        long min = Long.MAX_VALUE, sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());

        TreeMap<Integer, Integer> hm = new TreeMap<>();
        for (int i = 0; i < a.length; i++) {
            hm.put(a[i], b[i]);
        }
        int n = a.length;
        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(a[i], b[i]);
        }

        Arrays.sort(pairs, (p1, p2) -> Integer.compare(p1.a, p2.a));

        for (int i = 0; i < n; i++) {
            System.out.println(pairs[i].a + " : " +pairs[i].b);
        }
        for (int i = 0; i < a.length; i++) {
            pq.offer(pairs[i].b);
            sum+=pairs[i].b;
            if (pq.size()>k){
                sum-=pq.poll();
            }
            if (i>=k-1){
                min = Math.min((long) pairs[i].a * sum,min);
            }
        }

        System.out.println(pq);
        return min;
    }

    static class Pair {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

    }

}
