package Algorithm;

import java.util.*;

/* 4.18 */

public class S43_46 {
    /* 46题DFS，需要用一个状态记录数组，表示是否可以选用 */
    int n;
    Stack<Integer> path;
    List<List<Integer>> res;
    boolean[] state;

    /* 43 */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return new String("0");
        }
        if (num1.equals("1"))
            return num2;
        else if (num2.equals("1"))
            return num1;
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int[] ans = new int[len1 + len2 + 2];
        for (int i = len1; i >= 0; i--) {
            for (int j = len2; j >= 0; j--) {
                int temp = Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j));
                temp += ans[i + j + 1];
                ans[i + j + 1] = temp % 10;
                ans[i + j] += temp / 10;

            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        // 去掉前导0
        while (i < ans.length - 1 && ans[i] == 0)
            i++;
        for (; i < ans.length; ++i)
            sb.append(ans[i]);
        return sb.toString();

    }

    /* 44 */
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0, position = 0, u = -1;
        while (i < s.length()) {
            System.out.println(i + "" + j + "" + u + "" + position);
            if (j < p.length()) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    i++;
                    j++;
                    continue;
                }
                if (p.charAt(j) == '*') {
                    u = j++;
                    if (j == p.length())
                        return true;
                    position = i;
                    continue;
                }
            }
            if (u != -1) {
                i = ++position;
                j = u + 1;
                continue;
            }
            return false;
        }
        while (j < p.length() && p.charAt(j) == '*')
            ++j;
        return j == p.length();
    }

    /* 45 贪心，找到每一个位置能到的最远的位置，然后只要遍历到当前end，就更新end */
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                // 遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    // 46
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (nums.length == 0)
            return ans;
        ans.add(Arrays.asList(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            while (ans.peek().size() == i) {
                List<Integer> t = ans.remove();
                for (int j = 0; j < i + 1; j++) {
                    List<Integer> s = new ArrayList<>(t);
                    s.add(j, nums[i]);
                    ans.add(s);
                }
            }
        }
        return ans;
    }

    /* 47 我做成了一组一组插入的BFS，感觉是个笨比方法，又臭又长，但是跟BFS一样很直观 */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);// 排序
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (nums.length == 0)
            return ans;
        int rep = 1;// 表示重复的个数
        for (int i = 0; i < nums.length; i++) {
            /* 如果下一个与当前重复，那就跳到下一个，记录重复个数 */
            if (i + 1 < nums.length) {
                if (nums[i + 1] == nums[i]) {
                    rep += 1;
                    continue;
                }
            }
            /* 初始化,把第一种数字放进去 */
            if (i + 1 == rep) {
                List<Integer> list = new ArrayList<>();
                for (int l = 0; l < rep; l++)
                    list.add(nums[0]);
                ans.add(list);
                rep = 1;
                continue;
            }
            /* 下一个不再重复，把当前这组数字插到前面的结果中 */
            int rep_t = rep;/* rep_t用来记录这组重复的数字的个数 */
            rep = 1;/* rep设为1便于之后的计算 */
            System.out.println(ans.peek());
            System.out.println(rep);
            System.out.println(i - rep_t + 1);

            /* 把尚未插数的数组选出来 */
            while (ans.peek().size() == i - rep_t + 1) {
                List<Integer> t = ans.remove();// t就是当前需要插数的List

                /* 使用insertRepeat函数获取可以插入的方式 */
                List<List<Integer>> indexes = new ArrayList<>();// indexes是可以插入的方式
                int m = i - rep_t + 2;// k个数，有k+1个空可以插
                int[] temp = new int[m];
                for (int s = 0; s < m; s++)
                    temp[s] = 0;
                insertRepeat(indexes, temp, rep_t, m, 0);
                System.out.println("定位" + indexes);

                /* 按照index插入 */
                for (List<Integer> index : indexes) {
                    System.out.println(index);
                    List<Integer> res = new ArrayList<>(t);
                    int pos = 0;// pos就是当前插入的位置
                    for (int s = 0; s < m; s++) {
                        int times = index.get(s);
                        if (times != 0) {
                            for (int j = 0; j < times; j++) {
                                res.add(pos, nums[i]);
                                pos += 1;
                            }
                        }
                        pos += 1;
                    }
                    System.out.println(res);
                    ans.add(res);
                }
            }
        }
        return ans;
    }

    /* n个球放入m个盒子中 */
    public void insertRepeat(List<List<Integer>> indexes, int[] ans, int n, int m, int start) {
        int[] d;
        d = ans;
        if (m == 1) {
            d[start] = n;
            ArrayList<Integer> alis = new ArrayList<>();// 傻逼asList不能用
            for (int ti : d)
                alis.add(ti);
            indexes.add(alis);
            return;
        }
        for (int k = 0; k <= n; k++) {
            d[start] = k;
            insertRepeat(indexes, d, n - k, m - 1, start + 1);
        }
    }

    public List<List<Integer>> permuteDFS(int[] nums) {
        n = nums.length;
        if (n <= 0)
            return res;
        state = new boolean[n];
        path = new Stack<>();
        res = new LinkedList<>();
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int pos) {
        if (pos == n) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!state[i]) {
                // 保存现场
                state[i] = true;
                path.push(nums[i]);
                dfs(nums, pos + 1);
                // 恢复现场
                path.pop();
                state[i] = false;
            }
        }
    }
}
