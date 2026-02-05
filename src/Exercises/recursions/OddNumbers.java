package Exercises.recursions;

public class OddNumbers {
    public static void main(String[] args) {
        helper(100);
    }

    private static void helper(int n) {
        if(n<=0) return;
        if (n%2!=0)
            System.out.println(n);
        helper(n-1);
    }
}
