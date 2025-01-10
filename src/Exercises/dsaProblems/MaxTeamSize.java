package Exercises.dsaProblems;

import java.util.HashMap;
import java.util.TreeSet;



import java.util.HashMap;

public class MaxTeamSize {
    public static int maxTeamSize(int[] skills) {
        // Frequency map to count occurrences of each skill level
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int skill : skills) {
            freqMap.put(skill, freqMap.getOrDefault(skill, 0) + 1);
        }

        int maxTeamSize = 0;

        // Iterate through skill levels in the frequency map
        for (int skill : freqMap.keySet()) {
            // Calculate team size for the current skill and its consecutive level
            int currentTeamSize = freqMap.get(skill);
            if (freqMap.containsKey(skill + 1)) {
                currentTeamSize += freqMap.get(skill + 1);
            }
            maxTeamSize = Math.max(maxTeamSize, currentTeamSize);
        }

        return maxTeamSize;
    }

    public static void main(String[] args) {
        int[] skills = {10, 12, 13, 9, 14};
        System.out.println("Maximum Team Size: " + maxTeamSize(skills)); // Should print 3
    }
}



