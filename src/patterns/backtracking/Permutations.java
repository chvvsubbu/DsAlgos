package patterns.backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTrackUnique(result, new ArrayList<>(), nums);

        return result;
     }

    private static void backTrackUnique(List<List<Integer>> result, List<Integer> tempList, int[] nums ) {

        if(tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList));
        }
        for (int i = 0; i < nums.length ; i++) {
            //if(tempList.contains(nums[i]) ) continue;
            if( i > 0  && (nums[i] == nums[i-1])  ) continue;

            tempList.add(nums[i]);
            backTrack(result, tempList, nums);
            tempList.remove(tempList.size()-1);
        }

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), nums);
        return result;
    }

    public static void backTrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {

        if(tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList));
        }
        for (int i = 0; i < nums.length ; i++) {

            if(tempList.contains(nums[i]) ) continue;

            tempList.add(nums[i]);
            backTrack(result, tempList, nums);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations. permuteUnique(new int[] { 1, 1 });
        System.out.print("Here are all the permutations: " + result);

    }

}
