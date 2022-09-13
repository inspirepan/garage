package algorithm.c15;

import java.util.LinkedList;

public class S1535 {
    public int getWinner(int[] arr, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int max = 0;
        for (int i : arr) {
            list.add(i);
            max = Math.max(max, i);
        }
        int count = 0;
        int len = arr.length;
        // 如果要求比其他的都大，那就是最大值
        if (k >= len - 1) {
            return max;
        }
        // 用队列模拟
        while (count < k) {
            if (list.getFirst() >= list.get(1)) {
                // 大于
                count++;
                list.offerLast(list.get(1));
                list.remove(1);
            } else {
                count = 1;
                list.offerLast(list.peek());
                list.removeFirst();
            }
        }
        return list.peekFirst();
    }
}
