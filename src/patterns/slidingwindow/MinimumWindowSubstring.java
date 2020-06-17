package patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static String findSubstring(String str, String pattern){

        int windowStart  = 0, windowEnd =0, matched =0, minLength = str.length(), subStringStart = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for(char ch: pattern.toCharArray()){
            charMap.put(ch, charMap.getOrDefault(ch,0)+1);
        }

        for(windowEnd =0 ; windowEnd <str.length(); windowEnd++){

            char rightChar = str.charAt(windowEnd);

            if(charMap.containsKey(rightChar)){
                charMap.put(rightChar, charMap.get(rightChar) -1);
                if(charMap.get(rightChar)  == 0 )
                    matched++;
            }

            while (matched == pattern.length() ){

                if(minLength > windowEnd - windowStart + 1) {
                    minLength = windowEnd - windowStart + 1;
                     subStringStart = windowStart;
                }

                char leftChar = str.charAt(windowStart++);
                if(charMap.containsKey(leftChar)){
                    if(charMap.get(leftChar) == 0)
                        matched--;

                    charMap.put(leftChar, charMap.get(leftChar) + 1);
                }
            }
        }
        return minLength > str.length() ? "": str.substring(subStringStart, subStringStart+ minLength);
    }

    public static void main(String[] args) {
        System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("abdabca", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("adcad", "abc"));

    }
}
