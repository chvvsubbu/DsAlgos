package patterns.twopointer;

import java.util.Arrays;

public class TripletWithSmallerSum {
    public static int searchTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        int count =0;
        for (int i = 0; i < arr.length; i++) {
            count += search(arr, target-arr[i], i);
        }
        return count;
    }

    private static int search(int[] arr, int targetSum, int first) {

        int left = first+1, right = arr.length-1;
        int count = 0;
        while (left < right){
            int currentSum = arr[left] + arr [right];
            if( currentSum < targetSum){
                count += right-left;
                left++;
            }else {
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));

    }

}
