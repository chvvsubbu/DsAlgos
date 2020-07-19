package patterns.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectLevelOrderSiblings {

    public static void connect(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode previousNode = null;
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>(size);
            for (int loop = 0; loop < size; loop++) {
                TreeNode currentNode = queue.poll();
                if(previousNode != null)
                    previousNode.next = currentNode;
                previousNode = currentNode;

                if(currentNode.left != null) queue.offer(currentNode.left);
                if(currentNode.right !=  null) queue.offer(currentNode.right);

            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(11);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }

}
