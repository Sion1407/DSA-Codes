package Exercises.dsaProblems;

public class FlippingGame {
    public static void main(String[] args) {
        System.out.println(flippingGame(new int[]{1 ,0, 0, 1 ,0},5));
    }
    public static int flippingGame(int[] a,int n){
        int sum = 0;
        for (int i =0;i<n;i++){
            sum+=a[i];
        }
        int res = sum;
        for (int i =0;i<n;i++){
            int noOfZ = 0;
            if (a[i]==1) {
                sum--;
                noOfZ = sum;
            }
            else {
                noOfZ = sum+1;
            }
            for (int j = i+1; j < n; j++) {
                if (a[j]==0)
                    noOfZ++;
                else{
                    noOfZ--;
                }
                res = Math.max(res,noOfZ);
            }
            if (a[i]==1)
                sum++;
        }
        return res;
    }
}
