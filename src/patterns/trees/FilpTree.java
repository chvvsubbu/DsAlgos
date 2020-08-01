package patterns.trees;

public class FilpTree {

    public static TreeNode flipTree( TreeNode root){
        if(root == null) return null;
        if(root.left == null && root.right == null)
            return root;
        TreeNode flipNode = flipTree(root.left);

        root.left.left = root.right;
        root.left.right = root;
        root.left = root.right = null;
        return flipNode;
    }

}
