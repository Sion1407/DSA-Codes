package Exercises.dsaProblems;
// 1105
public class FillingBookSHelf {
    public static void main(String[] args) {
        System.out.println(minHeightShelves(new int[][]{{1,3},{2,4},{3,2}}, 6));
    }
    static Integer[] memo;
    public static int minHeightShelves(int[][] books, int shelfWidth) {
        memo = new Integer[books.length];
        return helper(books, shelfWidth , 0 );
    }
    public static int helper(int[][] b, int sw, int i){
        if (i==b.length){
            return 0;
        }
        if (memo[i]!=null) return memo[i];
        int currW = 0, mh = 0 , ans = Integer.MAX_VALUE;
        for (int j = i; j < b.length; j++) {
//            int h = b[j][1];
            currW += b[j][0];
            if (currW > sw){
                break;
            }
            mh = Math.max(mh,b[j][1]);
            ans = Math.min(ans,mh+ helper(b,sw,j+1));

        }
        return memo[i] = ans;
    }
}
