package algorithm.c4;

import java.util.LinkedList;
import java.util.List;

public class S420 {
    // 这样写超时了，毕竟我是从1开始往后找的，完全就是模拟的
    // 实际上完全没有必要用list，一开始没想明白

    public int findKthNumber(int n, int k) {
        LinkedList<Integer> number = new LinkedList<>();
        number.add(1);
        // 第一个数操作0次
        while (--k > 0) {
            findNext(number, n);
        }
        return getNumber(number);
    }

    private void findNext(LinkedList<Integer> number, int n) {
        // 1. 尝试添加一位0，如果添加后不大于n就返回
        // 2. 否则移除这个0，将末位+1
        //   2.1 如果要进位，那么一直进位、然后删除进位后的0  这样肯定是小于n的  111999 112
        //   2.2 否则末位+1后 判断是否大于n    1116 -> 1117 -> 112
        //         如果大于n，那么移除最后一位，然后最后一位+1   1194 -> 1195 -> 119 + (1) -> 120 如果要进位、就在进位完成之后删除全部末尾的0
        //
        number.add(0);
        if (getNumber(number) <= n) {
            return;
        }
        number.removeLast();
        addOne(number);
        if (number.get(number.size() - 1) == 0) {
            int p = number.size() - 1;
            while (p >= 0 && number.get(p) == 0) {
                p--;
            }
            if (p == -1) {
                return; // 说明999不能变成9990，题目数据有误
            }
            // 移除p之后的
            int k = 0;
            var it = number.iterator();
            while (it.hasNext()) {
                it.next();
                if (k++ > p) {
                    it.remove();
                }
            }
        } else {
            if (getNumber(number) > n) {
                number.removeLast();
                addOne(number);
                if (number.get(number.size() - 1) == 0) {
                    int p = number.size() - 1;
                    while (p >= 0 && number.get(p) == 0) {
                        p--;
                    }
                    if (p == -1) {
                        return;
                    }
                    // 移除p之后的
                    int k = 0;
                    var it = number.iterator();
                    while (it.hasNext()) {
                        it.next();
                        if (k++ > p) {
                            it.remove();
                        }
                    }
                }
            }
        }
    }

    private int getNumber(List<Integer> list) {
        int k = 0;
        int sum = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            sum += Math.pow(10, k++) * list.get(i);
        }
        return sum;
    }

    private void addOne(LinkedList<Integer> number) {
        int p = number.size() - 1;
        while (p >= 0) {
            int d = number.get(p);
            if (d < 9) {
                number.set(p, d + 1);
                return;
            } else {
                number.set(p, 0);
                p--;
            }
        }
        number.addFirst(1);
    }
}
