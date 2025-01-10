package Exercises.dsaProblems;

import java.util.*;

public class LargestNumberByParitySwap {

    public static String largestNumber(String num) {
        // Separate digits into odd and even groups
        List<Character> oddDigits = new ArrayList<>();
        List<Character> evenDigits = new ArrayList<>();

        for (char c : num.toCharArray()) {
            if ((c - '0') % 2 == 0) {
                evenDigits.add(c);
            } else {
                oddDigits.add(c);
            }
        }

        // Sort the digits in descending order
        oddDigits.sort(Collections.reverseOrder());
        evenDigits.sort(Collections.reverseOrder());

        // Reconstruct the number based on parity
        StringBuilder result = new StringBuilder();
        int oddIndex = 0, evenIndex = 0;

        for (char c : num.toCharArray()) {
            if ((c - '0') % 2 == 0) {
                result.append(evenDigits.get(evenIndex++));
            } else {
                result.append(oddDigits.get(oddIndex++));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String num = "0082663";
        System.out.println("Largest number: " + largestNumber(num));
    }
}

