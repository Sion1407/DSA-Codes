package Exercises.dsaProblems;

import java.util.List;

public class MaxVowelsInSubString {
    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef",3));
    }
    public static int maxVowels(String s, int k) {
        int l = 0, r=0,maxV = Integer.MIN_VALUE, currMax= 0;
        List<Character> v = List.of('a','e','i','o','u');
        while(r<k){
            if (v.contains(s.charAt(r))){
                currMax++;
            }
            maxV = Math.max(maxV,currMax);
            r++;
        }
        r--;
        while (r<s.length()){
            if (v.contains(s.charAt(l))){
                currMax--;
            }
            r++;
            l++;
            if (r>=s.length())
                break;
            if (v.contains(s.charAt(r))){
                currMax++;
            }
            maxV = Math.max(maxV,currMax);
        }
        return maxV;
    }
}
