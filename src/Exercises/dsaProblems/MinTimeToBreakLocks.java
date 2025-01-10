package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinTimeToBreakLocks {
    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();

        ls.add(2);ls.add(5);ls.add(4);
        System.out.println(findMinimumTime(ls,2));
    }
    public static int findMinimumTime(List<Integer> strength, int K) {
        Collections.sort(strength);

        // Step 2: Initialize variables
        int x = 1; // Initial factor X
        int res = 0; // Time counter
        int energy = 0; // Current energy of the sword
        int i = 0; // Index to track the current lock

        // Step 3: Loop through all locks
        while (i < strength.size()) {
            if (energy >= strength.get(i)) {
                // Break the lock
                i++; // Move to the next lock
                x += K; // Increase the factor X
                energy = 0; // Reset energy after breaking the lock
            } else {
                // Accumulate energy for the current lock
                energy += x;
            }
            res++; // Increment the time counter for each minute
        }

        return res;
    }
}
