package Exercises.dsaProblems;

//You are given an array nums consisting of positive integers where all integers have the same number of digits.
//
//        The digit difference between two integers is the count of different digits that are in the same position in the two integers.
//
//        Return the sum of the digit differences between all pairs of integers in nums.
//
//
//
//        Example 1:
//
//        Input: nums = [13,23,12]
//
//        Output: 4
//
//        Explanation:
//        We have the following:
//        - The digit difference between 13 and 23 is 1.
//        - The digit difference between 13 and 12 is 1.
//        - The digit difference between 23 and 12 is 2.


public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(new int[]{50,28,48}));
    }

    public static int sumOfDigits(int[] nums){
        int sum = 0;
        for (int i =0;i< nums.length-1;i++){
            for (int j = i+1;j< nums.length; j++){
                int num1 = nums[i];
                int num2 = nums[j];
                while (num1 > 0 && num2 > 0) {
                    int remainder1 = num1 % 10;int remainder2 = num2 % 10;
//                    sum+= remainder1 > remainder2 ? remainder1-remainder2 : remainder2-remainder1;
                    if (remainder1 != remainder2)
                        sum++;
                    num1 = num1 / 10; num2 = num2 / 10;
                }

            }
        }
        return sum;
    }
}
