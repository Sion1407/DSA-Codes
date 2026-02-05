package Exercises.dsaProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsValidVowel {
    public static void main(String[] args) {
        String s = "This! is submis$ion form16 date.";
        String[] words = s.split(" ");
        Set<Character> v = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Set<Character> sp = new HashSet<>(Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*'));
        int res = 0;
        for (String word : words) {
            if (word.length() < 3)
                continue;
            boolean hasC = false;
            boolean hasV = false;
            boolean hasS = false;
            for (char c : word.toLowerCase().toCharArray()) {
                if (v.contains(c)) {
                    hasV = true;
                } else if (Character.isAlphabetic(c)) {
                    hasC = true;
                } else if (sp.contains(c)) {
                    hasS = true;
                }
            }
            if (hasV && hasC && !hasS) {
                res++;
            }
        }
        System.out.println(res);
    }

}
