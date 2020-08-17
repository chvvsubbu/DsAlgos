package patterns.heaps;

import java.util.*;

public class TopKFrequentNumbers {
    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        Map<Integer, Integer> mapFrequency = new HashMap<>();
        for(int a : nums) {
            mapFrequency.put(a, mapFrequency.getOrDefault(a, 0 ) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>( (e1, e2)-> e1.getValue() - e2.getValue());
        for(Map.Entry entry : mapFrequency.entrySet()){
            minHeap.add(entry);
            if(minHeap.size() >k){
                minHeap.poll();
            }
        }

        List<Integer> arrayList = new ArrayList<>(k);
        while (!minHeap.isEmpty()){
            arrayList.add(minHeap.poll().getKey());
        }
        return arrayList;
    }

    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);

    }
}
