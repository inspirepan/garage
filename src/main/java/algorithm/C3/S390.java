package algorithm.C3;

import java.util.Iterator;
import java.util.LinkedList;

public class S390 {
    public int lastRemaining(int n) {
        // 模拟的方法超时了
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        boolean left = true;
        while (list.size() > 1) {
            int index = 0;
            Iterator<Integer> it = list.iterator();
            boolean remove = left || ((list.size() & 1) == 1);
            left = !left;
            while (it.hasNext()) {
                it.next();
                if (remove) it.remove();
                remove = !remove;
            }
        }
        return list.get(0);
    }

    public int lastRemaining2(int n) {
        // 不需要模拟，只需要记住第一个元素的变化就行了，step！
        int first = 1;
        int step = 1;
        int remain = n;
        boolean isLeft = true;
        while (remain > 1) {
            if (isLeft || ((remain & 1) == 1)) {
                first += step;
            }
            isLeft = !isLeft;
            step <<= 1;
            remain >>= 1;
        }
        return first;
    }
}
