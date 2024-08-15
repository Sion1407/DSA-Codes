package Exercises.dsaProblems;

public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(multiply("123","456"));
    }

    public static String multiply(String num1, String num2) {
        StringBuilder temp = new StringBuilder("");
        int [] mulSum = new int[num1.length()+num2.length()];
        String res="";
        int carry = 0;
        for (int i = num2.length()-1; i >=0 ; i--) {
            for (int j =num1.length()-1;j>=0;j--){
                temp.append(Character.getNumericValue(num1.charAt(j)) * Character.getNumericValue(num2.charAt(i)));
                if (temp.length()>1){
                    mulSum[i+j] += Character.getNumericValue(temp.charAt(0));
                    temp.deleteCharAt(0);
                }
                mulSum[i+j+1] += Character.getNumericValue(temp.charAt(0));
                temp.deleteCharAt(0);
            }
        }
        for (int i = 0; i < mulSum.length; i++) {
            if (mulSum[i]!=0)
                res+=String.valueOf(mulSum[i]);
        }
        return res;
    }
}
