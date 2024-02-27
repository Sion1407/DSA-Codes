package Exercises.stack;

public class Main {
    public static void main(String[] args) {
        Stack stack1 = new Stack(1);
        stack1.printStack();

        System.out.println("Pusing an element at top in stack");
        stack1.push(2);
        stack1.printStack();

        System.out.println("popping an element from stack");
        stack1.pop();
        stack1.printStack();
    }
}
