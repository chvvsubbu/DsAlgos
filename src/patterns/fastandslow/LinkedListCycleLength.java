package patterns.fastandslow;

public class LinkedListCycleLength {

    public static int findCycleLength(FSListNode head) {
        FSListNode slowPointer = head;
        FSListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if(slowPointer == fastPointer){
               return caluclateLength(slowPointer);
            }
        }
        return 0;
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
        System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));

    }
}
