package Exercises.dsaProblems;

public class ButtonWithLongestPush {
    public static void main(String[] args) {
        System.out.println(buttonWithLongestTime(new int[][]{{5,4},{20,14}}));
    }

    public static int buttonWithLongestTime(int[][] events) {
        int longTimeIdx = events[0][0],prevTime = events[0][1],max = events[0][1];
        for (int i = 1; i < events.length; i++) {
            int time = events[i][1];
            if (max < Math.abs(prevTime - time)){
                max = Math.abs(prevTime - time);
                longTimeIdx = events[i][0];
            }
            if (max==Math.abs(prevTime - time))
                longTimeIdx = Math.min(events[i][0],longTimeIdx);
            prevTime = time;
        }
        return longTimeIdx;
    }
}
