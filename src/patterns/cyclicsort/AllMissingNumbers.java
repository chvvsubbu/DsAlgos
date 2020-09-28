package patterns.cyclicsort;

import java.util.ArrayList;
import java.util.List;

import static patterns.heaps.HeapSort.swap;

public class AllMissingNumbers {
    public static List<Integer>  findNumbers(int[] nums){
        int i = 0;
        while (i< nums.length){
            int j = nums[i] - 1;
            if (nums[i] != nums[j]){
                swap(nums, i, nums[i]-1);
            }else {
                i++;
            }
        }

        List<Integer> missingNumbers = new ArrayList<>();
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                missingNumbers.add(i + 1);

        return missingNumbers;

    }

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        List<Integer> missing = AllMissingNumbers.findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
        System.out.println("Missing numbers: " + missing);

        missing = AllMissingNumbers.findNumbers(new int[] { 2, 4, 1, 2 });
        System.out.println("Missing numbers: " + missing);

        missing = AllMissingNumbers.findNumbers(new int[] { 2, 3, 2, 1 });
        System.out.println("Missing numbers: " + missing);


    }

}
