package Exercises.dsaProblems;

//3168. Minimum Number of Chairs in a Waiting Room
//        Easy
//        Companies
//        Hint
//        You are given a string s. Simulate events at each second i:
//
//        If s[i] == 'E', a person enters the waiting room and takes one of the chairs in it.
//        If s[i] == 'L', a person leaves the waiting room, freeing up a chair.
//        Return the minimum number of chairs needed so that a chair is available for every person who enters the waiting room given that it is initially empty.

public class MinimumNoOfChairs {
    public static void main(String[] args) {
        System.out.println(minimumChairs("ELEELEELLL"));
    }

    public static int minimumChairs(String s) {
        int min = 0,totalSeatsReq = 0;
        for (int i = 0; i <s.length();i++){
            if (s.charAt(i)=='L' && min==0){
                return min;
            } else if (s.charAt(i)=='L' && min!=0) {
                min-=1;
            } else if (s.charAt(i)=='E') {
                min+=1;
            }
            totalSeatsReq = Math.max(totalSeatsReq,min);
        }
        return totalSeatsReq;
    }
}
