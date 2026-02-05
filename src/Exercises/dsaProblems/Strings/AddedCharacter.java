package Exercises.dsaProblems.Strings;

public class AddedCharacter {
    public static void main(String[] args) {
        findAddedCharacter("AZZXSHOA","XAZZXSHOA");
    }
    public static void findAddedCharacter(String s, String t) {
        // Write your code here.

        for(int j = 0; j< s.length();j++){
            if(s.charAt(j) != t.charAt(j)){
                System.out.println(t.charAt(j));
                return;
            }
        }
        System.out.println(t.charAt(t.length()-1));
    }
}
