package Exercises.dsaProblems;

public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(zigZagConversion("PAYPALISHIRING",3));
    }
    static String zigZagConversion(String s,int row){
        String res = "";
        for (int r = 0;r< row; r++){
//            for normal scenarios to get next char in the string for first and last element will be 2 * (n-1)
            int inc = 2 * (row-1);
            for (int j = r;j< s.length();j+=inc ){
                res += s.charAt(j);
//                for middle rows check if the r is in middle row and then use j + inc -2*r
                if (r>0 && r < row-1 && (j+ inc - 2*r) < s.length()){
                    res+= s.charAt(j+ inc - (2*r));
                }
            }
        }
        return res;
    }
}
