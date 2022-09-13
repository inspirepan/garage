package algorithm.C7;

import java.util.LinkedList;

public class S706 {

    class MyHashMap {

        private final int F = 13;
        private final int NOT_FOUND = -1;
        private final int SIZE = (int) Math.pow(2, F);
        private final LinkedList<IntegerEntry>[] table = new LinkedList[SIZE];
        public MyHashMap() {

        }

        public void put(int key, int val) {
            int index = key & (SIZE - 1);
            var list = table[index];
            if (list == null) {
                list = new LinkedList<>();
                table[index] = list;
            }
            boolean flag = false;
            for (IntegerEntry i : list) {
                if (i.key == key) {
                    flag = true;
                    i.val = val;
                    break;
                }
            }
            if (!flag) {
                list.add(new IntegerEntry(key, val));
            }
        }

        public void remove(int key) {
            var list = table[key & (SIZE - 1)];
            if (list == null) {
                return;
            }
            var it = list.iterator();
            while (it.hasNext()) {
                if (it.next().key == key) {
                    it.remove();
                }
            }
        }

        public int get(int key) {
            var list = table[key & (SIZE - 1)];
            if (list == null) {
                return NOT_FOUND;
            }
            for (IntegerEntry i : list) {
                if (i.key == key) {
                    return i.val;
                }
            }
            return NOT_FOUND;
        }

        class IntegerEntry {
            int key;
            int val;

            IntegerEntry(int _key, int _val) {
                this.key = _key;
                this.val = _val;
            }
        }
    }
}
