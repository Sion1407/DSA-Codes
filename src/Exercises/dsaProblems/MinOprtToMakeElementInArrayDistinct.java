package Exercises.dsaProblems;

import java.util.*;

public class MinOprtToMakeElementInArrayDistinct {
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{4,5,6,4,4}));
    }
    public static int minimumOperations(int[] nums) {
//        Stack<Integer> stk = new Stack<>();
//        Map<Integer,Integer> hm = new HashMap<>();
//        for (int i = nums.length-1; i >= 0; i--) {
//            stk.push(nums[i]);
//            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
//        }
//        if (isUnique(hm))
//            return 0;
//        int cnt = 0;
//        while (!stk.isEmpty() && !isUnique(hm)){
//            int temp = stk.pop();
//            hm.put(temp,hm.get(temp)-1);
//            if (!stk.isEmpty()) {
//                temp = stk.pop();
//                hm.put(temp, hm.get(temp) - 1);
//            }
//            else return ++cnt;
//            if (!stk.isEmpty()) {
//                temp = stk.pop();
//                hm.put(temp,hm.get(temp)-1);
//            }
//            else return ++cnt;
//            cnt++;
//        }
//        return cnt;

        Set<Integer> seen = new HashSet<>();

        for (int i = nums.length - 1; i >= 0; --i) {
            if (seen.contains(nums[i]))
                return i / 3 + 1;
            seen.add(nums[i]);
        }

        return 0;
    }

    private static boolean isUnique(Map<Integer,Integer> hm){
        for(Map.Entry<Integer,Integer> entry: hm.entrySet()){
            if (entry.getValue()>1)
                return false;
        }

        return true;
    }
}
