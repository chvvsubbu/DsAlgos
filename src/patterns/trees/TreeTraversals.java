package patterns.trees;

import java.util.*;

public class TreeTraversals {
    private static int count = 0;

    private static void printPreOrder(TreeNode root) {
        preorder(root);
        System.out.println();
    }

    private static void preorder(TreeNode root) {
        if(root != null) {
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
        }

    }

    private static void printPostOrder(TreeNode root) {
        postorder(root);
        System.out.println();
    }

    private static void postorder(TreeNode root) {
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }


    }

    private static void printInorder(TreeNode root) {
        inorder(root);
        System.out.println();

    }

    private static void inorder(TreeNode root) {
        if(root != null){
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void levelorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.print(node.data + " ");

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static  List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current!= null || !stack.isEmpty()){
            while (current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            res.add(current.data);
            current = current.right;


        }
        return res;
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null)
                return null;

        stack.add(root);
        while (! stack.isEmpty()){
            TreeNode node = stack.pollLast();
            res.add(node.data);
            if(node.right != null)
                stack.add(node.right);
            if(node.left != null)
                stack.add(node.left);
        }
        return res;
    }
    public static List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> out = new ArrayList<>();

        if(root == null) return out;
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()){

            if(root != null){
                stack.push(root);
                root = root.left;
            }else {
                root = stack.peek();
                if(root.right == null || root.right == pre){
                    out.add(root.data);
                    stack.pop();
                    pre=root;
                    root = null;
                }else {
                    root = root.right;
                }
            }
        }
        return out;
    }

    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        Stack<TreeNode> path = new Stack<>();
        s.push(root);

        while (!s.isEmpty()){
            TreeNode node = s.peek();
            if(!path.isEmpty() && path.peek()==node){
                out.add(node.data);
                s.pop();
                path.pop();
            }else{
                path.add(node);
                if(node.right != null) s.add(node.right);
                if(node.left != null) s.add(node.left);

            }
        }
        return out;
    }

    public static boolean isValidBST(TreeNode root) {

        if(root == null) return  true;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        while (root!=null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(prev != null && prev.data > root.data){
                return false;
            }
            prev = root;
            root = null;
        }
        return true;
    }

    public static int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = new ArrayList<>();
        inOrderKth(root, nums);
        return  nums.get(k-1);
    }

    private static void inOrderKth(TreeNode root, ArrayList<Integer> nums) {
        if(root == null)
            return ;
        inOrderKth(root.left, nums);
        nums.add(root.data);
        inOrderKth(root.right, nums);
    }

    public static int kthSmallest2(TreeNode root, int k){
            int[] nums = new int[2];
            inOrderKth2(root, nums, k);
            return  nums[1];
    }

    private static void inOrderKth2(TreeNode root, int[] nums, int k){

        if(root == null) return;
        inOrderKth2(root.left, nums, k);
        if(++nums[0] ==k){
            nums[1] =root.data;
            return;
        }
        inOrderKth2(root.right, nums, k);
    }

    public static  int kthSmallest3(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();

        while(root != null || !s.empty()){
            while(root != null){
                s.push(root);
                root = root.left;
            }

            root = s.pop();

            if(--k == 0)
                return root.data;

            root = root.right;
        }
        return -1;
    }

    public static int height(TreeNode root){
        if(root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1+ Math.max(leftHeight, rightHeight);
    }

    public static int minDepth(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        if(root.left == null) return minDepth(root.right);
        if(root.right == null) return minDepth(root.left);
        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);
        return 1+ Math.min(leftMinDepth, rightMinDepth);

    }

    public static int minDepth1(TreeNode root) {
        int minDepth = 0;
        if(root == null ) return minDepth;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode current = root;
        queue.offer(current);
        while (!queue.isEmpty()){
            minDepth++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                current = queue.poll();
                if(current.left != null){
                    queue.offer(current.left);
                }
                if(current.right != null){
                    queue.offer(current.right);
                }
                if (current.left == null && current.right == null) {
                    queue.clear();
                    break;
                }
            }
        }
        return minDepth;
    }

    public static  int minDepth2(TreeNode root) {
        if(root == null) return 0;
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (! queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if(isLeafNode(current)) return depth;
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
            depth++;
        }
        return -1;
    }


    private static  boolean isLeafNode(TreeNode curr) {
        return curr != null && curr.left == null && curr.right == null;
    }

    private static void printNthNode(TreeNode root,int n) {
        if (root == null)
            return;
        printNthNode(root.left,n);
        count++;
        if (count == n) {
            System.out.println(root.data);
        }
        printNthNode(root.right,n);
    }

    public static  List<Integer> res = new ArrayList<>();

    public static  List<Integer> boundaryofBinaryTree(TreeNode root){
        if(root == null ) return  res;
        res.add(root.data);
        processLeftSubTree(root.left);
        processLeafs(root.left);
        processLeafs(root.right);
        processRightSubTree(root.right);

        return res;

    }

    private static void processLeftSubTree(TreeNode root) {
        if(root == null) return;

        if(root.left != null){
            res.add(root.data);
            processLeftSubTree(root.left);
        }else if (root.right != null){
            res.add(root.data);
            processLeftSubTree(root.right);
        }

    }

    private static void processRightSubTree(TreeNode root) {

        if(root == null) return;

        if (root.right!= null){

            processRightSubTree(root.right);
            res.add(root.data);
        }else if(root.left != null){
            processRightSubTree(root.right);
            res.add(root.data);
        }
    }

    private static void processLeafs(TreeNode root) {

        if(root == null) return;

        processLeafs(root.left);

        if(root.left == null &&  root.right == null)
            res.add(root.data);

        processLeafs(root.right);

    }


    public static void main(String[] args) {
        TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(8);
        tree.right = new TreeNode(20);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(6);
        tree.right.left = new TreeNode(15);

        /*System.out.println("inorder:");
        printInorder(tree);
        System.out.println("postorder:");
        printPostOrder(tree);
        System.out.println("preorder:");
        printPreOrder(tree);

        System.out.println("levelorderTraversal:");
        levelorderTraversal(tree);*/

       /* List<Integer> list = inorderTraversal(tree);
        System.out.println(list);
        list = preorderTraversal(tree);
        System.out.println(list);*/
        List<Integer> list = inorderTraversal(tree);
        System.out.println(list);
        //boolean isBST = isValidBST(tree);
       // System.out.println("Is Tree is BST: " +isBST);

       /* int second = kthSmallest(tree, 1);
        System.out.println("second: " +second);
        second = kthSmallest2(tree, 1);
        System.out.println("second: " +second);*/

       /*int height = minDepth1(tree);
        System.out.println(height);

         height = minDepth2(tree);
        System.out.println(height);

        printNthNode(tree, 3);*/

        System.out.println(boundaryofBinaryTree(tree));

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();


    }
}
