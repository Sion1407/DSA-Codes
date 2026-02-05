package Exercises.dsaProblems.Strings;

import java.util.HashMap;
import java.util.Map;

public class MoreNumCompressedString {
    public static void main(String[] args) {
        String s= "a3c9b2c1";
        Map<Character,Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length()-1;i++){
            if (Character.isDigit(s.charAt(i))) continue;
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i), Character.getNumericValue(s.charAt(i+1))+1));
        }
        String res = "";
        for(Map.Entry<Character, Integer> e: hm.entrySet()){
            res+=e.getKey()+String.valueOf(e.getValue());
        }
        System.out.println(res);
    }
}
