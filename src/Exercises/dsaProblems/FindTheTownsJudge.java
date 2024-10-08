package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//997
public class FindTheTownsJudge {
    public static void main(String[] args) {
        System.out.println(findJudge(3,new int[][]{{1,2},{2,3}}));
    }

    public static int findJudge(int n, int[][] trust) {
        Map<Integer,List<Integer>> hm = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            hm.put(i,new ArrayList<>());
        }
        for (int i = 0; i < trust.length; i++) {
            hm.get(trust[i][0]).add(trust[i][1]);
        }
        int key = -1;
        for(Map.Entry<Integer,List<Integer>> entry: hm.entrySet()){
            if (entry.getValue().size()==0)
                key = entry.getKey();
        }
        if(key==-1)
            return -1;
        else{
            for(Map.Entry<Integer,List<Integer>> entry: hm.entrySet()){
                if (entry.getKey()!=key){
                    if (!entry.getValue().contains(key)){
                        return -1;
                    }
                }
            }
        }
        return key;
    }
}
