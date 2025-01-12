package Exercises.dsaProblems;

public class ArrayZeroTransform1 {
    public static void main(String[] args) {
        System.out.println(isZeroArray(new int[]{5,4},
                new int[][]{{1,1},{1,1},{0,1},{1,1},{0,0},{0,0},{0,1},{1,1},{1,1}}));
    }
    public static boolean isZeroArray(int[] a, int[][] queries) {
        int n=a.length;
        int c=0;
        int ps[]=new int[n+1];
        for(int i[]:queries){
            ps[i[0]]-=1;
            ps[i[1]+1]+=1;
        }
        for(int i=1;i<n;i++){
            ps[i]+=ps[i-1];
        }
        for(int i=0;i<n;i++){
            if(a[i]+ps[i]>0)
                return false;
        }
        return true;
    }

}
