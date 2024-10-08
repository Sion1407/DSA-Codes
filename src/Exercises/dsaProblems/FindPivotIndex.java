package Exercises.dsaProblems;

public class FindPivotIndex {
//    724. Find Pivot Index
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
    }
    public static int pivotIndex(int[] nums) {
        int l = 0,total = 0,lt = 0,rt = 0;
        while(l< nums.length) {
            total+=nums[l];
            l++;
        }
        l = 0;
        while (l< nums.length){
            rt = total-lt- nums[l];
            if (lt==rt)
                return l;
            lt+=nums[l];
            l++;
        }
        return -1;
    }
}
