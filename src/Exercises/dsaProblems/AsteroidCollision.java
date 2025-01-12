package Exercises.dsaProblems;

import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] res = asteroidCollision(new int[]{-2, -1, 1, 2});
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            if (a > 0) {
                stack.push(a);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -a) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(a);
                }

                if (stack.peek() == -a) {
                    stack.pop();
                }
            }
        }

        int[] res = new int[stack.size()];
        int i = stack.size() - 1;

        while (!stack.isEmpty()) {
            res[i--] = stack.pop();
        }

        return res;
    }
}
