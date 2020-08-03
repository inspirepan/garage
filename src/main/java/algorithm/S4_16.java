package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 4.7 */

public class S4_16 {
    /*
     * 4 不会 理不清 看了下答案，思路是对的，就是不断二分，但是错就错在应该考虑整体的二分，而不是两个数组分别二分
     * 整体二分的思想是两个数组划分的左边、右边分别是整体的一半。然后对第一个数组进行二分式搜索，
     * 搜索过程中调整第二个数组的划分方式使得保持整体的二分，比较的部分我是对的
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int head1 = 0, tail1 = m - 1, head2 = 0, tail2 = n - 1;
        int medium1, medium2;
        for (int i = 1; i < Math.min(Math.log(m), Math.log(n)); i++) {
            if ((tail1 - head1) % 2 == 0)
                medium1 = nums1[(tail1 - head1) / 2];
            else
                medium1 = (nums1[(tail1 - head1) / 2] + nums1[(tail1 - head1) / 2 + 1]) / 2;

            if ((tail2 - head2) % 2 == 0)
                medium2 = nums2[(tail2 - head2) / 2];
            else
                medium2 = (nums2[(tail2 - head2) / 2] + nums2[(tail2 - head2) / 2 + 1]) / 2;

            if (medium1 == medium2)
                return medium1;
            else if (medium1 > medium2) {
                tail1 = tail1 / 2;
                head2 = tail2 / 2;
            } else {
                head1 = tail1 / 2;
                tail2 = tail2 / 2;
            }
        }
        return 0;
    }

    /*
     * 5 莫得思路啊 先试试中心扩散法 写的太繁琐了，可以合并成一次循环的
     */
    public String longestPalindrome(String s) {
        /*
         * 先考虑单个中心 忘记做空字符串的处理了，以后注意
         */
        int max = 0;
        int[] ans = new int[3];
        for (int i = 0; i < s.length(); i++) {
            /* i 去头去尾 */
            for (int j = 0; j <= Math.min(i, s.length() - i - 1); j++) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    if (max < 2 * j + 1) {
                        max = 2 * j + 1;
                        ans = new int[] { i, j, 1 };
                    }
                } else {
                    break;
                }
            }
        }
        /* 考虑偶数长度的中心 */
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                for (int j = 0; j <= Math.min(i, s.length() - i - 2); j++) {
                    if (s.charAt(i - j) == s.charAt(i + 1 + j)) {
                        if (max < 2 + 2 * j) {
                            max = 2 + 2 * j;
                            ans = new int[] { i, j, 2 };
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        if (ans[2] == 1) {
            return s.substring(ans[0] - ans[1], ans[0] + ans[1] + 1);
        } else if (ans[2] == 2)
            return s.substring(ans[0] - ans[1], ans[0] + ans[1] + 2);
        else
            return "";
    }

    /* 6 用直观的思维+合理的数据结构，就可以了，不要老是循环循环 */
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        char[] cv = new char[s.length()];

        int r = numRows * 2 - 2;
        int set = s.length() / r;
        int rest = s.length() % r;
        int[] line_count = new int[numRows];

        if (rest > 0)
            line_count[0] = set + 1;// 第一行
        else
            line_count[0] = set;
        if (rest >= numRows)
            line_count[numRows - 1] = set + 1;// 最后一行
        else
            line_count[numRows - 1] = set;

        for (int i = 1; i < numRows - 1; i++) {
            // 中间行
            if (rest < i + 1)
                line_count[i] = set * 2;
            else if (rest >= i + 1 && rest < r - i + 1)
                line_count[i] = set * 2 + 1;
            else if (rest >= r - i + 1)
                line_count[i] = set * 2 + 2;
        }

        for (int i = 0; i < s.length(); i++) {
            if (i % r == 0) {
                // 第一行
                cv[i / r] = s.toCharArray()[i];
            } else if (i % r > 0 & i % r < numRows - 1) {
                // 竖排中间行
                int num = 0;
                for (int j = 0; j < i % r; j++) {
                    num += line_count[j];
                }
                num += i / r * 2;
                cv[num] = s.toCharArray()[i];

            } else if (i % r == numRows - 1) {
                // 最后一行
                int num = 0;
                for (int j = 0; j < numRows - 1; j++) {
                    num += line_count[j];
                }
                num += i / r;
                cv[num] = s.toCharArray()[i];
            } else if (i % r >= numRows) {
                int num = 0;
                for (int j = 0; j < (r - i % r); j++) {
                    // 斜列中间行
                    num += line_count[j];
                }
                num += i / r * 2 + 1;
                cv[num] = s.toCharArray()[i];
            }
        }
        return new String(cv);
    }

    /* 7 试试看吧,不知道这个Integer.MAX_VALUE的用法也太麻烦了 */
    public int reverse(int x) throws OutOfMemoryError {
        int p;
        int ans = 0;
        int k = Math.abs(x);
        while (k != 0) {
            p = k % 10;
            System.out.println(p);
            if (ans > (Integer.MAX_VALUE - p) / 10)
                return 0;
            ans = 10 * ans + p;
            k = k / 10;
        }
        return (x > 0) ? ans : -ans;
    }

    /* 9 */
    public boolean isPalindromeUseString(int x) {
        if (x < 0)
            return false;
        if (x < 10)
            return true;
        String s = String.valueOf(x);
        if (s.length() % 2 == 0) {
            if (s.charAt(s.length() / 2 - 1) != s.charAt(s.length() / 2))
                return false;
            for (int j = 0; j < s.length() / 2 - 1; j++) {
                if (s.charAt(s.length() / 2 - 1 - j) != s.charAt(s.length() / 2 + j)) {
                    return false;
                }
            }
        } else {

            for (int j = 1; j <= s.length() / 2; j++) {
                if (s.charAt(s.length() / 2 - j) != s.charAt(s.length() / 2 + j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPalindromeUseInt(int x) {
        if (x < 0)
            return false;
        if (x < 10)
            return true;
        int rem;
        int y = 0, q = x;
        while (q != 0) {
            rem = q % 10;
            y = y * 10 + rem;
            q = q / 10;
        }
        return y == x;
    }

    /* 11 */
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left != right) {
            max = Math.max(max, (right - left) * Math.min(height[right], height[left]));
            if (height[left] > height[right])
                right--;
            else
                left++;
        }
        return max;
    }

    /* 12 */
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        if (num / 1000 > 0) {
            for (int i = 0; i < num / 1000; i++) {
                ans.append("M");
            }
        }
        int count2 = (num % 1000) / 100;
        if (count2 == 9)
            ans.append("CM");
        else if (count2 == 4)
            ans.append("CD");
        else if (count2 < 4 && count2 > 0) {
            ans.append("C".repeat(count2));
        } else if (count2 >= 5 && count2 < 9) {
            ans.append("D");
            ans.append("C".repeat(count2 - 5));
        }
        int count1 = (num % 100) / 10;
        if (count1 == 9)
            ans.append("XC");
        else if (count1 == 4)
            ans.append("XL");
        else if (count1 < 4 && count1 > 0) {
            ans.append("X".repeat(count1));
        } else if (count1 >= 5 && count1 < 9) {
            ans.append("L");
            ans.append("X".repeat(count1 - 5));
        }
        int count0 = num % 10;
        if (count0 == 9)
            ans.append("IX");
        else if (count0 == 4)
            ans.append("IV");
        else if (count0 < 4 && count0 > 0) {
            ans.append("I".repeat(count0));
        } else if (count0 >= 5 && count0 < 9) {
            ans.append("V");
            ans.append("I".repeat(count0 - 5));
        }
        return ans.toString();
    }

    /* 13 还是近乎暴力的方法，其实罗马数字中只要把所有字母代表的数字加起来，同时分辨出要做减法的字符，就可以了 */
    public int romanToInt(String s) {
        char[] c = s.toCharArray();
        int i = 0;

        int count0 = 0, count1 = 0, count2 = 0, count3 = 0;
        while (i < c.length && c[i] == 'M') {
            i++;
            count3++;
        }
        if (i + 1 < c.length && c[i] == 'C') {
            if (c[i + 1] == 'M') {
                count2 += 9;
                i += 2;
            } else if (c[i + 1] == 'D') {
                count2 += 4;
                i += 2;
            }
        }
        if (i < c.length && c[i] == 'D') {
            count2 += 5;
            i += 1;
        }
        while (i < c.length && c[i] == 'C') {
            count2 += 1;
            i++;
        }
        /* 十位 */
        if (i + 1 < c.length && c[i] == 'X') {
            if (c[i + 1] == 'C') {
                count1 += 9;
                i += 2;
            } else if (c[i + 1] == 'L') {
                count1 += 4;
                i += 2;
            }
        }
        if (i < c.length && c[i] == 'L') {
            count1 += 5;
            i += 1;
        }
        while (i < c.length && c[i] == 'X') {
            count1 += 1;
            i++;
        }
        /* 个位 */
        if (i + 1 < c.length && c[i] == 'I') {
            if (c[i + 1] == 'X') {
                count0 += 9;
                i += 2;
            } else if (c[i + 1] == 'V') {
                count0 += 4;
                i += 2;
            }
        }
        if (i < c.length && c[i] == 'V') {
            count0 += 5;
            i += 1;
        }
        while (i < c.length && c[i] == 'I') {
            count0 += 1;
            i++;
        }
        return count3 * 1000 + count2 * 100 + count1 * 10 + count0;
    }

    /*
     * 14 还是不够灵活，答案的做法是，因为最长子串是公共的，所以可以利用indexOf这个函数，
     * 把第0个和第1个String的最长子串找出来，然后再去和剩下的循环比较
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        int minlength = strs[0].length();
        for (String s : strs) {
            minlength = Math.min(s.length(), minlength);
        }
        StringBuilder ans = new StringBuilder();
        boolean stop = false;
        for (int i = 0; i < minlength; i++) {
            for (String s : strs) {
                if (s.charAt(i) != strs[0].charAt(i)) {
                    stop = true;
                    break;
                }
            }
            if (stop)
                break;
            ans.append(strs[0].substring(i, i + 1));
        }
        return ans.toString();
    }

    /*
     * 15 无论如何都要判断输入是否为空，小伎俩 还是不行，强行求解细节太多了，很容易弄漏特殊情况，这题缝缝补补修改了太多次，面试遇到就死机了
     * 算法不行，重写！！！！！！！ 动态规划的意思就是说，循环（一般是while）过程中，根据产生的参数的变化，做出对应的调整
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length <= 2)
            return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Sort.QuickSort(nums);
        // Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int pin1 = i + 1;
            int pin2 = nums.length - 1;
            while (pin1 < pin2) {
                if (nums[i] + nums[pin1] + nums[pin2] == 0) {
                    ans.add(Arrays.asList(nums[i], nums[pin1], nums[pin2]));
                    while (pin1 < pin2 && nums[pin1] == nums[pin1 + 1])
                        pin1++;
                    while (pin1 < pin2 && nums[pin2] == nums[pin2 - 1])
                        pin2--;
                    pin1++;
                    pin2--;
                } else if (nums[i] + nums[pin1] + nums[pin2] > 0)
                    pin2--;
                else
                    pin1++;
            }
        }
        return ans;
    }

    /* 16 */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum - target == 0)
                    return sum;
                else if (Math.abs(sum - target) < Math.abs(min - target)) {
                    min = sum;
                }
                if (sum - target < 0)
                    l++;
                else
                    r--;
            }
        }
        return min;
    }
}
