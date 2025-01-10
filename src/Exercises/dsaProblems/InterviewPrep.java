package Exercises.dsaProblems;

public class InterviewPrep {
    public static void main(String[] args) {
//        fib,palin,
        int sum = 0, nxt = 1, init = 0;

        for (int i = 0; i < 8; i++) {
            System.out.println(init + " ");
            sum = init + nxt;
            init = nxt;
            nxt = sum;
        }
    }
}
