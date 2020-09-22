package patterns.fastandslow;

import com.sun.jmx.snmp.SnmpNull;

public class PalindromicLinkedList {
    public static boolean isPalindrome(FSListNode head) {
        if(head == null || head.next == null) return true;

        FSListNode slow = head;
        FSListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        FSListNode headSecondHalf = reverse(slow);
        FSListNode copyHeadSecondHalf = headSecondHalf;

        while (head != null && headSecondHalf != null){
            if(head.value != headSecondHalf.value){
                break;
            }
            head = head.next;
            headSecondHalf = headSecondHalf.next;
        }
        reverse(copyHeadSecondHalf);
        if(head == null || headSecondHalf == null)
            return true;
        return false;

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
        head.next.next.next = new FSListNode(4);
        head.next.next.next.next = new FSListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head.next.next.next.next.next = new FSListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

    }
}
