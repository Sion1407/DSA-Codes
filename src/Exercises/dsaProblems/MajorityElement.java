package Exercises.dsaProblems;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int []{3,3,4}));
    }
    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int max = 0;
        for(Map.Entry<Integer,Integer> entry: hm.entrySet()){
            if(entry.getValue()> nums.length/2){
                max = entry.getKey();
            }
        }
        return max;
    }
}
