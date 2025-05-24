package Exercises.dsaProblems;

import java.util.Arrays;

public class AssignElementstoGroupswithConstraints {
    public static void main(String[] args) {
        int[] res = assignElements(new int[]{2,3,5,7},new int[]{5,3,3});
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    public static int[] assignElements(int[] groups, int[] elements) {
        int [] res = new int[groups.length];
        Arrays.fill(res,-1);
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < groups.length; j++) {
                if (groups[j] % elements[i]==0 && res[j]==-1){
                    res[j] = i;
                }
            }
        }

        return res;
    }
}
