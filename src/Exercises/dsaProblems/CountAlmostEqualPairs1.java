package Exercises.dsaProblems;

public class CountAlmostEqualPairs1 {
    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{3,12,30,17,21}));
    }

    public static int countPairs(int[] nums) {
        int l = 0, r = 0, ans = 0;
        while (l < nums.length) {
            r = l + 1;
            while (r < nums.length) {
                if (nums[l] == nums[r]){
                    ans++;
                }
                else if (nums[l] > nums[r]) {
                    if (checkPair(nums[l], nums[r])) {
                        ans++;
                    }
                } else {
                    if (checkPair(nums[r], nums[l])) {
                        ans++;
                    }
                }
                r++;
            }
            l++;
        }
        return ans;
    }

    private static boolean checkPair(int a, int b) {
        boolean check = false;
        StringBuilder aStr = new StringBuilder(String.valueOf(a));
        for (int j = 0; j < aStr.length(); j++) {
            for (int k = j + 1; k < aStr.length(); k++) {
                char l = aStr.charAt(j), r = aStr.charAt(k);
                aStr.setCharAt(j, r);
                aStr.setCharAt(k, l);
                if (b == Integer.valueOf(aStr.toString())) {
                    check = true;
                    break;
                }
                else{
                    aStr = new StringBuilder(String.valueOf(a));
                }
            }
        }
        return check;
    }
}
