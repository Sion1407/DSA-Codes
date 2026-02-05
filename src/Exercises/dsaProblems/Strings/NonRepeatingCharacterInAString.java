package Exercises.dsaProblems.Strings;

import java.util.HashMap;
import java.util.Map;

public class NonRepeatingCharacterInAString {
    public static void main(String[] args) {
        String s = "heelo";
//        char c = (char) Integer.parseInt("12");
        int k = 2;
        Map<Character, Integer> hm = new HashMap<>();
        for(char c: s.toCharArray()){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        for (char c: s.toCharArray()) {
            if (k==1 && hm.get(c)==1){
                System.out.println(c);
                return;
            }
            else if (hm.get(c)==1){
                k--;
            }
        }
    }

}
