package Exercises.dsaProblems;

import java.util.Arrays;
import java.util.List;

public class ReverseVowelString {
    public static void main(String[] args) {
        System.out.println(reverseVowels("IceCreAm"));
    }
    public static String reverseVowels(String s) {
        int l = 0, r= s.length()-1;
        List<Character> v = List.of('a','A','e','E','i','I','o','O','u','U');
        char[] str = s.toCharArray();
        while(l<=r){
            if(v.contains(str[l]) && v.contains(str[r])){
                char temp = str[r];
                str[r] = str[l];
                str[l] = temp;
                l++;r--;
            }
            else if(v.contains(str[l]) && !v.contains(str[r])){
                while(!v.contains(str[r]) && l!=r){
                    r--;
                }
            }
            else if(!v.contains(str[l]) && v.contains(str[r])){
                while(!v.contains(str[l]) && l!=r){
                    l++;
                }
            }
            else{
                l++;r--;
            }
        }
        return String.valueOf(str);
    }
}
