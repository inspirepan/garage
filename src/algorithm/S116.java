package algorithm;

import dataStructure.Node;

public class S116 {
    public Node connect(Node root) {
        if (root == null)
            return root;
        else if (root.left == null)
            return root;
        root.left.next = root.right;
        if(root.next!=null)
            root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }

}