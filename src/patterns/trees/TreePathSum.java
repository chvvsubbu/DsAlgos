package patterns.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreePathSum {

    public static boolean hasPath(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.data == sum && (root.left==null) && (root.right == null) ) return true;
        return (hasPath(root.left, sum - root.data) || hasPath(root.right, sum - root.data) );
    }

    public static List<List<Integer>> findPaths (TreeNode root, int sum){
        List<List<Integer> > allPaths = new ArrayList<>();
        List<Integer> cuurentPath = new ArrayList<>();
        findRecursive(root, sum, allPaths, cuurentPath);
        return allPaths;
    }

    private static void findRecursive(TreeNode current, int sum, List<List<Integer>> result, List<Integer> cuurentPath) {
        if(current == null ) return;
        cuurentPath.add(current.data);
        if(current.data == sum && current.left == null && current.right == null){
            result.add(new ArrayList<>(cuurentPath) );
        }else {
            if(current.left != null) findRecursive(current.left, sum-current.data, result, cuurentPath);
            if(current.right != null) findRecursive(current.right, sum-current.data, result, cuurentPath);
        }
        cuurentPath.remove(cuurentPath.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);

    }
}
