package patterns.trees;

import java.util.*;

public class LowestCommonAncestor {
    private TreeNode ans;

    public LowestCommonAncestor() {
        this.ans =  null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        this.recurseTree(root,p,q);
        return this.ans;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        if(currentNode == null) return false;
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }
        return (mid + left + right > 0);
    }


    public TreeNode lowestCommonAncestorIterate(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        // HashMap for parent pointers
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);

        // Iterate until we find both the nodes p and q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {

            TreeNode node = stack.pop();

            // While traversing the tree, keep saving the parent pointers.
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();

        // Process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // The first ancestor of q which appears in
        // p's ancestor set() is their lowest common ancestor.
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;

    }
}
