package patterns.fastandslow;

public class MiddleOfLinkedList {
    public static FSListNode findMiddle(FSListNode head) {
        FSListNode slowPointer = head;
        FSListNode fastPointer = head;
        while ( fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    public static void main(String[] args) {
        FSListNode head = new FSListNode(1);
        head.next = new FSListNode(2);
        head.next.next = new FSListNode(3);
        head.next.next.next = new FSListNode(4);
        head.next.next.next.next = new FSListNode(5);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

        head.next.next.next.next.next = new FSListNode(6);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

        head.next.next.next.next.next.next = new FSListNode(7);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

    }
}
