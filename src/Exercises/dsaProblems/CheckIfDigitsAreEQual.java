package Exercises.dsaProblems;

public class CheckIfDigitsAreEQual {
    public static void main(String[] args) {
        System.out.println(hasSameDigits("3902"));
    }
    public static boolean hasSameDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (s.length()>2){
            for (int i = 0; i < s.length()-1; i++) {
                int t = s.charAt(i)-'0';
                int t2 = s.charAt(i+1)-'0';
                t = (t+t2)%10;
                sb.replace(i,i+2,String.valueOf(t));
            }
            s = sb.toString();
        }
        return s.charAt(0)==s.charAt(1) ? true: false;
    }
}
