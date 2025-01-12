package Exercises.dsaProblems;
//1991
public class FindMiddleIndex {
    public static void main(String[] args) {
        System.out.println(findMiddleIndex(new int[]{2,3,-1,8,4}));
    }
    public static int findMiddleIndex(int[] nums) {
        int l =0,r=0;
        for(int i = 0;i<nums.length;i++){
            r+=nums[i];
        }
        for(int i = 0;i<nums.length;i++){
            r-=nums[i];
            if(l==r)
                return i;
            l+=nums[i];
        }
        return -1;
    }
}
