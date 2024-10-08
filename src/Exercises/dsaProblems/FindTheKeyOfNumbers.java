package Exercises.dsaProblems;

public class FindTheKeyOfNumbers {
    public static void main(String[] args) {
        System.out.println(generateKey(1,10,1000));
    }
    public static int generateKey(int n1, int n2, int n3) {
        String str1 = String.valueOf(n1),str2 = String.valueOf(n2),str3 = String.valueOf(n3),res = "";
        int i = 0;
        while(str1.length()!=4 || str2.length()!=4 || str3.length()!=4){
            if(str1.length()<4)
                str1 = "0"+str1;
            if(str2.length()<4)
                str2 = "0"+str2;
            if(str3.length()<4)
                str3 = "0"+str3;
        }
        while(i!=4) {
            int min2 = Math.min(Character.getNumericValue(str1.charAt(i)),Character.getNumericValue(str2.charAt(i)));
            int temp = Math.min(min2,Character.getNumericValue(str3.charAt(i)));
            res+=String.valueOf(temp);
            i++;
        }
        return Integer.valueOf(res);
    }
}
