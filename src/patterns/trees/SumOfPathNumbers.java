package patterns.trees;

public class SumOfPathNumbers {

    public static int findSumOfPathNumbers(TreeNode root){
        return  findRootToLeafPathSums(root, 0);
    }

    private static int findRootToLeafPathSums(TreeNode root, int pathSum) {
        if(root == null) return 0;
        pathSum = pathSum *10 + root.data;
        if(root.left == null && root.right == null) {
            return pathSum;
        }
        return findRootToLeafPathSums(root.left,pathSum ) + findRootToLeafPathSums(root.right, pathSum );
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));

    }
}
