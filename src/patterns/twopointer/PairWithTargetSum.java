package patterns.twopointer;

import java.util.HashMap;
import java.util.Map;

public class PairWithTargetSum {
    public static int[] search(int[] arr, int targetSum) {
        int left = 0, right = arr.length-1;
        while (left < right){
            int currentSum = arr[left] + arr[right];
            if(currentSum == targetSum){
                return  new int[]{left, right};
            }

            if(targetSum > currentSum)
                left = left+1;
            else right = right -1;
        }
        return new int[]{-1,-1};
    }
    public static int[] hashMapSearch(int[] arr, int targetSum) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(hashMap.containsKey(targetSum-arr[i])){
                return new int[] { hashMap.get(targetSum - arr[i]) , i};
            }
            hashMap.put(arr[i], i);
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] result = PairWithTargetSum.hashMapSearch(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.hashMapSearch(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");

    }
}
