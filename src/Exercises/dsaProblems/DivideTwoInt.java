package Exercises.dsaProblems;
//29
public class DivideTwoInt {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648,-1));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend<0){
            try{
                if (divisor<0) {
                    int res = -1 * (dividend / divisor);
                    return res;
                }
                int res = -(dividend / divisor);
                return res;
            }
            catch (Exception e){
                return Integer.MIN_VALUE;
            }
        }
        else {
            try{
                int res = dividend/divisor;
                return res;
            }
            catch (Exception e){
                return Integer.MAX_VALUE;
            }
        }
    }
}
