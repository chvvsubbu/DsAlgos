package patterns.trees;

import java.util.Stack;

public class MergeTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2){
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        t1.data += t2.data;
        t1.left = mergeTrees(t1 != null? t1.left: null, t2 != null? t2.right: null);
        t1.right = mergeTrees(t1 != null? t1.right: null, t2 != null? t2.right: null);
        return t1;
    }

    public TreeNode mergeTreesIterate(TreeNode t1, TreeNode t2){
        if(t1 == null) return t2;

        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1, t2});

        while ( !stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if(t[0] == null || t[1] == null)
                continue;
            t[0].data +=t[1].data;
            if(t[0].left == null){
                t[0].left = t[1].left;
            }else {
                stack.push(new TreeNode[]{t[0].left, t[1].left});
            }

            if(t[0].right == null){
                t[0].right = t[1].right;
            }else {
                stack.push(new TreeNode[]{t[0].right, t[1].right});
            }
        }
        return t1;
    }


}
