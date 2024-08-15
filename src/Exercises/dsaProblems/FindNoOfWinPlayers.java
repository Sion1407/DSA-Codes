package Exercises.dsaProblems;

import java.util.*;

//3238 FindNoOfWinPlayers

//
public class FindNoOfWinPlayers {
    public static void main(String[] args) {
        System.out.println(winningPlayerCount(4,new int[][]{{0,7}}));
    }

    public static int winningPlayerCount(int n, int[][] pick) {
        Map<Integer, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < pick.length; i++) {
            if (hm.containsKey(pick[i][0])){
                List<Integer> temp = hm.get(pick[i][0]);
                temp.add(pick[i][1]);
                hm.put(pick[i][0],temp);
            }
            else {
                List<Integer> t = new ArrayList<>();
                t.add(pick[i][1]);
                hm.put(pick[i][0],t);
            }
        }
        int ans = 0;
        for (Map.Entry<Integer,List<Integer>> e : hm.entrySet()){
            int c = 0;
            int [] check = new int[n];
            Collections.sort(e.getValue());
            for (int i = 0; i < e.getValue().size(); i++) {
                check[e.getValue().get(i)]++;
            }
            int max = Arrays.stream(check).max().getAsInt();
            if (max > e.getKey()){
                ans++;
            }
        }
        return ans;
    }
}
