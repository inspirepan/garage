package algorithm.C3;

import java.util.LinkedList;

public class S331 {
    public boolean isValidSerialization(String preorder) {
        String[] ss = preorder.split(",");
        // 栈里面的数字代表的是左右节点访问数
        LinkedList<Integer> stack = new LinkedList<>();
        // 因为统计了全部null，因此完整的序列必然最后是空的stack，或者中间stack有缺失就代表不行
        // 先处理根节点
        if (ss.length == 1) {
            return ss[0].equals("#");
        }
        if (ss[0].equals("#")) return false;
        // 根节点
        stack.push(2);
        for (int i = 1; i < ss.length; i++) {
            if (stack.isEmpty()) return false;
            if (stack.peek() == 2) {
                // 当前在栈顶节点的左孩子
                stack.set(0, 1);
            } else if (stack.peek() == 1) {
                // 栈顶节点的右孩子
                stack.pop();
            }
            // 如果当前是数字，插入一个节点
            if (!ss[i].equals("#")) stack.push(2);
        }
        return stack.isEmpty();
    }
}
