package Exercises.dsaProblems;

public class FindLargestNumberByCombiningTwoNosInAnArray {
    public static void main(String[] args) {
        int[] a = new int[]{10,12,13,14,5};
////        1413 - op
        int max = Integer.MIN_VALUE;
//        Arrays.sort(a);
//
//        for (int i = 0; i < a.length; i++) {
//            for (int j = i + 1; j < a.length; j++) {
//                String t = String.valueOf(a[i]) + String.valueOf(a[j]);
//                max = Math.max(max, Integer.valueOf(t));
//            }
//        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int t1 = Integer.parseInt("" + a[i] + a[j]);
                int t2 = Integer.parseInt("" + a[j] + a[i]);
                max = Math.max(max, Math.max(t1, t2));
            }
        }
        System.out.println(max);
    }
}
