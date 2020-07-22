package patterns.trees;

public class TreeDiameter {

    private static int treeDiameter = 0;

    public static int findDiameter(TreeNode root){

        caluclateHeight(root);
        return treeDiameter;
    }

    private static int caluclateHeight(TreeNode currentNode) {
        if(currentNode == null) return 0;
        int leftHeight = caluclateHeight(currentNode.left);
        int rightHeiht = caluclateHeight(currentNode.right);
        treeDiameter = Math.max(treeDiameter, 1+leftHeight+rightHeiht);
        return Math.max(leftHeight,  rightHeiht)+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));

    }
}
