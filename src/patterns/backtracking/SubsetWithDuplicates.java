package patterns.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDuplicates {

    public static List<List<Integer>> subsetsWithDup(int[] num){

        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(num);
        backtrack(subsets, new ArrayList<>(), num, 0);
        return  subsets;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {

        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
           if(i > start && nums[i] == nums[i-1])
               continue;
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {

        List<List<Integer>>  result = SubsetWithDuplicates.subsetsWithDup(new int[] {1,3,3});
        System.out.println("result: "+ result);
    }



}
