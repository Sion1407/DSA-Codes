package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.List;

public class FindSeqOfStringsAppOnScreen {
    public static void main(String[] args) {
        System.out.println(stringSequence("he"));
    }

    public static List<String> stringSequence(String target) {
        List<String>res = new ArrayList<>();
        StringBuilder s = new StringBuilder("a");
        res.add(s.toString());
        char addChr = 'a';
        int i = 0;
        while (!s.equals(target)){
            if (target.charAt(i)!=s.charAt(i)){
                while (s.charAt(i)!=target.charAt(i)){
                    char incrementedChar = (char) (s.charAt(i) + 1);
                    s.setCharAt(i,incrementedChar);
                    res.add(s.toString());
                }
                if (s.length()<target.length()){
                    s.append(addChr);
                    res.add(s.toString());
                }
                else
                    break;
            }
            else {
                if (s.length()<target.length()){
                    s.append(addChr);
                    res.add(s.toString());
                }
                else{
                    break;
                }
            }
            i++;
        }
        return res;
    }
}

//3324

