package patterns.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagTraversal {

    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeftToRight = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>(size);
            System.out.println(isLeftToRight);
            for (int loop = 0; loop < size; loop++) {
                TreeNode node = queue.poll();
                if(isLeftToRight){
                currentLevel.add(node.data);
                }else{
                    currentLevel.add(0,node.data);
                }
                if(node.left != null) queue.offer(node.left);
                if(node.right !=  null) queue.offer(node.right);

            }
            isLeftToRight = !isLeftToRight;

            result.add(currentLevel);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigzagTraversal.traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }


}
