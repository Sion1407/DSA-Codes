package Exercises.dsaProblems;

import java.util.List;

public class ListPattern {
    public static void main(String[] args) {
        String[] a = new String[]{"I","Love","Coding"};
//           0 1 2 3 4 5
//        0 [0,0,0,0,0,I]
//        1 [0,0,L,O,V,E]
//        2 [C,O,D,I,N,G]
//        j = 2, i = 1,a.len = 4,max = 6  -- i want 0
//        j = 3,                            -- i want 1
//        j = 4                               2
        System.out.println(List.of(1,2,3));
        int maxLen = 0;
        for (int i = 0; i < a.length; i++) {
            maxLen = Math.max(maxLen, a[i].length());
        }
        char m[][] = new char[a.length][maxLen];
        for (int i = 0; i < m.length; i++) {
            for (int j = maxLen - a[i].length(); j < maxLen; j++) {
                m[i][j] = a[i].charAt(j-(maxLen- a[i].length()));
            }
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < maxLen; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
}
