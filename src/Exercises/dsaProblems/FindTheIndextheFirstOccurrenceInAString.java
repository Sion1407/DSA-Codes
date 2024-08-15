package Exercises.dsaProblems;

//28. Find the Index of the First Occurrence in a String
public class FindTheIndextheFirstOccurrenceInAString {
    public static void main(String[] args) {
        System.out.println(strStr("mississippi","pi"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length()>haystack.length())
            return -1;
        else{
            int n = 0, l = 0, r;
            while (l<haystack.length()){
                if (needle.charAt(n)==haystack.charAt(l)){
                    r = l+1;
                    n++;
                    while (r<haystack.length() && n<needle.length() &&(needle.charAt(n)==haystack.charAt(r))){
                        r++;n++;
                    }
                    if (n==needle.length()){
                        return l;
                    }
                }
                n = 0;
                l++;
            }
            return -1;
        }
    }
}
