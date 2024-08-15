package Exercises.dsaProblems;
//58
public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("moon"));
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        String [] strArr = s.split(" ");
        return strArr[strArr.length-1].length();
    }
}
