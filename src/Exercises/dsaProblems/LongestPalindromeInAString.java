package Exercises.dsaProblems;

//Given a string s, return the longest
//        palindromic
//
//        substring
//        in s.
//
//
//
//        Example 1:
//
//        Input: s = "babad"
//        Output: "bab"
//        Explanation: "aba" is also a valid answer.
//        Example 2:
//
//        Input: s = "cbbd"
//        Output: "bb"


public class LongestPalindromeInAString {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    static String longestPalindrome(String s) {
//        Hashtable<Integer,Integer> ht = new Hashtable<>();
        int resLen = 0;
        String palRes = "";
//        List<Integer> t = new ArrayList<>(Arrays.asList(1,2,3));
//        t.remove(2);
//        System.out.println(t);
        for (int i=1; i<s.length();i++){
            int left = i;
            int right = i;

            while (s.charAt(left)== s.charAt(right)){
                left--;
                right++;

                if (left==-1 || right == s.length())
                    break;
            }

            String tempStr = s.substring(left+1,right);
            if (resLen < tempStr.length()){
                palRes = tempStr;
                resLen = tempStr.length();
            }

//            for even palindromes
            left = i-1;
            right = i;
            while (s.charAt(left)== s.charAt(right)){
                left--;
                right++;

                if (left==-1 || right == s.length())
                    break;
            }

            tempStr = s.substring(left+1,right);
            if (resLen < tempStr.length()){
                resLen = tempStr.length();
                palRes = tempStr;
            }


        }
        return palRes;
    }

    //        for (int i=0;i<s.length();i++){
//            String tempStr = "";
//            for (int j=i;j<s.length();j++){
//                 tempStr += s.charAt(j);
//                if (checkPalindrome(tempStr) && resLen < tempStr.length()){
//                    resLen = tempStr.length();
//                    palRes = tempStr;
//                }
//            }
//        }
//        }
    static boolean checkPalindrome(String str){
        String nstr=""; char ch;
        for (int i=0; i<str.length(); i++)
        {
            ch= str.charAt(i);
            nstr= ch+nstr;
        }
        return str.equals(nstr);
    }
}
