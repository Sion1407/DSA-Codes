package Exercises.dsaProblems;

public class SmallestDivDigitProd1 {
    public static void main(String[] args) {
        System.out.println(smallestNumber(10,2));
    }
    public static int smallestNumber(int n, int t) {
        for(int i =n;i<n+10; i++){
            String a = String.valueOf(i);
            int j = 0;
            int product = 1;
            while(j<a.length()){
                product*= a.charAt(j)-'0';
                // if(product==0) return 0;
                if(product%t == 0)
                    return product;
                j++;
            }
        }
        return n;

    }
}
