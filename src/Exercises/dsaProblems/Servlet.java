package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.List;

public class Servlet {
        public static void main(String[] args) {
//            int[] a = new int[]{1, 2, 3};
//            List<List<Integer>> res = new ArrayList<>();
//            generatePermutations(a, 0, res);
//            System.out.println(res);
            String s = "abc";
            List<List<String>> res = new ArrayList<>();
            permt(s, 0 , res, new ArrayList<>());

        }
        private static void permt(String str, int s, List<List<String>> res, List<String> t){
            if (s==str.length()){
                res.add(t);
            }
            if (t.size() > 0){
                t.remove(t.size()-1);
                permt(str, s-1, res,t);
            }
            t.add(String.valueOf(str.charAt(s)));
            permt(str,s+1,res,t);

        }
        private static void generatePermutations(int[] a, int start, List<List<Integer>> res) {
            if (start == a.length) {
                List<Integer> current = new ArrayList<>();
                for (int num : a) {
                    current.add(num);
                }
                res.add(current);
            } else {
                for (int i = start; i < a.length; i++) {
                    swap(a, start, i);
                    generatePermutations(a, start + 1, res);
                    swap(a, start, i);
                }
            }
        }

        private static void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

