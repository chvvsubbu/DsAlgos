package patterns.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class PNode{
    int elementIndex;
    int arrayIndex;

    public PNode(int elementIndex, int arrayIndex) {
        this.elementIndex = elementIndex;
        this.arrayIndex = arrayIndex;
    }
}

public class SmallestRange {
    public static int[] findSmallestRange(List<Integer[]> lists) {
        PriorityQueue<PNode> minHeap = new PriorityQueue<>((n1, n2) -> lists.get(n1.arrayIndex)[n1.elementIndex] - lists.get(n2.arrayIndex)[n2.elementIndex]);
        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE, currentMaxNumber = Integer.MIN_VALUE;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null)
                minHeap.add(new PNode(i, 0));
            currentMaxNumber = Math.max(currentMaxNumber, lists.get(i)[0]);
        }
        //TODO  change code here
    return new int[10];
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[]{1, 5, 8};
        Integer[] l2 = new Integer[]{4, 12};
        Integer[] l3 = new Integer[]{7, 8, 10};
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int[] result = SmallestRange.findSmallestRange(lists);
        System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");

    }
}
