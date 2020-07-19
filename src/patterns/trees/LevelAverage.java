package patterns.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelAverage {

    public static List<Double> findLevelAverages(TreeNode root){
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0;

            for (int loop = 0; loop < levelSize; loop++) {
                TreeNode node = queue.poll();
                levelSum += node.data;
                if(node.left != null ) queue.offer(node.left);
                if(node.right != null ) queue.offer(node.right);
            }
            result.add( levelSum/levelSize);
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
        List<Double> result = LevelAverage.findLevelAverages(root);
        System.out.println("Level averages are: " + result);
    }
 }
