package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.List;

public class HashDividedString {
    public static void main(String[] args) {
        System.out.println(stringHash("mxz",3));
    }
    public static String stringHash(String s, int k) {
        int l = 0;
        List<String> subStrs = new ArrayList<>();
        String res = "",temp = "";
        int sum = 0,i=0;
        while (l<s.length()){
            temp+=s.charAt(l);
            sum+=s.charAt(l)- 'a';
            i++;
            if (i == k){
                sum = sum % 26;
                res+= (char) (sum + 'a');
                sum = 0;
                i=0;
                temp = "";
            }

            l++;
        }
        return res;
    }
}
