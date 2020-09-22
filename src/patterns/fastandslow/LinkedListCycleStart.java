package patterns.fastandslow;

public class LinkedListCycleStart {
    public static FSListNode findCycleStart (FSListNode head) {

        FSListNode slowPointer = head;
        FSListNode fastPointer = head;
        int cycleLength = 0;
        while (fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(slowPointer == fastPointer){
                cycleLength = caluclateLength(slowPointer);
                break;
            }
        }
        return findStart(head, cycleLength);
    }

    private static FSListNode findStart(FSListNode head, int cycleLength) {

        FSListNode slowPointer = head;
        FSListNode fastPointer = head;
        for (int i = 0; i < cycleLength; i++) {
            fastPointer = fastPointer.next;
        }
        while (slowPointer !=  fastPointer){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        return slowPointer;
    }

    private static int caluclateLength(FSListNode slowPointer) {
        FSListNode current = slowPointer;
        int cycleLength  = 0;
        do{
            current = current.next;
            cycleLength++;
        }while (current != slowPointer);

        return cycleLength;
    }

    public static void main(String[] args) {
        FSListNode head = new FSListNode(1);
        head.next = new FSListNode(2);
        head.next.next = new FSListNode(3);
        head.next.next.next = new FSListNode(4);
        head.next.next.next.next = new FSListNode(5);
        head.next.next.next.next.next = new FSListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

    }
}
