package algorithm.c9;

import datastructure.TreeNode;

public class S993 {
    class Solution {

        public boolean isCousins(TreeNode root, int x, int y) {
            var node1 = new nodeInfo(-4,-2);
            var node2 = new nodeInfo(-1,-3);
            getNodeInfo(node1, root, 0, x, -1);
            getNodeInfo(node2, root, 0, y, -1);
            return node1.height==node2.height && node1.parentNodeVal != node2.parentNodeVal;
        }

        class nodeInfo{
            int height;
            int parentNodeVal;

            nodeInfo(int _height, int _parentNodeVal){
                this.height = _height;
                this.parentNodeVal = _parentNodeVal;
            }
        }

        private void getNodeInfo(nodeInfo nodeInfo, TreeNode node, int height, int target, int parent){
            if (node==null){
                return;
            }
            if (node.val == target){
                nodeInfo.height = height;
                nodeInfo.parentNodeVal = parent;
                return;
            }
            getNodeInfo(nodeInfo, node.left, height+1, target, node.val);
            getNodeInfo(nodeInfo, node.right, height+1, target, node.val);
        }
    }
}