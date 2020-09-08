package patterns.twopointer;

import java.util.ArrayList;
import java.util.List;

public class SubarrayProductLessThanK {
    public static List<List<Integer>> findSubarrays(int[] arr, int target) {

        List<List<Integer>> result = new ArrayList<>();
        int product = 1, left = 0;

        for (int right = 0; right < arr.length; right++) {
            product = product * arr[right];
            while (product >= target && left <arr.length){
                product = product/ arr[left++];
            }
            List<Integer> tempList = new ArrayList<>();
            for (int i = right; i >= left ; i--) {
                tempList.add(0, arr[i]);
                result.add(new ArrayList<>(tempList));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));

    }
}
