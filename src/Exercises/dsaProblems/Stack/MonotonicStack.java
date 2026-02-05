package Exercises.dsaProblems.Stack;

import java.util.Stack;

public class MonotonicStack {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};
        Stack<Integer> increasingStack = new Stack<>();

        for (int num : arr) {
            while (!increasingStack.isEmpty() && increasingStack.peek() > num) {
                increasingStack.pop();
            }
            increasingStack.push(num);
        }

        System.out.println("Monotonic Increasing Stack: " + increasingStack);
    }
}
