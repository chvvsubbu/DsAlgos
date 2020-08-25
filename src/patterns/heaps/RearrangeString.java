package patterns.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeString {

    public static String rearrangeString(String str){

        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char ch : str.toCharArray()){
            charFrequencyMap.put(ch, charFrequencyMap.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1,e2)->e2.getValue()-e1.getValue());
        maxHeap.addAll(charFrequencyMap.entrySet());
        Map.Entry<Character, Integer> prevEntry = null;
        StringBuilder resultString = new StringBuilder();

        while (!maxHeap.isEmpty()){
        Map.Entry<Character,Integer> currentEntry = maxHeap.poll();
        if(prevEntry != null && prevEntry.getValue() >0){
            maxHeap.offer(prevEntry);
        }
        resultString.append(currentEntry.getKey());
        currentEntry.setValue(currentEntry.getValue()-1);
        prevEntry =currentEntry;
        }

        return resultString.length() == str.length()? resultString.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));

    }
}
