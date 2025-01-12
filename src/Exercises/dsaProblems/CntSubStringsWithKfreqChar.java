package Exercises.dsaProblems;

public class CntSubStringsWithKfreqChar {
    static int ans = 0;
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abacb",2));
    }
    public static int numberOfSubstrings(String s, int k) {
        int ans = 0;
        int[] cnt = new int[26];  // Array to count character frequencies
        int n = s.length();

        for (int start = 0, end = 0; end < n; end++) {
            // Include the current character in the window
            cnt[s.charAt(end) - 'a']++;

            // Check if the window contains at least 'k' occurrences of any character
            while (isValid(cnt, k)) {
                // Since the substring from 'start' to 'end' is valid, all substrings
                // starting from 'start' to 'end' and ending anywhere between 'end' to 'n'
                // are also valid
                ans += (n - end);

                // Shrink the window from the left
                cnt[s.charAt(start) - 'a']--;
                start++;
            }
        }

        return ans;
    }

    private static boolean isValid(int[] cnt, int k) {
        for (int freq : cnt) {
            if (freq >= k) {
                return true;
            }
        }
        return false;
    }


}
