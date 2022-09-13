package algorithm.c4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S406 {
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
        // 身高从高到低排序，相同身高k小在前
        List<int[]> ans = new ArrayList<int[]>();
        for (int[] person : people) {
            // 对于每一个person，经过排序之后，轮到它的时候，ans列表中已经全部是身高大于等于它的了
            // 这个时候这需要按照索引插入进去即可，而后续person因为身高小于它，所以对它的次序没有影响
            // 相同身高的k从小到大排列，也可以避免后续对前面的影响
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}

