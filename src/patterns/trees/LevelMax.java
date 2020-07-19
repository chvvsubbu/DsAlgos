package patterns.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelMax
{
    public static List<Integer> findLevelMax(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int  levelMax = Integer.MIN_VALUE;

            for (int loop = 0; loop < levelSize; loop++) {
                TreeNode node = queue.poll();
                levelMax = Math.max(levelMax, node.data);
                if(node.left != null ) queue.offer(node.left);
                if(node.right != null ) queue.offer(node.right);
            }
            result.add( levelMax);
        }

        return  result;
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
        List<Integer> result = LevelMax.findLevelMax(root);
        System.out.println("Level max are: " + result);
    }
}
