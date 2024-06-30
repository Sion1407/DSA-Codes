package Exercises.dsaProblems;

//34.

public class FirstAndLastPositionOfTarget {
    public static void main(String[] args) {
        int[] res = searchRange(new int[]{1,1,2},1);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        int l = 0, r= nums.length-1;
        if(nums.length==0) return new int[]{-1,-1};
//        if(nums.length<3){
//            if(nums[0]==target) return new int[]{0,0};
//            else return new int[]{-1,-1};
//        }
        while (l <= r){
            int mid = (l+r)/2;

            if (nums[mid]==target) {
                r = mid;
                l = mid;
                while (r< nums.length && nums[r] == target)
                    r++;
                while (l>= 0 && nums[l] == target)
                    l--;
                return new int[]{l+1, r-1};
            }
            if (nums[l]<=nums[mid]){
                if (nums[l]<=target && target < nums[mid]) {
                    r = mid-1;
                }
                else {
                    l = l+1;
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

        return new int[]{-1,-1};
    }

//    public static int[] searchRange(int[] nums, int target) {
//
//    }
}
