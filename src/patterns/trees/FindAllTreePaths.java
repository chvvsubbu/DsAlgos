package patterns.trees;

import java.util.ArrayList;
import java.util.List;

public class FindAllTreePaths {

    public static List<List<Integer>> findAllTreePaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> treePath = new ArrayList<>();
        findPathsRecurssive(root, result, treePath);
        return result;
    }

    private static void findPathsRecurssive(TreeNode root, List<List<Integer>> result, List<Integer> treePath) {

        if(root == null) return;
        treePath.add(root.data);
        if(root.left == null && root.right == null) {
            result.add(new ArrayList<>(treePath));
        }else {
            if(root.left != null){
                findPathsRecurssive(root.left, result, treePath);
            }
            if(root.right != null){
                findPathsRecurssive(root.right, result, treePath);
            }
        }
        treePath.remove(treePath.size()-1);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        List<List<Integer>> result = FindAllTreePaths.findAllTreePaths(root);
        System.out.println("Tree paths : " + result);

    }
}
