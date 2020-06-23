package patterns.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private static void backtrack(List<List<String>> list, List<String> tempList, String s, int start) {
        if(start == s.length()){
            list.add(new ArrayList<>(tempList));
        }else{
            for(int i = start; i < s.length(); i++){
                if(isPalindrome(s, start, i)){
                    tempList.add(s.substring(start, i + 1));
                    backtrack(list, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    public static boolean isPalindrome(String s, int low, int high){
        while(low < high)
            if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }


    public static void main(String[] args) {
        List<List<String>> result = Palindrome.partition("aab");
        System.out.print("Here are all the palindrome partitioning: " + result);
    }



}
