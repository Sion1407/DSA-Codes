package Exercises.dsaProblems;

import java.util.HashMap;
import java.util.Map;

// fibbonacci,
public class Anagram2Strings {
    public static void main(String[] args) {
        Map<Character,Integer> cnt = new HashMap<>();
        Map<Character,Integer> cnt1 = new HashMap<>();
        String s = "Naman",s2 = "nioSe";
        if (s.length()!=s2.length())
            System.out.println(false);
        else {
            s.toLowerCase();
            s2.toLowerCase();
            char[] c1 = s.toCharArray();
            char[] c2 = s2.toCharArray();
            for (int i = 0; i < c1.length; i++) {
                cnt.put(c1[i],cnt.getOrDefault(c1[i],0)+1);
                cnt1.put(c2[i],cnt1.getOrDefault(c2[i],0)+1);
            }
            if (cnt.equals(cnt1))
                System.out.println(true);
            else
                System.out.println(false);
        }
        System.out.println("Palindrone: "+palindrome(s));
        System.out.println("fibonacci: " );
        fib(8);
    }

    private static boolean palindrome(String s){
        String t = s;
        char [] c1 = s.toCharArray();
        for (int i = 0; i < c1.length/2; i++) {
            char temp = c1[i];
            c1[i] = c1[c1.length-i-1];
            c1[c1.length-i-1] = temp;
        }
        String t2 = new String(c1);
        if (t.equalsIgnoreCase(t2))
            return true;
        else
            return false;
    }
    private static void fib(int n){
        int s = 0, nxt = 1,sum = 0;
        for (int i = 0; i < n; i++) {
            sum = s+nxt;
            System.out.print(s +" ");
            s = nxt;
            nxt = sum;
        }
    }
}
