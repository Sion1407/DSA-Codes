package Exercises.dsaProblems.arrays;

public class LabelledLoop {
    public static void main(String[] args) {
        int answer = 0;
        int[] fruits = new int[]{4,2,5};
        int [] baskets = new int[]{3,5,4};
        loop: for(int i=0; i<fruits.length; i++){
            for(int j=0; j<baskets.length; j++){
                if(fruits[i] <= baskets[j]){
                    baskets[j] = 0;
                    continue loop;
                }
            }
            answer++;
        }
        System.out.println(answer);
    }
}
