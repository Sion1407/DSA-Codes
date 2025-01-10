package Exercises.dsaProblems;

public class FindSecondLargestNo {
    public static void main(String[] args) {
//        4
        System.out.println(secondLargest(new int[]{1,3,4,2,5,5}));
    }

    public static int secondLargest(int[] nums){
        int curr = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i] ) {
                curr = max;
                max = nums[i];
            }
        }
        return curr;
    }
}
