package Exercises.dsaProblems;

public class FindSecondLargesValueInArray {
    public static void main(String[] args) {

        int maxI = Integer.MIN_VALUE;
        int secMaxI = Integer.MIN_VALUE;
        int[] ar = new int[] {-9,-1,0,-2,-4,-55,0};

        
//        for (int i = 0; i < ar.length; i++) {
//            if (ar[i] >= maxI) {
//                secMaxI = maxI;
//                maxI = ar[i];
//            }
//            else if (ar[i] > secMaxI && ar[i]  != maxI){
//                secMaxI = ar[i];
//            }
//        }
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] > maxI) {
                secMaxI = maxI;
                maxI = ar[i];
            } else if (ar[i] > secMaxI && ar[i] != maxI) {
                secMaxI = ar[i];
            }
        }
        
        System.out.println(secMaxI);
    }
}
