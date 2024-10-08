package Exercises.dsaProblems;

//3309
public class MaxPossConcat {
        public static void main(String[] args) {
            System.out.println(maxGoodNumber(new int[]{1, 2, 3}));
        }

        public static int maxGoodNumber(int[] nums) {
            return permute(nums, 0, 0);  // Start with max = 0
        }

        public static int permute(int[] arr, int index, int max) {
            if (index == arr.length - 1) {
                StringBuilder temp = new StringBuilder();
                for (int i : arr) {
                    temp.append(Integer.toBinaryString(i));  // Concatenate binary strings
                }
                int currentValue = Integer.parseInt(temp.toString(), 2);  // Convert to decimal
                return Math.max(currentValue, max);  // Return the maximum of current and previous max
            }

            for (int i = index; i < arr.length; i++) {
                swap(arr, i, index);
                max = permute(arr, index + 1, max);  // Keep updating the max
                swap(arr, i, index);  // Backtrack
            }

            return max;  // Return the final max value after all permutations
        }

        public static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }


}
