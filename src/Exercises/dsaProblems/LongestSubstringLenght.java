package Exercises.dsaProblems;

//Example 1:
//
//        Input: s = "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.
//        Example 2:
//
//        Input: s = "bbbbb"
//        Output: 1
//        Explanation: The answer is "b", with the length of 1.
//        Example 3:
//
//        Input: s = "pwwkew"
//        Output: 3
//        Explanation: The answer is "wke", with the length of 3.
//        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

import java.util.*;

public class LongestSubstringLenght {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> hashMap = new LinkedHashMap<>();
        int res = 0;
        for(int i=0;i<s.length();i++){
            if (!hashMap.containsKey(s.charAt(i))){
                hashMap.put(s.charAt(i),i);
            }
            else {
                i= hashMap.get(s.charAt(i));
                hashMap.clear();
            }

            if (hashMap.size()>res)
                res = hashMap.size();
        }
        return res;
    }
}
