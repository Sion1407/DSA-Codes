package Exercises.dsaProblems;

public class SubstringMatchingPattern {
    public static void main(String[] args) {
        System.out.println(hasMatch("ckckkk","ck*kc"));
    }
    public static boolean hasMatch(String s, String p) {
        int index = p.indexOf('*');
        int firstpos = s.indexOf(p.substring(0, index));
//        firstpos + length of first half of substring "ck*"
        int secondpos = s.indexOf(p.substring(index + 1), firstpos+index);
        if (firstpos != -1 && secondpos != -1) {
            return true;
        }
        return false;
    }
}
