package algorithm;

import java.util.ArrayDeque;
import java.util.List;

/**
 * @author panjx
 */
public class S841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        var visited = new boolean[rooms.size()];
        visited[0] = true;
        var queue = new ArrayDeque<Integer>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int curr = queue.pop();
            rooms.get(curr).forEach(room -> {
                // 还尝试了stream的filter，原本3ms变成了8ms，因为filter是对每一个元素先判断是否在set内的，这样子set去重的效果就没了。
                if (!visited[room]) {
                    visited[room] = true;
                    queue.add(room);
                }
            });
        }
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
}
