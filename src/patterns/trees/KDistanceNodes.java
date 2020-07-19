package patterns.trees;

import com.sun.tools.javac.util.ListBuffer;

import java.util.*;

public class KDistanceNodes {

    public static  List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return  result;
        if(K==0 ) {
            result.add(root.data);
            return  result;
        }

        HashSet<TreeNode> seen = new HashSet<>();
        TreeNode parent = getParent(root,target);
        Queue<TreeNode > queue = new LinkedList<>();
        if(parent != null){
            queue.offer(parent);
            seen.add(parent);
        }
        if (target.left != null) {
            queue.offer(target.left);
            seen.add(target.left);
        }

        if (target.right != null) {
            queue.offer(target.right);
            seen.add(target.right);
        }
        seen.add(target);
        int level = 0;
        while(!queue.isEmpty()) {
            level++;
            int size = queue.size();
            if (level == K) {
                for (int i = 0; i < size; i++) {
                    result.add(queue.poll().data);
                }
                return result;
            }

            for (int i = 0; i < size; i++) {

                TreeNode tempNode = queue.poll();
                TreeNode tempParent = getParent(root, tempNode);
                if (tempParent != null && !seen.contains(tempParent)) {
                    queue.offer(tempParent);
                    seen.add(tempParent);
                }
                if (tempNode.left != null && !seen.contains(tempNode.left)) {
                    queue.offer(tempNode.left);
                    seen.add(tempNode.left);
                }

                if ( tempNode.right != null && !seen.contains(tempNode.right)) {
                    queue.offer(tempNode.right);
                    seen.add(tempNode.right);
                }
            }
        }
        return result;

    }

    private static TreeNode getParent(TreeNode root, TreeNode target) {

        if(root == null) return null;
        if(root == target) return null;
        if(root.left == target || root.right == null) return root;
        TreeNode leftNode = getParent(root.left, target);
        if(leftNode != null)
            return leftNode;
        TreeNode rightNode = getParent(root.right, target);
        return rightNode;
    }


    public  static Map<TreeNode, TreeNode> parent = new HashMap<>();

    public static  void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    public static List<Integer> distanceK2(TreeNode root, TreeNode target, int K) {
        dfs(root, null);
        Queue<TreeNode> queue = new LinkedList();
        queue.add(null);
        queue.add(target);

        Set<TreeNode> seen = new HashSet();
        seen.add(target);
        seen.add(null);

        int dist = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (dist == K) {
                    List<Integer> ans = new ArrayList();
                    for (TreeNode n: queue)
                        ans.add(n.data);
                    return ans;
                }
                queue.offer(null);
                dist++;
            } else {
                if (!seen.contains(node.left)) {
                    seen.add(node.left);
                    queue.offer(node.left);
                }
                if (!seen.contains(node.right)) {
                    seen.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode par = parent.get(node);
                if (!seen.contains(par)) {
                    seen.add(par);
                    queue.offer(par);
                }
            }
        }

        return new ArrayList<Integer>();
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        List<Integer> res = distanceK(root, root.left, 2);
        System.out.println("K distance nodes: " +res);
        res = distanceK2(root, root.left, 2);
        System.out.println("K distance nodes: " +res);
    }
}
