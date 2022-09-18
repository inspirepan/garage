package algorithm.c9;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author : panjixiang
 * @since : 2022/9/18
 */
public class S950 {
    class Solution {
        public int[] deckRevealedIncreasing(int[] deck) {
            Arrays.sort(deck);
            int len = deck.length;
            int[] res = new int[len];
            Deque<Integer> queue = new ArrayDeque<>();
            queue.add(deck[len - 1]);
            for (int i = len - 2; i >= 0; i--) {
                int last = queue.pollLast();
                queue.offerFirst(last);
                queue.offerFirst(deck[i]);
            }
            for (int i1 = 0; i1 < len; i1++) {
                res[i1] = queue.pollFirst();
            }
            return res;
        }
    }
}
