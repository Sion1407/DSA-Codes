package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.List;

public class CountOfSubstringsContainingEveryVowelandKConsonants {
    public static void main(String[] args) {
        System.out.println(countOfSubstrings("aeiou",0));
    }
    static String vowels = "aeiou";

    public static int countOfSubstrings(String word, int k) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            helper(word,i,"",res,k);
        }
        return res.size();
    }
    private static void helper(String s, int i,String curr,List<String> res,int k){
        if (i==s.length())
            return;
        curr += s.charAt(i);
        if (curr.contains("a") && curr.contains("e") && curr.contains("i") && curr.contains("o") &&
                curr.contains("u") && countConsonants(curr)==k)
            res.add(curr);
        helper(s,i+1,curr,res,k);
    }
    private static int countConsonants(String s){
        int cnt= 0;
        for (char c: s.toCharArray()) {
            if (!vowels.contains(String.valueOf(c))){
                cnt++;
            }
        }
        return cnt;
    }
}
