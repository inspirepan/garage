package algorithm;

import java.util.*;

/* 4.19 */

public class S51_60 {

    // 51
    List<List<String>> ans51 = new LinkedList<>();

    public static void printIntegerMatrix(int[][] matrix) {
        for (int[] k : matrix)
            System.out.println(Arrays.toString(k));
    }

    // 48
    public void rotate(int[][] matrix) {
        int h = matrix.length;
        if (h == 1)
            return;
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
        Map<String, List<String>> map = new HashMap<String, List<String>>();
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
        if (n < 1)
            return ans51;
        ArrayList<String> board = new ArrayList<>();
        for (int t = 0; t < n; t++)
            board.add("....");
        ans51.clear();
        backtrack51(0, board, n);
        return ans51;
    }

    public void backtrack51(int row, ArrayList<String> board, int border) {
        if (row == border) {
            System.out.println("★" + board);
            ans51.add(new ArrayList<>(board)); // 这一点也太坑了吧
            return;
        }
        for (int column = 0; column < border; column++) {
            if (!isValid51(board, row, column, border))
                continue;
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < border; k++) {
                if (k == column)
                    sb.append('Q');
                else
                    sb.append('.');
            }
            String line = sb.toString();
            board.set(row, line);
            backtrack51(row + 1, board, border);
        }
    }

    public boolean isValid51(ArrayList<String> board, int row, int column, int border) {
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(column) == 'Q')
                return false;
        }
        for (int i = 1; i <= row; i++) {
            if (column - i > -1) {
                if (board.get(row - i).charAt(column - i) == 'Q')
                    return false;
            }
            if (column + i < border) {
                if (board.get(row - i).charAt(column + i) == 'Q')
                    return false;
            }
        }
        return true;
    }

    // 53
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int res = nums[0];
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            res = Math.max(curr, res);
        }
        return res;
    }

    /*
     * 54 用的递归，看答案可以标记走过的地方，控制转弯方向，太牛了
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return new ArrayList<>();
        int n = matrix[0].length;
        if (m == 1) {
            ArrayList<Integer> ans = new ArrayList<>(n);
            for (int i : matrix[0])
                ans.add(i);
            return ans;
        }
        return spiralO(matrix, 0, 0, m - 1, n - 1);
    }

    public List<Integer> spiralO(int[][] matrix, int start_row, int start_column, int opposite_row,
            int oppposite_column) {
        ArrayList<Integer> part = new ArrayList<>();
        if (start_row == opposite_row) {
            for (int i = start_column; i <= oppposite_column; i++)
                part.add(matrix[start_row][i]);
            return part;
        }
        if (start_column == oppposite_column) {
            return part;
        }
        for (int i1 = start_column; i1 <= oppposite_column; i1++)
            part.add(matrix[start_row][i1]);
        for (int i2 = start_row + 1; i2 <= opposite_row; i2++)
            part.add(matrix[i2][oppposite_column]);
        for (int i3 = oppposite_column - 1; i3 >= start_column; i3--)
            part.add(matrix[opposite_row][i3]);
        for (int i4 = opposite_row - 1; i4 > start_row; i4--)
            part.add(matrix[i4][start_column]);
        if (start_row + 1 == opposite_row || start_column + 1 == oppposite_column)
            return part;
        List<Integer> subpart = spiralO(matrix, start_row + 1, start_column + 1, opposite_row - 1,
                oppposite_column - 1);
        part.addAll(subpart);
        return part;
    }

    // 55
    public boolean canJump(int[] nums) {
        if (nums.length < 2)
            return nums.length == 1;
        if (nums[0] == 0)
            return false;
        int max_ = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && max_ <= i)
                return false;
            max_ = Math.max(max_, i + nums[i]);
        }
        return true;
    }

    // 56
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] interval : intervals) {
            int t = map.getOrDefault(interval[0], 0);
            map.put(interval[0], t + 1);
            int h = map.getOrDefault(interval[1], 0);
            map.put(interval[1], h - 1);
        }
        Object[] keyArr = map.keySet().toArray();
        Arrays.sort(keyArr);
        boolean inInterval = false;// 状态
        int sum = 0;// 求和
        List<int[]> res = new ArrayList<>();// 记录答案
        int[] ans = new int[2];
        for (Object k : keyArr) {
            int val = map.get(k);
            if (val == 0) {
                if (!inInterval) {
                    ans[0] = (int) k;
                    ans[1] = (int) k;
                    res.add(ans.clone());
                }
                continue;
            }
            if (sum == 0 && !inInterval) {
                ans[0] = (int) k;
                inInterval = true;
            }
            sum += val;
            if (sum == 0 && inInterval) {
                ans[1] = (int) k;
                inInterval = false;
                res.add(ans.clone());
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    // 57
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int nS = newInterval[0];
        int nE = newInterval[1];
        if (intervals.length == 0) {
            int[][] ans = new int[1][2];
            ans[0] = newInterval;
            return ans;
        }
        List<int[]> ans = new ArrayList<>();
        int StartPoint = 0;
        boolean S_in = false;
        boolean E_in = false;
        for (int i = 0; i < intervals.length; i++) {
            if (!S_in && intervals[i][1] >= nS) {
                StartPoint = Math.min(intervals[i][0], nS);
                if (intervals[i][1] < nE) {
                    S_in = true;
                    if (i == intervals.length - 1) {
                        ans.add(new int[] { StartPoint, nE });
                        break;
                    }
                    continue;
                } else if (intervals[i][0] > nE) {
                    S_in = true;
                    E_in = true;
                    ans.add(new int[] { nS, nE });
                } else {
                    ans.add(new int[] { StartPoint, intervals[i][1] });
                    S_in = true;
                    E_in = true;
                    continue;
                }
            }
            if (!E_in && intervals[i][0] > nE) {
                ans.add(new int[] { StartPoint, nE });
                E_in = true;
            } else if (!E_in && intervals[i][1] >= nE) {
                ans.add(new int[] { StartPoint, intervals[i][1] });
                E_in = true;
                continue;
            } else if (S_in && !E_in && intervals[i][1] < nE) {
                if (i == intervals.length - 1)
                    ans.add(new int[] { StartPoint, nE });
                continue;
            }
            ans.add(intervals[i].clone());
            if (i == intervals.length - 1 && !S_in && !E_in)
                ans.add(new int[] { nS, nE });
        }
        return ans.toArray(new int[ans.size()][]);
    }

    // 58
    public int lengthOfLastWord(String s) {
        int l = s.length();
        if (l == 0)
            return 0;
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
            for (int k = j; k < n - j; k++)
                ans[j][k] = i++;
            for (int k = j + 1; k < n - j; k++)
                ans[k][n - j - 1] = i++;
            for (int k = n - j - 2; k >= j; k--)
                ans[n - j - 1][k] = i++;
            for (int k = n - j - 2; k > j; k--)
                ans[k][j] = i++;
            j++;
        }
        return ans;
    }

    // 60
    public String getPermutation(int n, int k) {
        if (n == 1 && k == 1)
            return "1";
        int[] JieCheng = new int[] { 2, 6, 24, 120, 720, 5040, 40320, 362880 };
        int[] ans = new int[n];
        List<Integer> resNum = new ArrayList<>();
        for (int i = 0; i < n; i++)
            resNum.add(i + 1);
        int residue = k - 1;
        for (int i = 0; i < n; i++) {
            if (n - i < 3) {
                if (residue == 0) {
                    ans[i] = resNum.remove(0);
                    ans[i + 1] = resNum.remove(0);
                    break;
                } else {
                    ans[i + 1] = resNum.remove(0);
                    ans[i] = resNum.remove(0);
                    break;
                }
            } else {
                int seq = residue / JieCheng[n - i - 3];
                System.out.println(seq);
                residue = residue % JieCheng[n - i - 3];
                int number = resNum.remove(seq);
                ans[i] = number;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : ans)
            sb.append(i);
        return sb.toString();
    }
}
