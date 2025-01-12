package Exercises.dsaProblems;

import java.util.List;

public class ConstructMinBitwiseArray2 {
    public static void main(String[] args) {
        int[] res = minBitwiseArray(List.of(2,3,5,7));
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    public static int[] minBitwiseArray(List<Integer> nums) {
        int []res = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            String bin = Integer.toBinaryString(nums.get(i));
            int l = 0;
            char[] binChar = bin.toCharArray();
            int check = -1;
            while (l<binChar.length){
                if (binChar[l] == '1'){
                    binChar[l] = '0';
                    String tmp = new String(binChar);
                    int cand = Integer.valueOf(tmp,2);
                    if ((cand | (cand+1)) == nums.get(i)){
                        check = cand;
                        break;
                    }
                    binChar[l] = '1';
                }
                l++;
            }
            res[i] = check;
        }
        return res;
    }
}
