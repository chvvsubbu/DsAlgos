package patterns.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public static List<String> letterCasePermutation(String S) {

        List<String> result = new ArrayList<>();
        backTrack(result, S.toLowerCase().toCharArray(), S.toLowerCase().toCharArray(), 0);
        return  result;
    }

    public static void backTrack(List<String> result, char[] tempArray, char[] givenArray, int start) {
        String  s= new String(tempArray);
        result.add(s);
        for(int i = start; i < givenArray.length; i ++ ){
            if(Character.isLetter(givenArray[i])){
                tempArray[i] = Character.isLowerCase(givenArray[i])? Character.toUpperCase(givenArray[i]): givenArray[i];
                backTrack(result,tempArray, givenArray, i+1);
                tempArray[i] =givenArray[i];
            }
        }
    }

    public static void main(String[] args) {
        List<String> res = LetterCasePermutation.letterCasePermutation("a1b2");
        System.out.println(res);
    }


}
