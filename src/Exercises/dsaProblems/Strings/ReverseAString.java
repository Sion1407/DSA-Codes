package Exercises.dsaProblems.Strings;

public class ReverseAString {
    public static void main(String[] args) {
        System.out.println(reverseWords("cb ipctpyru  bovcbo"));
    }
    public static String reverseWords(String s) {
        // Code here
        s = s.trim();
        String[] splitStr = s.split(" ");
        String res = "";
        for(int i = splitStr.length-1; i>=0;i--){
            if(splitStr[i].isBlank()) continue;
            if(i==0){
                res+=splitStr[i];
            }
            else res+=splitStr[i]+" ";
        }
        return res;
    }
}
