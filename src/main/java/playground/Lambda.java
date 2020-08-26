package playground;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {
        Deque<Integer> test = new LinkedList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        System.out.println(test.pop());
        test.offer(100);
        System.out.println(test);
        System.out.println(test.peek());

    }
}


