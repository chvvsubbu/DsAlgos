package patterns.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    public static String sortCharacterByFrequency(String str) {

        Map<Character, Integer> charMap = new HashMap<>();
        for(char ch : str.toCharArray()){
            charMap.put(ch, charMap.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>( (e1,e2)-> e2.getValue() - e1.getValue());
        maxHeap.addAll(charMap.entrySet());
        StringBuilder sortedString = new StringBuilder(str.length());

        while (! maxHeap.isEmpty()){
            Map.Entry<Character, Integer> characterIntegerEntry = maxHeap.poll();
            for (int i = 0; i < characterIntegerEntry.getValue(); i++) {
                sortedString.append(characterIntegerEntry.getKey());
            }
        }
        return sortedString.toString();
    }

    public static void main(String[] args) {
        String result = FrequencySort.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = FrequencySort.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

    }
}
