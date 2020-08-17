package patterns.heaps;

import java.util.PriorityQueue;

public class ConnectRopes {
    public static int minimumCostToConnectRopes(int[] ropeLengths ){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < ropeLengths.length; i++) {
            minHeap.add(ropeLengths[i]);
        }
        int totalCost =0;
        while (minHeap.size() >1){
            int firstLength = minHeap.poll();
            int secondLength = minHeap.poll();
            totalCost += firstLength+secondLength;
            minHeap.add(firstLength+secondLength);
        }
        return totalCost;
    }

    public static void main(String[] args) {
        int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
        System.out.println("Minimum cost to connect ropes: " + result);
    }
}
