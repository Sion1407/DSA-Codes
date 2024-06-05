package Exercises.dsaProblems;

public class ReverseAIntegerMed {
    public static void main(String[] args) {
        System.out.println(reverse(-1534236469));
    }
    public static int reverse(int x) {
        String res = "";
        boolean negative = false;
        if(x<0){
            negative = true;
        }
        x = Math.abs(x);
        String xStr = String.valueOf(x);
        for(int i = xStr.length()-1; i>=0;i--){
            res+=xStr.charAt(i);
        }
        if (negative){
            res = "-"+res;
        }
        System.out.println(res);
        try{
            x = Integer.valueOf(res);
        }
        catch (Exception e){
            return 0;
        }

        return x;
    }
}
