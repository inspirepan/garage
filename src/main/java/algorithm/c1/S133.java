package algorithm.c1;

import datastructure.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class S133 {
    public Node cloneGraph(Node node) {
        // BFS
        if (node == null) {
            return node;
        }
        Map<Node, Node> clonedNodeMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node newNode = new Node(node.val);
        clonedNodeMap.put(node, newNode);

        queue.offer(node);
        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            currNode.neighbors.forEach(neighbor -> {
                if (!clonedNodeMap.containsKey(neighbor)) {
                    clonedNodeMap.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                clonedNodeMap.get(currNode).neighbors.add(clonedNodeMap.get(neighbor));
            });
        }
        return clonedNodeMap.get(node);
    }
}