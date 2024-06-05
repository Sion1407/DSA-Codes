package Exercises.dsaProblems;

//3169. Count Days Without Meetings
//        Medium
//        Companies
//        Hint
//        You are given a positive integer days representing the total number of days an employee is available for work (starting from day 1). You are also given a 2D array meetings of size n where, meetings[i] = [start_i, end_i] represents the starting and ending days of meeting i (inclusive).
//
//        Return the count of days when the employee is available for work but no meetings are scheduled.
//
//        Note: The meetings may overlap.
//
//
//
//        Example 1:
//
//        Input: days = 10, meetings = [[5,7],[1,3],[9,10]]
//
//        Output: 2
//
//        Explanation:
//
//        There is no meeting scheduled on the 4th and 8th days.


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CountDaysOfMeeting {
    public static void main(String[] args) {
        int[][] array = new int[][]{{2,4},{1,3}};
        System.out.println(countDays(10,array));
    }
    public static int countDays(int days, int[][] meetings) {
        Map<Integer,Boolean> hm = new HashMap<>();
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < meetings.length;i++){
            System.out.println(meetings[i][0]+ " "+meetings[i][1]);
        }
        int count = 0;
        for (int i = 1; i < days+1;i++){
            hm.put(i,false);
        }
        for (int i = 0; i < meetings.length;i++){
            for (int j = meetings[i][0];j<=meetings[i][1];j++){
                hm.put(j,true);
            }
        }
        for (Map.Entry<Integer,Boolean> entry: hm.entrySet()){
            if (entry.getValue().equals(false))
                count++;
        }
        return count;

//        Optimised
//        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
//        int end = meetings[0][1], noMeetingDays = meetings[0][0] - 1;
//        for (int i = 1; i < meetings.length; i++) {
//            if (end < meetings[i][0])
//                noMeetingDays += meetings[i][0] - end - 1;
//            end = Math.max(end, meetings[i][1]);
//        }
//        return noMeetingDays + days - end;

    }
}
