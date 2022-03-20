package algorithm.C6;

import java.util.Arrays;
import java.util.LinkedList;

public class S682 {
    public int calPoints(String[] ops) {
        int i = 0;
        int sum = 0;
        LinkedList<Integer> list = new LinkedList<>();
        while (i < ops.length) {
            String op = ops[i];
            if (op.equals("C")) {
                list.removeLast();
            } else if (op.equals("D")) {
                list.add(list.get(list.size() - 1) * 2);
            } else if (op.equals("+")) {
                list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
            } else {
                list.add(Integer.parseInt(op));
            }
            i++;
        }
        for (int k : list) sum += k;
        return sum;
    }
}
