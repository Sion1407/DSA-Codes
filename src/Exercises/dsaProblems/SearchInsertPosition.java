package Exercises.dsaProblems;

public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        int i = 0;
        while (i<nums.length){
            if (nums[i]==target)
                return i;
            else{
                if (nums[i] > target){
                    return i;
                }
            }
            i++;
        }
        return i;
    }
}
