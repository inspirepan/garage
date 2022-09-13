package algorithm.c5;

import datastructure.Node;

public class S559 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null || root.children.size() == 0) {
            return 1;
        }
        int max = 0;
        for (Node child : root.children) {
            max = Math.max(maxDepth(child), max);
        }
        return max + 1;
    }
}
