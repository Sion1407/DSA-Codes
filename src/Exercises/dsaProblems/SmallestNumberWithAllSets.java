package Exercises.dsaProblems;

public class SmallestNumberWithAllSets {
    public static void main(String[] args) {
        System.out.println(smallestNumber(5));
    }
    public static int smallestNumber(int n) {
        String s = Integer.toBinaryString(n);
        char[] a = s.toCharArray();
        for(int i = 0; i < a.length; i++) {
            a[i] = a[i]=='0' ? '1' : '0';
        }
        String neg = new String(a);
        return Integer.parseInt(s,2)|Integer.parseInt(neg,2);
    }
}
