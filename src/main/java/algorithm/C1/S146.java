package algorithm.C1;

/* LRUCache */
class S146 {
    class LRUCache {
        private int N;
        Node head;
        Node tail;
        int K = 10;
        int tableSize = 2 << K;
        Node[] table = new Node[tableSize];
        int size = 0;

        public LRUCache(int capacity) {
            this.N = capacity;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            int index = key & (tableSize - 1);
            Node e = table[index];
            while (e != null) {
                if (e.key == key) {
                    upToHead(e);
                    return e.val;
                }
                e = e.hashNext;
            }
            return -1;
        }

        public void put(int key, int value) {
            Node n = new Node(key, value);
            // hash
            int index = key & (tableSize - 1);
            Node e = table[index];
            boolean found = false;
            if (e == null) {
                table[index] = n;
            } else if (e.key == key) {
                found = true;
                e.val = value;
                upToHead(e);
            } else {
                while (e.hashNext != null) {
                    e = e.hashNext;
                    if (e.key == key) {
                        found = true;
                        e.val = value;
                        upToHead(e);
                        break;
                    }
                }
                // assert new node
                if (!found) {
                    e.hashNext = n;
                    n.hashPrev = e;
                }
            }
            if (found) return;
            // lru list head
            n.prev = head;
            n.next = head.next;
            head.next.prev = n;
            head.next = n;
            // capacity
            if (size == N) {
                // remove tail;
                removeTail();
            } else {
                size++;
            }
        }

        private void upToHead(Node e) {
            // move e to list head
            e.prev.next = e.next;
            e.next.prev = e.prev;
            head.next.prev = e;
            e.next = head.next;
            head.next = e;
            e.prev = head;
        }

        private void removeTail() {
            // remove from lru list
            Node remove = tail.prev;
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
            // remove from hash
            if (remove.hashNext == null && remove.hashPrev == null) table[remove.key & (tableSize - 1)] = null;
            else if (remove.hashPrev == null) {
                table[remove.key & (tableSize - 1)] = remove.hashNext;
                remove.hashNext.hashPrev = null;
            } else if (remove.hashNext == null) {
                remove.hashPrev.hashNext = null;
            } else {
                Node prev = remove.hashPrev;
                Node next = remove.hashNext;
                prev.hashNext = next;
                next.hashPrev = prev;
            }
        }

        class Node {
            int key;
            int val;
            Node next;
            Node prev;

            Node hashNext;
            Node hashPrev;

            Node() {

            }

            Node(int _key, int _val) {
                this.key = _key;
                this.val = _val;
            }
        }
    }
}
