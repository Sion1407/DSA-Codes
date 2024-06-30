package Exercises.dsaProblems;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chr = strs[i].toCharArray();
            Arrays.sort(chr);
            String str = new String(chr);
            if (!hm.containsKey(str)){
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                hm.put(str, temp);
            }
            else {
                List<String> temp = hm.get(str);
                temp.add(strs[i]);
                hm.put(str,temp);
            }
        }

        for(Map.Entry<String,List<String>> entry: hm.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}
