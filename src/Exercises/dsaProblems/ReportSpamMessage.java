package Exercises.dsaProblems;

import java.util.HashSet;
import java.util.Set;

public class ReportSpamMessage {
    public static void main(String[] args) {
        System.out.println(reportSpam(new String[]{"hello","programming","fun"},new String[]{"world","programming","leetcode"}));
    }
    public static boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> hm = new HashSet<>();
        int c = 0;
        for(int i = 0;i<bannedWords.length;i++){
            hm.add(bannedWords[i]);
        }
        for (int i = 0; i < message.length; i++) {
            if (hm.contains(message[i])){
                c++;
            }
        }
        return c>=2 ? true : false;

    }
}
