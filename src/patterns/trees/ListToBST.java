package patterns.trees;

public class ListToBST {

    public static ListNode findMiddleElement (ListNode head){
        ListNode prevPtr = null;
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr !=null && fastPtr.next != null){
            prevPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        if(prevPtr != null){
            prevPtr.next = null;
        }
        return slowPtr;
    }


    public static TreeNode sortedListToBST(ListNode head){
        if(head == null)
            return null;
        ListNode mid = findMiddleElement(head);

        TreeNode node = new TreeNode(mid.val);
        if(head == mid){
            return node;
        }
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);
        return node;
    }
    public static void printList(ListNode head){
        ListNode current = head;
        while (current != null){
            System.out.print(" "+current.val);
            current =current.next;
        }
    }

    public static void printTree(TreeNode root) {
        if(root != null){
            printTree(root.left);
            System.out.print(root.data +"  ");
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        printList(head);
        System.out.println();
        TreeNode root = sortedListToBST(head);
        printTree(root);

    }
}
