package Exercises.dsaProblems;

public class ShiftDistanceBetweenTwoStrings {
    public static void main(String[] args) {
        System.out.println(shiftDistance("leet","code",new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
    }
    public static long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
//        int res = 0;
//        char[] c = s.toCharArray();
//        for (int i = 0; i < c.length; i++) {
//            int n = 0, p = 0;
//            char temp = c[i];
//            while(temp!=t.charAt(i)){
//                if (temp=='z') {
//                    n+=nextCost['z'-'a'];
//                    temp = 'a';
//                }
//                else{
//                    n+=nextCost[temp-'a'];
//                    temp+=1;
//                }
//            }
//            temp = c[i];
//            while(temp!=t.charAt(i)){
//                if (temp=='a') {
//                    p+=previousCost[0];
//                    temp = 'z';
//                }
//                else{
//                    p+=previousCost[temp-'a'];
//                    temp-=1;
//                }
//            }
//            res+=Math.min(n,p);
//        }
//        return res;
//prefix sum
        int n = s.length();
        long[] next = new long[26];
        long[] prev = new long[26];

        for (int i = 0; i < 26; i++) {
            next[i] = nextCost[i];
            prev[i] = previousCost[i];
        }

        // Calculate cumulative costs for next and previous
        for (int i = 1; i < 26; i++) {
            next[i] += next[i - 1];
        }
        for (int i = 24; i >= 0; i--) {
            prev[i] += prev[i + 1];
        }

        long cost = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) != t.charAt(i)){
                int start = s.charAt(i) - 'a', end = t.charAt(i) - 'a';

                if(start < end){ // case 1
                    long forwardCost = next[end - 1] - (start > 0 ? next[start - 1] : 0);
                    long backwardCost = prev[0] - (start + 1 < 26 ? prev[start + 1] : 0) + (end == 25 ? 0 : prev[end +1]);
                    cost += Math.min(forwardCost, backwardCost);
                }
                else{ // case 2
                    long backwardCost = prev[end + 1] - (start >= 25 ? 0 : prev[start + 1]);
                    long forwardCost = next[25] - next[start - 1] + (end != 0 ? next[end - 1] : 0);
                    cost += Math.min(forwardCost, backwardCost);
                }
            }
        }

        return cost;
    }
}
