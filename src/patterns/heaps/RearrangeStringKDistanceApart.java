package patterns.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeStringKDistanceApart {
    public static String reorganizeString(String str, int k) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char ch : str.toCharArray()){
            charFrequencyMap.put(ch, charFrequencyMap.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2)->e2.getValue()-e1.getValue());
        maxHeap.addAll(charFrequencyMap.entrySet());
        StringBuilder resultString = new StringBuilder();
        while (!maxHeap.isEmpty()){
            Map.Entry<Character,Integer>[] currentEntry = new Map.Entry[k];
            for (int i = 0; i <k; i++) {
                currentEntry[i] = maxHeap.poll();
                if(currentEntry==null && resultString.length() != str.length() && i <k-1){
                    return "";
                }
                if(currentEntry[i]!=null)
                    resultString.append(currentEntry[i].getKey());
            }
            for (int i = 0; i <k; i++) {
                if(currentEntry[i]!=null ){
                    currentEntry[i].setValue(currentEntry[i].getValue()-1);
                    if(currentEntry[i].getValue()!=0){
                        maxHeap.offer(currentEntry[i]);
                    }
                }
            }
        }
        return resultString.length()==str.length()? resultString.toString():"";
    }

    public static void main(String[] args) {
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aab", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
    }

}
