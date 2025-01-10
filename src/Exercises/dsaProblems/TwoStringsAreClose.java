package Exercises.dsaProblems;

//import scala.Char;

import java.util.*;

//1657
public class TwoStringsAreClose {
    public static void main(String[] args) {
        System.out.println(closeStrings("cabbba","abbccc"));
    }
    public static boolean closeStrings(String word1, String word2) {
        if (word1.length()!=word2.length())
            return false;
        Map<Character,Integer> hm1 = new HashMap<>();Map<Character,Integer> hm2 = new HashMap<>();
        int  l = 0;
        while (l<word1.length()){
            hm1.put(word1.charAt(l),hm1.getOrDefault(word1.charAt(l),1)+1);
            hm2.put(word2.charAt(l),hm2.getOrDefault(word2.charAt(l),1)+1);
            l++;
        }
        l = 0;
        HashSet<Character> set1 = new HashSet<>();HashSet<Character> set2 = new HashSet<>();
        List<Integer> l1 = new ArrayList<>();List<Integer> l2 = new ArrayList<>();
        for (Map.Entry<Character,Integer> entry: hm1.entrySet()){
            set1.add(entry.getKey());
            l1.add(entry.getValue());
        }for (Map.Entry<Character,Integer> entry: hm2.entrySet()){
            set2.add(entry.getKey());
            l2.add(entry.getValue());
        }
        Collections.sort(l1);Collections.sort(l2);

        if (l1.equals(l2) && set1.equals(set2))
            return true;
        return false;
    }
}
