package patterns.trees;

public class ArrayToBST {
    int nums[];


    public TreeNode sortedArrayToBST(int[] nums){
        this.nums = nums;
        return helper(0,nums.length-1);
    }

    private TreeNode helper(int left, int right) {

        if(left >right ) return null;

        int p = (left+right) /2;

        TreeNode node = new TreeNode(nums[p]);
        node.left = helper(left,p-1);
        node.right = helper(p+1,right);
        return node;
    }

    public static void printTree(TreeNode root) {
        if(root != null){
            printTree(root.left);
            System.out.print(root.data +"  ");
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        ArrayToBST  arrayToBST = new ArrayToBST();
        TreeNode node = arrayToBST.sortedArrayToBST(arr);
        printTree(node);

    }

}
