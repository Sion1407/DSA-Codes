package Exercises.dsaProblems;



//        17. Letter Combinations of a Phone Number

import java.util.*;

public class LetterCombination {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        List<String> numStr = List.of("0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");
        if (digits.isBlank())
            return res;
        else {
            res.add("");
            for (int i = 0; i < digits.length(); i++) {
                int x = Character.getNumericValue(digits.charAt(i));
                while (res.peek().length() == i){
                    String t = res.remove();
                    for (char s : numStr.get(x).toCharArray()){
                        res.add(t+s);
                    }
                }
            }
        }
        return res;
    }
}
