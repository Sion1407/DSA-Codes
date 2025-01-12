package Exercises.dsaProblems;

public class SplitGame3430 {
    public static void main(String[] args) {
        System.out.println(answerString("bif",2));
    }
    public static String answerString(String word, int n) {
        if(n==1) return word;
        int l = word.length();
        int max = (l-n+1);
        char maxchar = word.charAt(0);
        String res = "";
        for(int i =0; i<l;i++){
            if(word.charAt(i)>=maxchar){
                String curr = word.substring(i,Math.min(i + max,l));
                if(curr.compareTo(res)>0) res = curr;
                maxchar = word.charAt(i);
            }
        }
        return res;
    }

}
