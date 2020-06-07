package patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class KLengthSubstringsWithNoRepeatedCharacters1100 {

    public static  int numKLenSubstrNoRepeats(String S, int K) {

        int currentWindow = 0, klengthStrings =0;
        Map<Character, Integer> charMap = new HashMap<>();
        while(currentWindow < S.length()){
            char ch = S.charAt(currentWindow);
            charMap.put(ch,charMap.getOrDefault(ch,0)+1);
            if(currentWindow >= K-1){
                if(charMap.size() == K) klengthStrings++;
                ch = S.charAt(currentWindow -K+1);
                charMap.put(ch,charMap.get(ch)-1);
                if(charMap.get(ch) == 0) charMap.remove(ch);
            }

            currentWindow ++;
        }
        return klengthStrings;
    }

    public static void main(String[] args) {
        System.out.println(numKLenSubstrNoRepeats("havefunonleetcode",5));
    }


}
