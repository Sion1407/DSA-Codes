package Exercises.dsaProblems.Strings;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i","love","leetcode","i","love","coding"},2));
    }
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> hm = new HashMap<>();
        for(String s : words){
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        System.out.println(hm);
        List<String> res = new ArrayList<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> hm.get(a).equals(hm.get(b)) ? a.compareTo(b) : hm.get(b) - hm.get(a));
        for (String w: hm.keySet()){
            pq.add(w);
        }
//        only applies comparator logic when polling
        System.out.println(pq);
        while (k>0){
            res.add(pq.poll());
            k--;
        }
        return res;
    }
}
