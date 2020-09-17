package patterns.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {
    public static List<List<Integer>> searchTriplets (int[] arr) {
        Arrays.sort(arr);
        List<List<Integer> > tripplets = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(i >0 && arr[i] == arr[i-1])
                continue;
            search(arr, -arr[i], i+1, tripplets);
        }
        return tripplets;
    }

    private static void search(int[] arr, int targetSum, int left, List<List<Integer>> tripplets) {

        int right = arr.length-1;
        while (left < right) {
            int currentSum = arr[left]+ arr[right];
            if( currentSum == targetSum){
                tripplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left ++;
                right--;
                while (left<right && arr[left] == arr[left-1]){
                    left++;
                }
                while (left<right && arr[right] == arr[right+1]){
                    right--;
                }
            }else if(targetSum > currentSum){
                left++;
            }else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }
}
