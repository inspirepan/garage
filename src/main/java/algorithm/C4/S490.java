package algorithm.C4;

import java.util.*;

public class S490 {
    static final int START = 0;
    static final int LEFT = 1;
    static final int RIGHT = 2;
    static final int UP = 3;
    static final int DOWN = 4;
    boolean[][] visited;

    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        // 深度优先搜索每一种可能情况
        if (maze[dest[0]][dest[1]] == 1) return false;
        this.visited = new boolean[maze.length][maze[0].length];
        // 怎么判断完全不能停下来？
        return dfs(maze, start, dest, START);
    }

    boolean dfs(int[][] maze, int[] start, int[] dest, int lastFrom) {
        if (start[0] == dest[0] && start[1] == dest[1]) return true;
        int x = start[0];
        int y = start[1];
        if (visited[x][y]) return false;
        visited[x][y] = true;
        if (lastFrom != RIGHT) {
            int leftY = y;
            while (leftY >= 0 && maze[x][leftY] == 0) leftY--;
            if (++leftY != y && !visited[x][leftY] && dfs(maze, new int[]{x, leftY}, dest, LEFT)) return true;
        }
        if (lastFrom != LEFT) {
            int rightY = y;
            while (rightY < maze[0].length && maze[x][rightY] == 0) rightY++;
            if (--rightY != y && !visited[x][rightY] && dfs(maze, new int[]{x, rightY}, dest, RIGHT)) return true;
        }
        if (lastFrom != DOWN) {
            int upX = x;
            while (upX >= 0 && maze[upX][y] == 0) upX--;
            if (++upX != x && !visited[upX][y] && dfs(maze, new int[]{upX, y}, dest, UP)) return true;
        }
        if (lastFrom != UP) {
            int downX = x;
            while (downX < maze.length && maze[downX][y] == 0) downX++;
            int[] ns = {--downX, y};
            if (downX != x && !visited[downX][y] && dfs(maze, new int[]{downX, y}, dest, DOWN)) return true;
        }
        return false;
    }
}