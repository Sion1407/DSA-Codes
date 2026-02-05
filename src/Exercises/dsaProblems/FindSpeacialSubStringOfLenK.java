package Exercises.dsaProblems;

public class FindSpeacialSubStringOfLenK {
    public static void main(String[] args) {
        System.out.println(hasSpecialSubstring("aaabaaa",3));
    }
    public static boolean hasSpecialSubstring(String s, int k) {
        int count = 1;
        for(int i = 1; i < s.length(); ++i){
            boolean b = s.charAt(i) != s.charAt(i - 1);
            if( b && count == k ) return true;
            if(b) count = 0;
            count++;
        }
        return (count == k);
    }
}
