package Exercises.dsaProblems;

//13.Roman to Integer
//        For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
//
//        Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
//
//        I can be placed before V (5) and X (10) to make 4 and 9.
//        X can be placed before L (50) and C (100) to make 40 and 90.
//        C can be placed before D (500) and M (1000) to make 400 and 900.
//        Given a roman numeral, convert it to an integer.
//
//
//
//        Example 1:
//
//        Input: s = "III"
//        Output: 3
//        Explanation: III = 3.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
    public static int romanToInt(String s) {
//        I can be placed before V (5) and X (10) to make 4 and 9.
//        X can be placed before L (50) and C (100) to make 40 and 90.
//        C can be placed before D (500) and M (1000) to make 400 and 900.
        Map<Character,Integer> hm = new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);
        char[] sToChar = s.toCharArray();
        int res = 0;
        for (int i = 0; i < sToChar.length; i++) {
            int r1 = hm.get(sToChar[i]);
            if (i+1< sToChar.length){
                int r2 = hm.get(sToChar[i+1]);
                if (r1>= r2){
                    res+=r1;
                }
                else {
                    res = res - r1 + r2;
                    i++;
                }
            }
            else {
                res+=r1;
            }
        }
        return res;
    }
}
