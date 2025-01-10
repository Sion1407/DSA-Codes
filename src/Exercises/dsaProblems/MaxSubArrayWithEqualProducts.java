package Exercises.dsaProblems;

public class MaxSubArrayWithEqualProducts {
    public static void main(String[] args) {
        System.out.println(maxLength(new int[]{1,2,1,2,1,1,1}));
    }

    public static int maxLength(int[] nums) {
        int max = 0;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            long gcdVal = nums[i], lcmVal = nums[i],prod = nums[i];
            for (int j = i+1; j < length; j++) {
                prod = prod*(long) nums[j];
                if(prod > 100000000000L) break;
                gcdVal= gcd(gcdVal, nums[j]);
                lcmVal = lcm(lcmVal,nums[j]);
                if (prod==gcdVal * lcmVal){
                    max = Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }

    private static long gcd(long a,long b){
        if (b==0)
            return a;
        return gcd(b,a%b);
    }
    private static long lcm(long a,long b){
        return (a*b)/gcd(a,b);
    }
}
