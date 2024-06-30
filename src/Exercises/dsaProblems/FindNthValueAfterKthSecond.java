package Exercises.dsaProblems;

//3179. Find the N-th Value After K Seconds

public class FindNthValueAfterKthSecond {
    public static void main(String[] args) {
        System.out.println(valueAfterKSeconds(5,1000));
    }

    public static int valueAfterKSeconds(int n, int k) {
        int [] nums = new int[n];
        int sum = 1;
        long M = 1000000007;
        for (int i = 0; i < n; i++) {
            nums[i] = 1;
        }
        int i = 1;
        while (k>0){
            while (i<nums.length){
                sum = (int)((sum+ nums[i])%M);
                nums[i] = sum;
                i++;
            }
            i=1;
            sum=1;
            k--;

        }
        return nums[nums.length-1];
    }
}
