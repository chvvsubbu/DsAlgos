package patterns.backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target){

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void backTrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int target, int start) {
        if(target ==0){
            result.add(new ArrayList<>(tempList));
        }else if( target < 0){
            return;
        }else{
            for(int i= start; i < candidates.length; i++){
                if(i > start && candidates[i] == candidates[i-1]) continue;
                tempList.add(candidates[i]);
                backTrack(result,tempList,candidates, target-candidates[i], i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = CombinationSum2.combinationSum2(new int[] { 10,1,2,7,6,1,5},8);
        System.out.print("Here are all the permutations: " + result);

    }
}
