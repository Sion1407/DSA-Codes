package Exercises.dsaProblems;

//Sample Input 0
//
//        B
//        5
//        A 2 B 1
//        A 7 D 2
//        B 5 D 13
//        B 3 B 1
//        A 12 C 12
//        Sample Output 0
//
//        Player 2 wins
//        Player 1 wins
//        Player 1 wins
//        Player 1 wins
//        Draw
//        Explanation 0
//
//        The winning suit is  and there are 5 rounds of the game.
//
//        In the first round, Player 2 drew a winning suit card and Player 1 did not, therefore, Player 2 wins.
//
//        In the second round, none of the players drew a winning suit card, so the numbers on the cards decide. Since Player 1 drew a card with a greater number than Player 2, Player 1 wins.
//
//        In the third round, Player 1 drew a winning suit card and Player 2 did not, therefore, Player 1 wins.
//
//        In the fourth round, both players drew a winning suit cards, so the numbers on the cards decide. Since Player 1 drew a card with a greater number than Player 2, Player 1 wins.
//
//        In the fifth round, none of the players drew a winning suit card, so the numbers on the cards decide. Since both players drew cards with the same numbers, the round results in a Draw.

public class DetermineTheWinner {
    public static void main(String[] args) {
        System.out.println(getRoundResult('B','A',2,'B',1));
    }


    public static String getRoundResult(char winning_suit, char suit1, int number1, char suit2, int number2) {
        // Write your code here
        if (winning_suit == suit1 && winning_suit == suit2)
            return number1>number2 ? "Player 1 wins": "Player 2 wins";
        else if (winning_suit == suit1)
            return "Player 1 wins";
        else if (winning_suit == suit2)
            return "Player 2 wins";
        else{
            if (number1==number2) return "Draw";
            return number1>number2 ? "Player 1 wins": "Player 2 wins";
        }
    }
}

