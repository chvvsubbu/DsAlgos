package patterns.trees;

public class ListToBSTIterate {

    private ListNode head;

    private int findSize(ListNode head){
        ListNode current = head;
        int count =0;

        while (current != null){
            current = current.next;
            count++;
        }
        return count;
    }

    public  TreeNode sortedListToBST(ListNode head){
        int size = this.findSize(head);
        this.head = head;
        return convertToBST(0, size-1);
    }

    private TreeNode convertToBST(int l, int r) {
        if(l > r) return null;

        int mid = (l+r)/2;
        TreeNode left = this.convertToBST(1, mid-1);

        TreeNode node = new TreeNode(this.head.val);
        node.left = left;
        this.head = this.head.next;
        TreeNode right = this.convertToBST(mid+1, r);
        return node;
    }

    public static void printTree(TreeNode root) {
        if(root != null){
            printTree(root.left);
            System.out.print(root.data +"  ");
            printTree(root.right);
        }
    }

    public static void printList(ListNode head){
        ListNode current = head;
        while (current != null){
            System.out.print(" "+current.val);
            current =current.next;
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
        ListToBSTIterate listToBSTIterate = new ListToBSTIterate();
        TreeNode root = listToBSTIterate.sortedListToBST(head);
        printTree(root);

    }
}
