package patterns.fastandslow;

public class RearrangeList {
    public static void  reorder(FSListNode head){

        if(head == null || head.next == null) return;

        FSListNode slow = head;
        FSListNode fast = head;

        while (fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }

        FSListNode headSecondHalf = reverse(slow);
        FSListNode headFirstHalf = head;
        while (headFirstHalf != null && headSecondHalf != null){
            FSListNode temp = headFirstHalf.next;
            headFirstHalf.next = headSecondHalf;
            headFirstHalf = temp;

            temp = headSecondHalf.next;
            headSecondHalf.next = headFirstHalf;
            headSecondHalf = temp;
        }

        if(headFirstHalf != null){
            headFirstHalf.next = null;
        }

    }

    private static FSListNode reverse(FSListNode head) {
        FSListNode prev = null;
        while ( head != null) {
            FSListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        FSListNode head = new FSListNode(2);
        head.next = new FSListNode(4);
        head.next.next = new FSListNode(6);
        head.next.next.next = new FSListNode(8);
        head.next.next.next.next = new FSListNode(10);
        head.next.next.next.next.next = new FSListNode(12);
        RearrangeList.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }

    }
}
