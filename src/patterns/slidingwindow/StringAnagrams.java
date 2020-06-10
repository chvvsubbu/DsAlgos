package patterns.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {

    public static List<Integer> findStringAnagrams(String str, String pattern){

        int windrowStart = 0, matched = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        List<Integer> resultIndices = new ArrayList<>();

        for(char ch : pattern.toCharArray())
            charMap.put(ch, charMap.getOrDefault(ch,0)+1);

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){

            char rightChar = str.charAt(windowEnd);
            if ( charMap.containsKey(rightChar) ){
                charMap.put(rightChar, charMap.get(rightChar) -1);
                if(charMap.get(rightChar) == 0) matched++;
            }
            if ( matched == charMap.size() )
                resultIndices.add(windrowStart);

            if(windowEnd >= pattern.length()-1){
                char leftChar = str.charAt(windrowStart++);

                if(charMap.containsKey(leftChar)){
                    if(charMap.get(leftChar) == 0)
                        matched--;
                    charMap.put(leftChar, charMap.get(leftChar)+1);
                }
            }
        }
        return  resultIndices;
    }

    public static void main(String[] args) {


        System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
        System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));

    }



}
