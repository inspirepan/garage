package algorithm.c7;

import java.util.LinkedList;

public class S705 {

    class MyHashSet {

        private final int F = 13;
        private final int SIZE = (int) Math.pow(2, F);
        private final LinkedList<Integer>[] table = new LinkedList[SIZE];

        public MyHashSet() {

        }

        public void add(int key) {
            int index = key & (SIZE - 1);
            var list = table[index];
            if (list == null) {
                list = new LinkedList<>();
                table[index] = list;
            }
            boolean flag = false;
            for (int n : list) {
                if (n == key) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list.add(key);
            }
        }

        public void remove(int key) {
            var list = table[key & (SIZE - 1)];
            if (list == null) {
                return;
            }
            var it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == key) {
                    it.remove();
                }
            }
        }

        public boolean contains(int key) {
            var list = table[key & (SIZE - 1)];
            if (list == null) {
                return false;
            }
            for (int n : list) {
                if (n == key) {
                    return true;
                }
            }
            return false;
        }
    }
}
