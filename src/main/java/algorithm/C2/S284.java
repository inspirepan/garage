package algorithm.C2;

import java.util.Iterator;

public class S284 {
    class PeekingIterator implements Iterator<Integer> {
        // 大致思路就是再设置一个快一步的it、

        Iterator<Integer> fast;
        boolean slowHasNext;
        Integer slowNext;

        public PeekingIterator(Iterator<Integer> iterator) {
            fast = iterator;
            slowHasNext = fast.hasNext();
            if (slowHasNext) {
                slowNext = fast.next();
            } else {
                slowNext = null;
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return slowNext;
        }

        @Override
        public Integer next() {
            int temp = slowNext;
            if (fast.hasNext()) {
                slowNext = fast.next();
                slowHasNext = true;
            } else {
                slowNext = null;
                slowHasNext = false;
            }

            return temp;
        }

        @Override
        public boolean hasNext() {
            return slowHasNext;
        }
    }
}
