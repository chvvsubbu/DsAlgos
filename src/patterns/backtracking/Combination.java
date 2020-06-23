package patterns.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    public static List<List<Integer>> combine(int n, int k){

        List<List<Integer>> result = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i+1;
        }
        backtrack(result, new ArrayList<Integer>(), nums, k,0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int count, int start) {

        if(count ==0){
            result.add(new ArrayList<>(tempList));
        }else{
            for(int i = start ; i < nums.length; i++ ){
                if(tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtrack(result, tempList, nums, count-1, i);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Combination.combine(4,2);
        System.out.print("Here are all the permutations: " + result);
    }
}
