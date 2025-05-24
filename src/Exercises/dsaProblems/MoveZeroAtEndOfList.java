package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.List;

public class MoveZeroAtEndOfList {
    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>(List.of(1,0,1,0,2,4));

//        1,1,2,4,0,0
//        int cntOfZeros = 0,j=0;
//        for (int i = 0; i < lst.size(); i++) {
//            if (lst.get(i)==0){
//                cntOfZeros++;
////                takes O(n) to remove
//                lst.remove(i);
//            }
//        }
//        while (j < cntOfZeros){
//            lst.add(0);
//            j++;
//        }

//        Optimised 2 pointers
        int j = 0;


        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i) != 0) {
                lst.set(j, lst.get(i));
                j++;
            }
        }
        double s =  (double) 51 /4;
        System.out.println(s);
        // Step 2: Fill the rest of the list with zeroes
        while (j < lst.size()) {
            lst.set(j, 0);
            j++;
        }
        System.out.println(lst);

    }
}
