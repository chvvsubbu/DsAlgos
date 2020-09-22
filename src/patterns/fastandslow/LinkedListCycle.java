package patterns.fastandslow;

public class LinkedListCycle {

    public static boolean hasCycle(FSListNode head) {
        FSListNode slowPointer = head;
        FSListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if(slowPointer == fastPointer)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        FSListNode head = new FSListNode(1);
        head.next = new FSListNode(2);
        head.next.next = new FSListNode(3);
        head.next.next.next = new FSListNode(4);
        head.next.next.next.next = new FSListNode(5);
        head.next.next.next.next.next = new FSListNode(6);
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

    }
}
