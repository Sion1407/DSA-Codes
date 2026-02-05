package Exercises.dsaProblems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GFGMinimizePurchase {
    public static void main(String[] args) {
        System.out.println(minimizeThePurchase(new int[]{8,3,10,5,13},4,7));
    }
    public static int minimizeThePurchase(int[] price, int k, int x) {
//        int min = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < price.length; i++) {
            pq.offer(price[i]);
        }
        for (int i = 0; i < k; i++) {
            int temp = pq.poll() -x;
            if (temp<0)
                pq.offer(0);
            else
                pq.offer(temp);
        }
        int sum = 0, n = pq.size();
        for (int i = 0; i < n; i++) {
            sum+=pq.poll();
        }
        return sum;
//            int[][] d = new int[price.length+1][k+1];
//            min = check(price, k, x, 0,d);
    }
//    8, 3, 10, 5, 13  k=4, x = 7 -ans : 12
//    1+3+3+5+6 = 12
//    base case : start == length return min
//
//    min+= p[i] -  x*n (n )|| min+= p[i];
//    backtrack : min+= x

//    memoization d[start][k]

    private static int check(int []p, int k , int x,int start, int[][] d){
        if (start>=p.length)
            return 0;
        int minSum = Integer.MAX_VALUE;
        if (d[start][k]!=0)
            return d[start][k];
        for (int i = 0; i <= k; i++) {
            int reducedSum = p[start] - (i*x);
            if (reducedSum < 0) reducedSum = 0;
            int newSum =reducedSum+ check(p,k-i,x,start+1,d);
            minSum = Math.min(minSum,newSum);
        }
        d[start][k] = minSum;
        return minSum;
//        sum+=Math.min(check(p,k-1,x,start+1,p[start] - x),check(p,k,x,start+1,p[start]));
//        return sum;
    }
}
