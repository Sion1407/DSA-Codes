package Exercises.dsaProblems;

public class AdditionWithoutUsingPlusOpt {
    public static void main(String[] args) {
        int a = 2,b = 3;
        while (b!=0) {
            int c = a & b; //for carry
            a = a ^ b; //performing addition without carry
            b = c << 1; //Shift carry by 1 to add it in the next bit position
        }
        System.out.println(a);
    }
}
