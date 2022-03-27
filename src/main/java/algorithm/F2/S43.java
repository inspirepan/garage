package algorithm.F2;

import datastructure.TreeNode;

import java.util.*;

public class S43 {
    class CBTInserter {

        int size;
        List<List<TreeNode>> list = new ArrayList<>();
        int level;
        int levelCount;

        public CBTInserter(TreeNode r) {
            size = 0;
            level = 0;
            levelCount = 0;
            list.add(new ArrayList<>());
            if (r == null) return;
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(r);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                list.get(level).add(node);
                if (++levelCount == (1 << level)) {
                    // 下一层
                    list.add(new ArrayList<>());
                    level++;
                    levelCount = 0;
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size++;
            }
        }

        public int insert(int v) {
            TreeNode n = new TreeNode(v);
            // 根据当前的level和levelCount计算

            list.get(level).add(n);
            // getParent
            TreeNode parent = list.get(level - 1).get(levelCount >> 1);
            if ((levelCount & 1) == 0) {
                parent.left = n;
            } else {
                parent.right = n;
            }
            if (++levelCount == (1 << level)) {
                level++;
                list.add(new ArrayList<>());
                levelCount = 0;
            }
            return parent.val;
        }

        public TreeNode get_root() {
            return list.get(0).get(0);
        }
    }
}
