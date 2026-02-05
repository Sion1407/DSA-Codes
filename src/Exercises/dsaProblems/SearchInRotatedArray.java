package Exercises.dsaProblems;

//33

public class SearchInRotatedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{6,7,8,9,1,2,3,4,5},7));
    }

    public static int search(int[] nums, int target) {
        int l = 0, r= nums.length-1;
        while (l <= r){
            int mid = (l+r)/2;
            
            if (nums[mid]==target)
                return mid;
            if (nums[l]<=nums[mid]){
                if (nums[l]<=target && target < nums[mid]) {
                    r = mid-1;
                }
                else {
                    l = mid+1;
                }
            }
            else {
                if (nums[mid] < target && target <=nums[r]){
                    l = mid+1;
                }
                else {
                    r = mid-1;
                }
            }
        }

        return -1;
    }
}
