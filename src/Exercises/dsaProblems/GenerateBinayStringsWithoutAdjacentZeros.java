package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.List;

//3211
public class GenerateBinayStringsWithoutAdjacentZeros {
    public static void main(String[] args) {
        System.out.println(validStrings(3));
    }

    public static List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();
        helper(res,n,new StringBuilder(),-1);
        return res;
    }
    private static void helper(List<String> res, int n, StringBuilder temp, int lc){
        if (temp.length()==n){
            res.add(temp.toString());
            return;
        }
        temp.append("1");
        helper(res,n,temp,1);
        temp.deleteCharAt(temp.length()-1);
        if (lc!=0){
            temp.append("0");
            helper(res,n,temp,0);
            temp.deleteCharAt(temp.length()-1);
        }
    }

}
