package Exercises.dsaProblems.Strings;

public class NumberFormation {
    public static void main(String[] args) {
        System.out.println(getSum(1,1,1));
    }
//    static List<String> possibleComb = new ArrayList<>();
    final static int MOD = 1000000007;
    static long sum = 0l;
    public static int getSum(int X, int Y, int Z) {
        // Your code goes here
        perm(0,0,0,X,Y,Z,new StringBuilder());
        return (int) sum;
    }
    private static void perm(int x,int y,int z,int X,int Y, int Z, StringBuilder s){
        if(s.length()>0) {
            sum = sum+Long.valueOf(s.toString())%MOD;
        }
        if (x<X){
            perm(x+1,y,z,X,Y,Z,s.append("4"));
            s.deleteCharAt(s.length() - 1);
        }
        if (y<Y){
            perm(x,y+1,z,X,Y,Z,s.append("5"));
//            possibleComb.add(s.toString());
            s.deleteCharAt(s.length() - 1);
        }
        if (z<Z){
            perm(x,y,z+1,X,Y,Z,s.append("6"));
//            possibleComb.add(s.toString());
            s.deleteCharAt(s.length() - 1);
        }

    }
}
