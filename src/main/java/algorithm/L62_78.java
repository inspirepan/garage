package algorithm;

import java.util.*;

public class L62_78 {
    Stack<Integer> path;
    List<List<Integer>> res;

    public static void printIntegerMatrix(int[][] matrix) {
        for (int[] k : matrix) {
            System.out.println(Arrays.toString(k));
        }
    }

    public int uniquePaths(int m, int n) {
        System.out.println(m + " " + n);
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        if (m == 2 && n == 2) {
            return 2;
        }
        /*
         * 递归效率太低了 int ans = 0; ans += uniquePaths(m - 1, n); ans += uniquePaths(m, n -
         * 1); return ans; 换成组合方法，结果会溢出
         */
        int fn1 = 1;
        int fmn2m1 = 1;
        for (int i = 1; i <= m + n - 2; i++) {
            if (i <= n - 1) {
                fn1 *= i;
            }
            if (i > m - 1) {
                fmn2m1 *= i;
            }
        }
        System.out.println(fn1);
        System.out.println(fmn2m1);
        return fmn2m1 / fn1;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }
        boolean firstColumn = true, fireRow = true;
        int n = obstacleGrid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    if (j == 0) {
                        fireRow = false;
                    }
                    if (i == 0) {
                        firstColumn = false;
                    }
                } else {
                    if ((firstColumn && i == 0) || (fireRow && j == 0)) {
                        obstacleGrid[i][j] = 1;
                    } else if ((!firstColumn && i == 0) || (!fireRow && j == 0)) {
                        obstacleGrid[i][j] = 0;
                    } else {
                        obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
                    }
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }

    // 64
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        if (grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    grid[i][j] += 0;
                } else if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
                printIntegerMatrix(grid);
                System.out.println("  ");
            }
        }
        return grid[m - 1][n - 1];
    }

    // 65
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if (digits[n - 1] != 9) {
            digits[n - 1] += 1;
            return digits;
        }
        int k = n - 1;
        boolean carry = true;
        while (k > -1) {
            if (digits[k] == 9) {
                digits[k] = 0;
                k--;
                carry = true;
            } else {
                digits[k] += 1;
                return digits;
            }
        }
        if (carry) {
            int[] ans = new int[n + 1];
            ans[0] = 1;
            System.arraycopy(digits, 0, ans, 1, n + 1 - 1);
            return ans;
        } else {
            return digits;
        }

    }

    // 67
    public String addBinary(String a, String b) {
        int lena = a.length();
        int lenb = b.length();
        int lenAns = Math.max(lena, lenb) + 1;
        int[] ans = new int[lenAns];
        int carry = 0;
        int i = 0;
        while (i < Math.max(lena, lenb)) {
            int digitA = Character.getNumericValue(a.charAt(lena - 1 - i));
            int digitB = Character.getNumericValue(b.charAt(lenb - 1 - i));
            if (i < lena && i < lenb) {
                ans[lenAns - 1 - i] = (digitA + digitB + carry) % 2;
                carry = (digitA + digitB + carry) / 2;
            } else if (i >= lena) {
                ans[lenAns - 1 - i] = (digitB + carry) % 2;
                carry = (digitB + carry) / 2;
            } else {
                ans[lenAns - 1 - i] = (digitA + carry) % 2;
                carry = (digitA + carry) / 2;
            }
            i++;
        }
        if (carry == 1) {
            ans[0] = 1;
            StringBuilder sb = new StringBuilder();
            for (int k : ans) {
                sb.append(k);
            }
            return sb.toString();
        } else {
            StringBuilder sb = new StringBuilder();
            for (int k = 1; k < lenAns; k++) {
                sb.append(ans[k]);
            }
            return sb.toString();
        }
    }

    /* 69 二分法算平方根, 边界还是容易错 */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x <= 2) {
            return 1;
        }
        int min = 2;
        int max = x / 2;
        while (max >= min) {
            int mid = (max - min) / 2 + min;
            if (x / mid >= mid) {
                min = mid + 1;
            } else if (x / mid < mid) {
                max = mid - 1;
            }
        }
        return max;
    }

    /* 72 动态规划, dp[i][j]表示word1前i个字符完全转换成word2前j个字符的最少步数 */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n * m == 0) {
            return n + m;
        }
        int[][] d = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            d[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            d[0][j] = j;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = d[i - 1][j] + 1;
                int down = d[i][j - 1] + 1;
                int leftDown = d[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    leftDown += 1;
                }
                d[i][j] = Math.min(left, Math.min(down, leftDown));

            }
        }
        return d[n][m];
    }

    /*
     * 73 矩阵置零 nice啊, 这次自己想出了标准答案,就是用首行首列做记录, 两个布尔变量用来判断首行首列本身的情况,最后还要单独处理[0][0]
     */
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        if (matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        /*
         * 用第一行来记录列归零情况 先判断第一行本身是否含0
         */
        boolean zeroInRow0 = false;
        for (int k = 0; k < n; k++) {
            if (matrix[0][k] == 0) {
                zeroInRow0 = true;
                break;
            }
        }
        boolean zeroInColumn0 = false;
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                zeroInColumn0 = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int k = 1; k < n; k++) {
            if (matrix[0][k] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][k] = 0;
                }
            } else {
                if (zeroInRow0) {
                    matrix[0][k] = 0;
                }
            }
        }
        for (int l = 1; l < m; l++) {
            if (matrix[l][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[l][j] = 0;
                }
            } else {
                if (zeroInColumn0) {
                    matrix[l][0] = 0;
                }
            }
        }
        if (zeroInColumn0 || zeroInRow0) {
            matrix[0][0] = 0;
        }
    }

    // 74
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        int begin = 0;
        int mid;
        int end = m * n - 1;
        while (end > begin) {
            mid = (begin + end) / 2;
            System.out.println(matrix[mid / n][mid % n]);
            if (matrix[mid / n][mid % n] < target) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return matrix[begin / n][begin % n] == target;
    }

    // 76
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        int[] freqT = new int[58];
        int[] freqS = new int[58];
        int lenT = t.length(), lenS = s.length(), ansLeft = -1, ansRight = lenS, left = 0, right = -1;
        for (int i = 0; i < lenT; i++) {
            freqT[t.charAt(i) - 'A']++;
        }
        while (left <= lenS - lenT && right < lenS) {
            System.out.println(s.substring(left, right + 1));
            int lenSub = right - left + 1;
            if (lenSub == lenT) {
                int k = 0;
                while (k < 58) {
                    if (freqS[k] < freqT[k]) {
                        right++;
                        if (right < lenS) {
                            freqS[s.charAt(right) - 'A']++;
                        }
                        break;
                    }
                    k++;
                }
                if (k == 58) {
                    return s.substring(left, right + 1);
                }
            } else if (lenSub < lenT) {
                right++;
                if (right < lenS) {
                    freqS[s.charAt(right) - 'A']++;
                }
            } else {
                int k = 0;
                while (k < 58) {
                    if (freqS[k] < freqT[k]) {
                        right++;
                        if (right < lenS) {
                            freqS[s.charAt(right) - 'A']++;
                        }
                        break;
                    }
                    k++;
                }
                if (k == 58) {
                    if ((right - left) < (ansRight - ansLeft)) {
                        ansLeft = left;
                        ansRight = right;
                    }
                    freqS[s.charAt(left) - 'A']--;
                    left++;
                }
            }
        }
        return ansLeft == -1 ? "" : s.substring(ansLeft, ansRight + 1);
    }

    // 77
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (k == 0 || n <= 0) {
            return ans;
        }
        if (k == n) {
            List<Integer> t = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                t.add(i);
            }
            ans.add(t);
            return ans;
        }
        res = new LinkedList<>();
        path = new Stack<>();
        dfs77(n, k, 1);
        return res;
    }

    public void dfs77(int n, int k, int pos) {
        System.out.println(n + " " + k + pos);
        if (k == 0) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = pos; i <= n - k + 1; i++) {
            path.push(i);
            dfs77(n, k - 1, i + 1);
            path.pop();
        }
    }

    // 78
    public List<List<Integer>> subsets(int[] nums) {
        res = new LinkedList<>();
        if (nums.length == 0) {
            return res;
        }
        res.add(Collections.emptyList());
        path = new Stack<>();
        for (int i = 1; i <= nums.length; i++) {
            dfs78(nums, i, 0);
        }
        return res;
    }

    public void dfs78(int[] nums, int subsetLength, int pos) {
        Arrays.sort(nums); // 第90题需要加上这一句
        if (subsetLength == 0) {
            res.add(new LinkedList<>(path));
            System.out.println(path);
            return;
        }
        for (int i = pos; i < nums.length - subsetLength + 1; i++) {
            int mark = 0;
            if (i > pos && nums[i] == nums[i - 1]) {
                mark = 100; // 第90题需要加上这一句
            }
            path.push(mark + nums[i]);
            dfs78(nums, subsetLength - 1, i + 1);
            path.pop();
        }
    }

}
