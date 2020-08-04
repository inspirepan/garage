package algorithm;

import datastructure.Node;

import java.util.*;

public class S133 {
    // 自己写的笨方法，还没优化过，但是耗时和官方的方法差不多
    private final Map<Integer, Node> nodeMap = new HashMap<>();
    private final Map<Integer, Boolean> finished = new HashMap<>();

    // 看了一遍题解后写的BFS
    public Node cloneGraph2(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> nodeMap2 = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node newNode = new Node(node.val);
        nodeMap2.put(node, newNode);
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            currNode.neighbors.forEach(neighbor -> {
                if (!nodeMap2.containsKey(neighbor)) {
                    nodeMap2.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                nodeMap2.get(currNode).neighbors.add(nodeMap2.get(neighbor));
            });
        }
        return nodeMap2.get(node);
    }

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        createCloneNodes(node);

        createCloneNeighbors(node);
        nodeMap.forEach((val, newNode) -> {
            System.out.println(newNode.val);
            System.out.println(newNode.neighbors);
        });
        return nodeMap.get(node.val);

    }

    private void createCloneNodes(Node node) {
        if (nodeMap.containsKey(node.val)) {
            return;
        }
        Node newNode = new Node(node.val);
        nodeMap.put(node.val, newNode);
        node.neighbors.forEach(this::createCloneNodes);
    }

    private void createCloneNeighbors(Node node) {
        if (finished.getOrDefault(node.val, false)) {
            return;
        }
        finished.put(node.val, true);
        List<Node> newNeighbors = new ArrayList<>();
        node.neighbors.forEach(neighbor -> {
            newNeighbors.add(nodeMap.get(neighbor.val));
            createCloneNeighbors(neighbor);
        });
        nodeMap.get(node.val).neighbors = newNeighbors;
    }
}