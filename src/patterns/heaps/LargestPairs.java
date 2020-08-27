package patterns.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class KPair{
    int l1;
    int l2;

    public KPair(int l1, int l2) {
        this.l1 = l1;
        this.l2 = l2;
    }
}

public class LargestPairs {
    public static List<int[]> findKLargestPairs(int[] num1, int[] num2, int k){
        List<int[]> result = new ArrayList<>();
        PriorityQueue<KPair> maxHeap = new PriorityQueue<>((a,b)->( ( num1[b.l1]+ num2[b.l2] ) - (num1[a.l1]+num2[a.l2]) )  );
        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num2.length; j++) {
                maxHeap.add(new KPair(i,j) );
            }
        }

        for (int i = 0; i < k; i++) {
            KPair kPair = maxHeap.poll();
            result.add(new int[] {num1[kPair.l1],num2[kPair.l2]} );
        }
        return result;
    }

    public static void main(String[] args) {
        int[] l1 = new int[] { 9, 8, 2 };
        int[] l2 = new int[] { 6, 3, 1 };
        List<int[]> result = LargestPairs.findKLargestPairs(l1, l2, 3);
        System.out.print("Pairs with largest sum are: ");
        for (int[] pair : result)
            System.out.print("[" + pair[0] + ", " + pair[1] + "] ");

    }

}
