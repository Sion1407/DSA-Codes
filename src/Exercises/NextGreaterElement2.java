package Exercises;


import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1,2,3,4,3})));
    }
    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int res[] = new int[nums.length];
        Arrays.fill(res,-1);

        for(int i = 0; i < nums.length*2; i++){
            int n = nums[i%nums.length];
            while(!stk.isEmpty() && nums[stk.peek()] < n){
                res[stk.pop()] = n;
            }
            if(i < nums.length){
                stk.push(i);
            }
        }
        return res;
    }
}
