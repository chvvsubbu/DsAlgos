package patterns.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        Arrays.sort(candidates);
        backTracking(result, new ArrayList<>(), candidates, target, 0);
        return result;

    }

        private static void backTracking(List<List<Integer>> result, List<Integer> combination, int[] candidates, int remain, int start) {

        if(remain < 0 ) return;
        else if(remain == 0){
            result.add(new ArrayList<>(combination));
        }
        else{
            for(int i = start; i< candidates.length; i ++){
                combination.add(candidates[i]);
                backTracking(result, combination, candidates, remain-candidates[i], i);
                combination.remove(combination.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = CombinationSum.combinationSum(new int[] { 2, 3, 5 },8);
        System.out.print("Here are all the permutations: " + result);
    }



}
