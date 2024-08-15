package Exercises.dsaProblems;

public class Add2BinaryNumbers {
    public static void main(String[] args) {
        System.out.println(addBinary("1111","1111"));
    }
    public static String addBinary(String a, String b) {
        int carry = 0,i=a.length()-1,j=b.length()-1;
        String res = "",nstr = "";
        while (i>=0 && j>=0){
            if (a.charAt(i)=='1' && b.charAt(j)=='1'){
                if (carry==1){
                    res+="1";
                    carry =1;
                }
                else {
                    res += "0";
                    carry = 1;
                }
            } else if (a.charAt(i)=='1' && b.charAt(j)=='0') {
                if (carry==1){
                    res+="0";
                }
                else {
                    res+="1";
                }
            } else if (a.charAt(i)=='0' && b.charAt(j)=='0') {
                if (carry==1){
                    carry =0 ;
                    res+="1";
                }
                else {
                    res+="0";
                }
            }
            else {
                if (carry==1){
                    res+="0";
                }
                else {
                    res+="1";
                }
            }
            i--;j--;
        }

        while (i>=0){
            if (a.charAt(i)=='0'){
                if (carry==1){
                    res+="1";
                    carry= 0;
                }
                else{
                    res+="0";
                }
            }
            else{
                if (carry==1){
                    res+="0";
                }
                else {
                    res+="1";
                }
            }
            i--;
        }
        while (j>=0){
            if (b.charAt(j)=='0'){
                if (carry==1){
                    res+="1";
                    carry= 0;
                }
                else{
                    res+="0";
                }
            }
            else{
                if (carry==1){
                    res+="0";
                }
                else {
                    res+="1";
                }
            }
            j--;
        }
        if (carry==1){
            res+="1";
        }
        char ch;
        for (int k=0; k<res.length(); k++)
        {
            ch= res.charAt(k);
            nstr= ch+nstr;
        }
        return nstr;
    }
}
