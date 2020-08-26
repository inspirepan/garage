package algorithm;

import java.util.*;

/* 4.19 */

/**
 * @author panjx
 */
public class L51_60 {

    /**
     * 51
     */
    final List<List<String>> ans51 = new LinkedList<>();

    public static void printIntegerMatrix(int[][] matrix) {
        for (int[] k : matrix) {
            System.out.println(Arrays.toString(k));
        }
    }

    /**
     * 48
     *
     * @param matrix 输入
     */
    public void rotate(int[][] matrix) {
        int h = matrix.length;
        if (h == 1) {
            return;
        }
        /* 转置 */
        for (int i = 0; i < h; i++) {
            for (int j = i + 1; j < h; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        /* 镜像 */
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < h / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][h - 1 - j];
                matrix[i][h - 1 - j] = temp;
            }
        }
    }

    /*
     * 49 首先的想法是哈希表，每一种词都使用一个哈希表 这道题看出来很多方法完全不知道，比如map可以直接构造一个ArrayList
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>(60);
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String s2 = String.valueOf(ch);
            if (!map.containsKey(s2)) {
                map.put(s2, new ArrayList<>());
            }
            map.get(s2).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return ans51;
        }
        ArrayList<String> board = new ArrayList<>();
        for (int t = 0; t < n; t++) {
            board.add("....");
        }
        ans51.clear();
        backtrack51(0, board, n);
        return ans51;
    }

    public void backtrack51(int row, ArrayList<String> board, int border) {
        if (row == border) {
            System.out.println("★" + board);
            ans51.add(new ArrayList<>(board));
            // 这一点也太坑了吧
            return;
        }
        for (int column = 0; column < border; column++) {
            if (!isValid51(board, row, column, border)) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < border; k++) {
                if (k == column) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            String line = sb.toString();
            board.set(row, line);
            backtrack51(row + 1, board, border);
        }
    }

    public boolean isValid51(ArrayList<String> board, int row, int column, int border) {
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(column) == 'Q') {
                return false;
            }
        }
        for (int i = 1; i <= row; i++) {
            if (column - i > -1) {
                if (board.get(row - i).charAt(column - i) == 'Q') {
                    return false;
                }
            }
            if (column + i < border) {
                if (board.get(row - i).charAt(column + i) == 'Q') {
                    return false;
                }
            }
        }
        return true;
    }

    // 53
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int res = nums[0];
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            res = Math.max(curr, res);
        }
        return res;
    }

    /**
     * 54 用的递归，看答案可以标记走过的地方，控制转弯方向，太牛了
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new ArrayList<>();
        }
        int n = matrix[0].length;
        if (m == 1) {
            ArrayList<Integer> ans = new ArrayList<>(n);
            for (int i : matrix[0]) {
                ans.add(i);
            }
            return ans;
        }
        return spiralO(matrix, 0, 0, m - 1, n - 1);
    }

    public List<Integer> spiralO(int[][] matrix, int startRow, int startColumn, int oppositeRow,
                                 int oppositeColumn) {
        ArrayList<Integer> part = new ArrayList<>();
        if (startRow == oppositeRow) {
            for (int i = startColumn; i <= oppositeColumn; i++) {
                part.add(matrix[startRow][i]);
            }
            return part;
        }
        if (startColumn == oppositeColumn) {
            return part;
        }
        int i1 = startColumn;
        while (i1 <= oppositeColumn) {
            part.add(matrix[startRow][i1]);
            i1++;
        }
        int i2 = startRow + 1;
        while (i2 <= oppositeRow) {
            part.add(matrix[i2][oppositeColumn]);
            i2++;
        }
        int i3 = oppositeColumn - 1;
        while (i3 >= startColumn) {
            part.add(matrix[oppositeRow][i3]);
            i3--;
        }
        int i4 = oppositeRow - 1;
        while (i4 > startRow) {
            part.add(matrix[i4][startColumn]);
            i4--;
        }
        if (startRow + 1 == oppositeRow || startColumn + 1 == oppositeColumn) {
            return part;
        }
        List<Integer> subpart = spiralO(matrix, startRow + 1, startColumn + 1, oppositeRow - 1,
                oppositeColumn - 1);
        part.addAll(subpart);
        return part;
    }

    // 55
    public boolean canJump(int[] nums) {
        if (nums.length < 2) {
            return nums.length == 1;
        }
        if (nums[0] == 0) {
            return false;
        }
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && max <= i) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }


    // 58
    public int lengthOfLastWord(String s) {
        int l = s.length();
        if (l == 0) {
            return 0;
        }
        int count = 0;
        while (l >= 1 && s.charAt(l - 1) == ' ') {
            l--;
        }
        while (l >= 1 && s.charAt(l - 1) != ' ') {
            count++;
            l--;
        }
        return count;
    }

    // 59
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int j = 0, i = 1;
        while (i <= n * n) {
            for (int k = j; k < n - j; k++) {
                ans[j][k] = i++;
            }
            for (int k = j + 1; k < n - j; k++) {
                ans[k][n - j - 1] = i++;
            }
            for (int k = n - j - 2; k >= j; k--) {
                ans[n - j - 1][k] = i++;
            }
            for (int k = n - j - 2; k > j; k--) {
                ans[k][j] = i++;
            }
            j++;
        }
        return ans;
    }

    // 60
    public String getPermutation(int n, int k) {
        if (n == 1 && k == 1) {
            return "1";
        }
        int[] f = new int[]{2, 6, 24, 120, 720, 5040, 40320, 362880};
        int[] ans = new int[n];
        List<Integer> resNum = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            resNum.add(i + 1);
        }
        int residue = k - 1;
        for (int i = 0; i < n; i++) {
            if (n - i < 3) {
                if (residue == 0) {
                    ans[i] = resNum.remove(0);
                    ans[i + 1] = resNum.remove(0);
                } else {
                    ans[i + 1] = resNum.remove(0);
                    ans[i] = resNum.remove(0);
                }
                break;
            } else {
                int seq = residue / f[n - i - 3];
                System.out.println(seq);
                residue = residue % f[n - i - 3];
                int number = resNum.remove(seq);
                ans[i] = number;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append(i);
        }
        return sb.toString();
    }
}
