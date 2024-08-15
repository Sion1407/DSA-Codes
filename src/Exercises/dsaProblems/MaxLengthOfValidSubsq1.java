package Exercises.dsaProblems;
//3201
public class MaxLengthOfValidSubsq1 {
    public static void main(String[] args) {
        System.out.println(maximumLength(new int[]{1,2,3,4}));
    }

    public static int maximumLength(int[] nums) {
        int l = 0, even = 0, odd = 0, both =0, parity = nums[0]%2;
        while (l< nums.length){
            if (nums[l] %2 == 0){
                even++;
            }
            else{
                odd++;
            }
            if (nums[l]%2==parity){
                both++;
                parity = 1 - parity;
            }
            l++;
        }
        return Math.max(even,Math.max(odd,both));

    }
}
