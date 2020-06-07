package patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {

    public  static int findLength(String str){
        int windowStart = 0, windowEnd;
        Map<Character, Integer> charMap = new HashMap<>();
        int currentMaxSubStringLength = Integer.MIN_VALUE;
        char ch;
        for(windowEnd = 0 ; windowEnd < str.length()-1 ; windowEnd++){
            ch = str.charAt(windowEnd);
            if(charMap.containsKey(ch)){
                windowStart = charMap.get(ch)+1;
            }
            charMap.put(ch,windowEnd);
            currentMaxSubStringLength =Math.max(currentMaxSubStringLength, windowEnd-windowStart+1);
        }
        return currentMaxSubStringLength;
    }

    public static void main(String[] args) {
        int noRepeatStringLength = findLength("abccde");
        System.out.println("Length: "+ noRepeatStringLength);
         noRepeatStringLength = findLength("abbbb");
        System.out.println("Length: "+ noRepeatStringLength);
        noRepeatStringLength = findLength("abccde");
        System.out.println("Length: "+ noRepeatStringLength);
    }
}
