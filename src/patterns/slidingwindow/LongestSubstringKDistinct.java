package patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

    public static int findLength(String str,  int K){
        Map<Character, Integer> charMap = new HashMap<>();
        int windowEnd = 0, result =Integer.MIN_VALUE;
        int windowStart =0;
        char ch;
        while(windowEnd <str.length()){
            ch = str.charAt(windowEnd);
            charMap.put(ch, charMap.getOrDefault(ch,0)+1);
            while (charMap.size() >K){
                ch = str.charAt(windowStart);
                charMap.put(ch,charMap.get(ch)-1);
                if(charMap.get(ch) ==0){
                    charMap.remove(ch);
                }
                windowStart++;
            }
            result = Math.max(result, windowEnd-windowStart+1);
            windowEnd++;
        }
        return  result;
    }

    public static void main(String[] args) {
        int longestSubstringLength = findLength("araaci",2);
        System.out.println("longestSubstringLength: "+ longestSubstringLength);
    }
}
