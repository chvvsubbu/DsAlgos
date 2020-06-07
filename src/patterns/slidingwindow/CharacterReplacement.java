package patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {

    public static int findLength(String str , int k){

        int windowStart =0, windowEnd =0;
        int currentSubStringLength = Integer.MIN_VALUE;
        Map<Character, Integer> charMap = new HashMap<>();


        for(windowEnd = 0 ; windowEnd <str.length(); windowEnd++){

        }
        return -1;
    }

    public static void main(String[] args) {
        int maxSubstringLen = findLength("aabccbb",2);
        System.out.println("maxSubstringLen: "+maxSubstringLen);
    }
}
