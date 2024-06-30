package Exercises.dsaProblems;
//38. Count and Say
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
    public static String countAndSay(int n) {
        if (n==1) return "1";
        if (n==2) return "11";
        String res = "11";
        int count = 0;
        for (int i = 0; i < n-2; i++) {
            String temp = "";
            count = 1;
            res+="$";
            int j = 1;
//            int l = 0;
            while (j<res.length()){
                if (res.charAt(j)!=res.charAt(j-1)){
                    temp+=String.valueOf(count);
                    temp+=res.charAt(j-1);
                    count=1;
                }
                else count++;
                j++;
            }
            res = temp;
        }
        return res;
    }
}
