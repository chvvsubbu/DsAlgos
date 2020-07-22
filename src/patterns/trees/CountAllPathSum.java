package patterns.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CountAllPathSum {

    public static int countPaths(TreeNode root, int sum){
        List<Integer> currentPath = new ArrayList<>();
        return countPathsRecursively(root, sum, currentPath);
    }

    private static int countPathsRecursively(TreeNode currentNode, int sum, List<Integer> currentPath) {
        if(currentNode == null) return  0;
        currentPath.add(currentNode.data);
        int pathCount =0, pathSum =0;
        ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
        while (pathIterator.hasPrevious()){
            pathSum +=pathIterator.previous();
            if(pathSum ==sum) pathCount++;
        }
        pathCount += countPathsRecursively(currentNode.left,sum, currentPath);
        pathCount += countPathsRecursively(currentNode.right, sum, currentPath);
        currentPath.remove(currentPath.size()-1);
        return pathCount;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));

    }

}
