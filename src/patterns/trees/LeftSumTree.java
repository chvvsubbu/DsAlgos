package patterns.trees;

public class LeftSumTree {

    public static int update(TreeNode node){
        if(node == null) return 0;
        if(node.left == null && node.right == null) return node.data;
        int leftSum = update(node.left);
        int rightSum = update(node.right);
        node.data = node.data + leftSum;
        return node.data + rightSum;
    }

    public static void printTree(TreeNode root) {
        if(root != null){
            printTree(root.left);
            System.out.print(root.data +"  ");
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        printTree(root);
        update(root);
        System.out.println();
        printTree(root);

    }
}
