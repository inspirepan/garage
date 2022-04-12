package algorithm.C3;

import java.util.*;

public class S379 {
    class PhoneDirectory {

        boolean[] used;
        int free = 0;
        LinkedList<Integer> freeList = new LinkedList<>();

        public PhoneDirectory(int maxNumbers) {
            used = new boolean[maxNumbers];
            Arrays.fill(used, true);
        }

        public int get() {
            if (free < used.length) {
                used[free] = false;
                return free++;
            }
            if (!freeList.isEmpty()) {
                int res = freeList.poll();
                used[res] = false;
                return res;
            }
            return -1;
        }

        public boolean check(int number) {
            return used[number];
        }

        public void release(int number) {
            // 要防止多次重复释放一个号码
            if (!used[number]) {
                used[number] = true;
                if (number < free) {
                    freeList.add(number);
                }
            }
        }
    }
}
