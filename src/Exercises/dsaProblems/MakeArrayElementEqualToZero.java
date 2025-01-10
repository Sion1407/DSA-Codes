package Exercises.dsaProblems;

//3354
public class MakeArrayElementEqualToZero {
    public static void main(String[] args) {
        System.out.println(countValidSelections(new int[]{2,3,4,0,4,1,0}));
    }
    public static int countValidSelections(int[] nums) {
        int res = 0,l = 0,r = 0,idx = 0;
        for (int i = 0; i < nums.length; i++) {
            l+=nums[i];
            if (nums[i]==0){
                idx = i;
                break;
            }

        }
        for (int i = idx; i < nums.length; i++) {
            r+=nums[i];
        }

        for (int i = idx; i < nums.length; i++) {
            l+=nums[i];
            r-=nums[i];
            
            if (nums[i]!=0) continue;
            if (l==r) res+=2;
            else if (l-1==r || l+1==r) {
                res+=1;
            }
        }
        return res;
    }
}
