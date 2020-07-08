package patterns.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {


    public static List<List<Integer>> traverse(TreeNode root){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>(size);
            for (int loop = 0; loop < size; loop++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.data);
                if(node.left != null) queue.offer(node.left);
                if(node.right !=  null) queue.offer(node.right);
            }
            result.add(currentLevel);
        }
        return result;
    }

    public  static  int iterSize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int treeSize = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int loop = 0; loop < size; loop++) {
                TreeNode node = queue.poll();
                treeSize++;
                if(node.left != null) queue.offer(node.left);
                if(node.right !=  null) queue.offer(node.right);
            }

        }
        return treeSize;
    }

    public static List<Integer> leafNodes(TreeNode root){
        List<Integer> leafNodes = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if(currentNode.left == null && currentNode.right == null){
                    leafNodes.add(currentNode.data);
                }
                if(currentNode.left != null) queue.offer(currentNode.left);
                if(currentNode.right != null) queue.offer(currentNode.right);

            }

        }
        return leafNodes;
    }


    public static void main(String[] args) {
        TreeNode tree = new TreeNode(12);
        tree.left = new TreeNode(7);
        tree.right = new TreeNode(1);
        tree.left.left = new TreeNode(9);
        tree.right.left = new TreeNode(10);
        tree.right.right = new TreeNode(5);

        List<List<Integer>> result = traverse(tree);
        System.out.println("Level order traversal: " +result);
        System.out.println("Tree size: "+ iterSize(tree));
        System.out.println("Leaf nodes: " + leafNodes(tree));
     }
}
