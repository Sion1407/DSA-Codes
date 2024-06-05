package Exercises.dsaProblems;

//An array is considered special if every pair of its adjacent elements contains two numbers with different parity.
//parity means 1 is even and other should be odd
//
//        You are given an array of integers nums. Return true if nums is a special array, otherwise, return false.
//        Example 1:
//        Input: nums = [1]
//        Output: true
//        Explanation:
//        There is only one element. So the answer is true.
//
//        Example 2:
//        Input: nums = [2,1,4]
//        Output: true
//        Explanation:
//        There is only two pairs: (2,1) and (1,4), and both of them contain numbers with different parity. So the answer is true.

//        Example 3:
//        Input: nums = [4,3,1,6]
//        Output: false
//
//        Explanation:
//        nums[1] and nums[2] are both odd. So the answer is false.


public class SpeacialArray1Parity {
    public static void main(String[] args) {
        System.out.println(isArraySpecial(new int[]{1,2,3}));
    }
    public static boolean isArraySpecial(int[] nums) {
        if(nums.length==1) return true;
        if (nums[0]%2==0)
        {
            for (int i=1;i< nums.length;i++){
                if (i%2==0 && nums[i]%2!=0)
                    return false;
                if (i%2!=0 && nums[i]%2==0)
                    return false;
            }
        }
        if (nums[0]%2!=0){
            for (int i=1;i< nums.length;i++){
                if (i%2!=0 && nums[i]%2!=0)
                    return false;
                if (i%2==0 && nums[i]%2==0)
                    return false;
            }
        }
        return true;

    }

}
