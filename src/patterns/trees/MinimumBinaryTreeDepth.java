package patterns.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumBinaryTreeDepth {

    public static int findDepth(TreeNode root){
        int minDepth = 0;
        if(root == null) return minDepth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            minDepth++;
            int levelSize = queue.size();
            for (int loop = 0; loop < levelSize; loop++) {
                TreeNode node  = queue.poll();
                if(node.left == null && node.right == null){
                    queue.clear();
                    return  minDepth;
                }
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
    return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));

    }
}
