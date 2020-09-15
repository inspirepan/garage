package algorithm;

import java.util.*;

public class L62_78 {
    Stack<Integer> path;
    List<List<Integer>> res;



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
