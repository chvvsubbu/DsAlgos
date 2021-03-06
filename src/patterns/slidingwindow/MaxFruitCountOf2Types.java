package patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {

    public static int findLength(char[] arr) {
        int windowEnd = 0, windowStart = 0;
        int result = Integer.MIN_VALUE;
        Map<Character, Integer> charMap = new HashMap<>();


        for(windowEnd =0;windowEnd <arr.length; windowEnd++){

            charMap.put(arr[windowEnd], charMap.getOrDefault(arr[windowEnd], 0)+1 );
            while(charMap.size() >2){
                charMap.put(arr[windowStart], charMap.get(arr[windowStart])-1);
                if(charMap.get(arr[windowStart]) == 0) {
                    charMap.remove(arr[windowStart]);
                }
                windowStart++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int count = findLength(new char[]{'A', 'B', 'C', 'A', 'C'});
        System.out.println("count: "+ count );
    }
}
