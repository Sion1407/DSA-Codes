package Exercises.dsaProblems;

public class GenerateSubStrings {
    static String in = "";
    static int ans = 0;
    public static void main(String[] args) {
        in = "10101";
        substrings(0,1,1);
        System.out.println(ans);
    }

    static void substrings(int start, int end, int k){
        if(start == in.length() && end == in.length()){
            return;
        }else{
            if(end == in.length()+1){
                substrings(start+1,start+1,k);
            }else{
//                System.out.println(in.substring(start, end));
                String temp = in.substring(start, end);
                int cnt1 = 0, cnt0 = 0;
                if (!temp.isEmpty()){
                    for (int i = 0; i < temp.length(); i++) {
                        if (temp.charAt(i)=='0') cnt0++;
                        if (temp.charAt(i)=='1') cnt1++;
                    }
                    if (cnt0<=k || cnt1<=k){
                        ans++;
                    }
                }
                substrings(start, end+1,k);
            }
        }
    }
}
