package algorithm.c1;

/* LRUCache */
class S146 {
    class LRUCache {

        final int THRESHOLD;
        Entry head = new Entry();
        Entry tail = new Entry();
        Entry[] tables;
        int size = 0;

        public LRUCache(int capacity) {
            this.THRESHOLD = capacity;
            head.lNext = tail;
            tail.lPrev = head;
            this.tables = new Entry[1 << 10];
        }

        public int get(int key) {
            // find
            int hash = key & ((1 << 10) - 1);
            Entry p = tables[hash];
            while (p != null) {
                if (p.key == key) {
                    moveToHead(p);
                    return p.value;
                }
                p = p.next;
            }
            return -1;
        }

        void moveToHead(Entry e) {
            e.lNext.lPrev = e.lPrev;
            e.lPrev.lNext = e.lNext;
            e.lNext = head.lNext;
            e.lPrev = head;
            head.lNext.lPrev = e;
            head.lNext = e;
        }

        void insertToHead(Entry e) {
            e.lNext = head.lNext;
            e.lPrev = head;
            head.lNext.lPrev = e;
            head.lNext = e;
        }

        public void put(int key, int value) {
            int hash = key & ((1 << 10) - 1);
            Entry p = tables[hash];
            Entry prev = null;
            while (p != null) {
                if (p.key == key) {
                    p.value = value;
                    moveToHead(p);
                    return;
                }
                prev = p;
                p = p.next;
            }
            Entry n = new Entry(key, value);
            n.next = null;
            n.prev = prev;
            if (prev == null) {
                tables[hash] = n;
            } else {
                prev.next = n;
            }
            insertToHead(n);
            if (++size > THRESHOLD) {
                removeTail();
            }
        }

        void removeTail() {
            Entry r = tail.lPrev;
            // remove from lru
            r.lPrev.lNext = tail;
            tail.lPrev = r.lPrev;
            // remove from hash
            int hash = r.key & ((1 << 10) - 1);
            if (r.next == null && r.prev == null) {
                tables[hash] = null;
            } else if (r.prev == null) {
                tables[hash] = r.next;
                r.next.prev = null;
            } else if (r.next == null) {
                r.prev.next = null;
            } else {
                r.prev.next = r.next;
                r.next.prev = r.prev;
            }
            size--;
        }

        class Entry {
            int key;
            int value;
            Entry next;
            Entry prev;
            Entry lNext;
            Entry lPrev;

            Entry() {
                this.key = 0;
                this.value = 0;
            }

            Entry(int k, int v) {
                this.key = k;
                this.value = v;
            }
        }
    }
}
