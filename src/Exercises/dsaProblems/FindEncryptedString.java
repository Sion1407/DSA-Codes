package Exercises.dsaProblems;
//3210
public class FindEncryptedString {
    public static void main(String[] args) {
        System.out.println(getEncryptedString("byd",4));
    }

    public static String getEncryptedString(String s, int k) {
        String temp = "";
        for(int i =0;i<s.length();i++){
            if((i+k)<s.length()){
                temp += s.charAt(i+k);
            }
            else{
                int varTemp = 0;
                varTemp = (i+k)-s.length();
                while (varTemp>=s.length()){
                    varTemp = varTemp-s.length();
                }
                temp += s.charAt(varTemp);
            }
        }
        return temp;
    }
}
