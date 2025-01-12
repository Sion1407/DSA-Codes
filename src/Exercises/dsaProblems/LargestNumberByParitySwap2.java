package Exercises.dsaProblems;

import java.util.*;

public class LargestNumberByParitySwap2 {
    public static String getLargestNumber(String num) {
        // Separate the digits based on their parity
        List<Character> oddDigits = new ArrayList<>();
        List<Character> evenDigits = new ArrayList<>();

        for (char c : num.toCharArray()) {
            if ((c - '0') % 2 == 0) {
                evenDigits.add(c);
            } else {
                oddDigits.add(c);
            }
        }

        // Sort odd and even digits in descending order
        oddDigits.sort(Collections.reverseOrder());
        evenDigits.sort(Collections.reverseOrder());

        // Reconstruct the number
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
        String num = "1806579";
        System.out.println("Largest number: " + getLargestNumber(num));

        // Additional test case
        num = "0282808268842004601739995195335793591517197915151359133579313355773753733395573337195353318028080668046824622222480026440640424868626262888264086408448860224288606068086842682064999153379775193539339377151579931593331464644046617775597111173660426280044286866604006020682862424062262020080004206480086666840462648602248208684086422680620044862288042006402488228244442888086060339517573993737199591935371179399119355917131751579920824020600824068660264440080886486824622802088446668973137793735";
        System.out.println("Largest number: " + getLargestNumber(num));
    }
}
