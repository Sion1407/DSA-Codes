package Exercises.Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int [] a = new int[]{2,1,3,4,0};
        for (int i = 0; i < a.length; i++) {
            int j = i-1;
            int temp = a[i];
            while (j>-1 && a[j]> temp){
                a[j+1] = a[j];
                a[j] = temp;
                j--;
            }

        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
