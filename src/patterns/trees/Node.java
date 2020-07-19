package patterns.trees;

import java.util.List;

public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        this.val = _val;
        this.children = _children;
    }

}
