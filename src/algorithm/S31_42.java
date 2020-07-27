package algorithm;

import java.util.*;

public class S31_42 {

    // 32
    public int longestValidParentheses(String s) {
        if (s.length() <= 1)
            return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            System.out.println(stack);
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;

    }

    // 33
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            System.out.println(left + "" + right);
            if (target == nums[left])
                return left;
            if (target == nums[right])
                return right;
            int med = (left + right) / 2;
            if (target == nums[med])
                return med;
            if (target < nums[left] && target > nums[right])
                return -1;
            if (nums[med] > nums[left]) {
                if (target > nums[med] || target < nums[left]) {
                    left = med;
                } else if (target < nums[med] && target > nums[left]) {
                    right = med;
                }
            } else if (nums[med] < nums[left]) {
                if (target > nums[med] && target < nums[right]) {
                    left = med;
                } else if (target < nums[med] || target > nums[right]) {
                    right = med;
                }
            } else if (nums[med] == nums[left])
                return -1;
        }
        return left;
    }

    // 34
    public int[] searchRange(int[] nums, int target) {
        /* 特殊情况 */
        if (nums.length == 0)
            return new int[] { -1, -1 };
        if (nums.length == 1)
            return target == nums[0] ? new int[] { 0, 0 } : new int[] { -1, -1 };
        /* 双指针 */
        int left = 0;
        int right = nums.length - 1;
        /* 二分法 */
        while (left < right) {
            if (target > nums[right] || target < nums[left])
                return new int[] { -1, -1 };
            int med = (left + right) / 2;
            if (med == left) {
                if (nums[med] == target)
                    return nums[right] == target ? new int[] { left, right } : new int[] { left, left };
                else
                    return nums[right] == target ? new int[] { right, right } : new int[] { -1, -1 };
            }
            if (nums[med] == target) {
                if ((nums[(med + left) / 2] != target) && ((med + left) / 2 != left))
                    left = (med + left) / 2;
                else if ((nums[(right + right) / 2] != target) && ((right + right) / 2 != right))
                    right = (med + right) / 2;
                else {
                    while (nums[left] != target)
                        left++;
                    while (nums[right] != target)
                        right--;
                    return new int[] { left, right };
                }
            } else if (nums[med] > target) {
                right = med;
            } else {
                left = med;
            }
        }
        return new int[] { left, right };
    }

    // 35
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0] > target ? 1 : 0;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target) {
                if (mid == i)
                    return i;
                j = mid;
            } else if (nums[mid] < target) {
                if (mid == i) {
                    if (nums[j] >= target)
                        return j;
                    else
                        return j + 1;
                }
                i = mid;
            }
        }
        return i;

    }

    /*
     * 37 用三个哈希表或者数组记录行列以及方块中数字的位置/出现过的数字
     */

    /* 39 */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0)
            return null;
        Arrays.sort(candidates);
        List<List<Integer>> ans = new LinkedList<>();
        dfs(candidates, candidates.length, target, 0, new ArrayDeque<>(), ans);
        return ans;
    }

    public void dfs(int[] candidates, int len, int residue, int begin, Deque<Integer> path, List<List<Integer>> ans) {
        if (residue == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            if (i > begin && candidates[i] == candidates[i - 1])
                continue;// 40问
            if (residue - candidates[i] < 0)
                break;
            path.add(candidates[i]);
            dfs(candidates, len, residue - candidates[i], i + 1, path, ans); // 40问
            path.removeLast();
        }
    }

    /* 40 */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0)
            return null;
        Arrays.sort(candidates);
        List<List<Integer>> ans = new LinkedList<>();
        dfs(candidates, candidates.length, target, 0, new ArrayDeque<>(), ans);
        return ans;
    }

    /* 41 */
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0)
            return 1;
        boolean a = true;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 1);
            if (a && num > 0)
                a = false;
        }
        if (a)
            return 1;
        else {
            int k = 1;
            while (map.containsKey(k)) {
                k++;
            }
            return k;
        }
    }

    /*
     * 42 韦恩图法，太秀了
     */
    public int trap(int[] height) {
        if (height.length < 2)
            return 0;

        /* 从左往右 */
        int S1 = 0;
        int S2 = 0;
        int heightSum = 0;
        int max1 = 0, max2 = 0;
        for (int i = 0; i < height.length; i++) {
            max1 = Math.max(max1, height[i]);
            max2 = Math.max(max2, height[height.length - i - 1]);
            S1 += max1;
            S2 += max2;
            heightSum += height[i];
        }

        return (S1 + S2 - height.length * Math.max(max1, max2)) - heightSum;
    }
}
