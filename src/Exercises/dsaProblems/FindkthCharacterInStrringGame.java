package Exercises.dsaProblems;

public class FindkthCharacterInStrringGame {
    public static void main(String[] args) {
        System.out.println(kthCharacter(5));
    }
    public static char kthCharacter(int k) {
        String res = "a";
        String game = "";
        if (k <=1){
            return res.charAt(k);
        }
        while (res.length()<=k){
            game = "";
            int l = 0;
            while (l<=res.length()-1) {
                int temp = res.charAt(l);
                temp++;
                char newChar = (char) temp;
                game += newChar;
                l++;
            }
            res+=game;
        }
        return res.charAt(k-1);
    }
}
