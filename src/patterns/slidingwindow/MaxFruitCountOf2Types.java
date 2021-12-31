package patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {

    public static int findLength(char[] arr) {
        int windowEnd = 0, windowStart = 0;
        int result = Integer.MIN_VALUE;
        Map<Character, Integer> fruitFrequencyMap = new HashMap<>();


        for(windowEnd =0;windowEnd <arr.length; windowEnd++){

            fruitFrequencyMap.put(arr[windowEnd], fruitFrequencyMap.getOrDefault(arr[windowEnd], 0)+1 );
            while(fruitFrequencyMap.size() >2){
                fruitFrequencyMap.put(arr[windowStart], fruitFrequencyMap.get(arr[windowStart])-1);
                if(fruitFrequencyMap.get(arr[windowStart]) == 0) {
                    fruitFrequencyMap.remove(arr[windowStart]);
                }
                windowStart++;
            }
            result = Math.max(result, windowEnd - windowStart + 1);
        }

        return result;
    }



    public static void main(String[] args) {
        int count = findLength(new char[]{'A', 'B', 'C', 'A', 'C'});
        System.out.println("count: "+ count );
    }
}
