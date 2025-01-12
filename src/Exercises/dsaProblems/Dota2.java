package Exercises.dsaProblems;

import java.util.LinkedList;
import java.util.Queue;

//649
public class Dota2 {
    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RDD"));
    }
    public static String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i)=='R')
                r.add(i);
            else
                d.add(i);
        }
        while (!r.isEmpty() && !d.isEmpty()){
            if (r.poll()< d.poll()){
                r.add(++n);
            }
            else
                d.add(++n);
        }
        if (r.isEmpty())
            return "Dire";
        else
            return "Radiant";
    }
}
