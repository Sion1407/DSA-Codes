package Exercises.dsaProblems;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1,0,0},2));
    }
    public static boolean canPlaceFlowers(int[] f, int n) {
        int l = 0, i = 1 , r = 2,c = 0;
         if(f[i] == 0 && f[l]==0){
             f[l] = 1;
             c++;
         }
        while(r<f.length){
            if(f[l]==0 && f[r] == 0 && f[i]==0){
                c++;
                f[i] = 1;
            }
            l++;
            i++;
            r++;
        }
        if(f[i-1] == 0 && f[f.length-1]==0){
            f[f.length-1] = 1;
            c++;
        }
        if(c>=n)
            return true;
        return false;
    }
}
