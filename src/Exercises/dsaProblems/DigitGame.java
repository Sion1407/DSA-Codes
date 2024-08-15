package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.List;

//3232
public class DigitGame {
    public static void main(String[] args) {
        System.out.println();
    }
    public static boolean canAliceWin(int[] nums) {
        List<Integer> alice = new ArrayList<>();
        List<Integer> bob = new ArrayList<>();
        int sumA = 0, sumB = 0;
        for(Integer i : nums){
            if(i>9){
                bob.add(i);
            }
            else{
                alice.add(i);
            }
        }
        for (int i = 0; i < alice.size(); i++) {
            sumA+=alice.get(i);
        }
        for (int i = 0; i < bob.size(); i++) {
            sumB+=bob.get(i);
        }
        if (sumA==sumB)
            return false;
        return true;

    }
}
