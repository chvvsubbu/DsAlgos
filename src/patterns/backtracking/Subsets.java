package patterns.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public static List<List<Integer>> findSubsets(int[] nums) {

        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(subsets, new ArrayList<>(), nums, 0);
        return  subsets;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {

        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {

        List<List<Integer>>  result = Subsets.findSubsets(new int[] {1,3,5});
        System.out.println("Here is the list of all subsets: " + result);

/*         result = Subsets.findSubsets(new int[] {1,5,3});
        System.out.println("Here is the list of all subsets: " + result);*/
    }

}
