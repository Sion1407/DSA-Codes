package Exercises.dsaProblems;

public class FloorInASortedArray {
    public static void main(String[] args) {
        System.out.println(findFloor(new int[]{1, 2, 8, 10, 11, 12, 19},5));
    }

    static int findFloor(int[] arr, int k) {
        // write code here
        int l=0,r = arr.length-1,min = -1;
        while(l<=r){
            int mid = l + (r - l) / 2;
            if (arr[mid]==k)
                return mid;
            else if (arr[mid]<k){
                min = mid;
                l = mid+1;
            }
            else {
                r = mid-1;
            }
        }
        return min;
    }
}
