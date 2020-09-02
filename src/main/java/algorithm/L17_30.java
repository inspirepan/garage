package algorithm;

import datastructure.ListNode;

import java.util.*;

/* 4.8 */

public class L17_30 {
    /*
     * 17 参考评论区一个算法，太强了，使用LinkedList来进行BFS
     */
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.length() == 0) {
            return ans;
        }
        String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            System.out.println("i= " + i);
            int x = Character.getNumericValue(digits.charAt(i));
            while (true) {
                assert ans.peek() != null;
                if (!(ans.peek().length() == i)) {
                    break;
                }
                System.out.println("peek= " + ans.peek());
                System.out.println("ans1= " + ans);
                String t = ans.remove();
                for (char s : map[x].toCharArray()) {
                    ans.add(t + s);
                }
                System.out.println("ans2= " + ans);
            }
        }
        return ans;
    }

    /*
     * 18 真就熟能生巧，总算是会了这个求和题，不会再来个n数求和吧
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        if (nums.length < 4) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] > target / 4) {
                return ans;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int newTarget = target - nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > newTarget / 3) {
                    break;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sumThree = nums[j] + nums[left] + nums[right];
                    if (sumThree == newTarget) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sumThree < newTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ans;
    }

    // 19
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p;
        ListNode q;
        p = head;
        q = head;
        boolean removeHead = false;
        for (int i = 0; i < n; i++) {
            if (p.next == null) {
                removeHead = true;
                break;
            }
            p = p.next;
        }
        if (removeHead) {
            if (head.next == null) {
                return null;// 注意这里返回空结点是用null，新建结点LeetCode的系统会默认构造成0
            } else {
                return head.next;
            }
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        ListNode temp = q.next;
        if (temp.next == null) {
            q.next = null;
        } else {
            q.next = temp.next;
        }
        return head;
    }

    /*
     * 20 又特么忘记判定空集 用栈的时候，要记住出栈操作前一定要检查下栈是否为空
     * 思路还是太笨了，这道题直接完全按栈走一遍（如果匹配就出栈），括回入栈也没关系。最后如果结果栈非空就说明不匹配
     * 尽量去找能够表示结果的统一的变量，而不是老是去分条件考虑，人工分类太蠢了
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == ')') {
                if (!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == ']') {
                if (!stack.empty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '}') {
                if (!stack.empty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    /*
     * 好吧这个只是看起来简洁，运行时间还不如上面那个， 不过上面那个太容易出错了，稍微没搞清楚就错了，还容易越界
     */
    public boolean isValid2(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] cstring = s.toCharArray();
        for (char c : cstring) {
            if (!stack.empty() && ((stack.peek() == '(' && c == ')') || (stack.peek() == '[' && c == ']')
                    || (stack.peek() == '{' && c == '}'))) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

    /*
     * 21 这道题我做得还可以，但是和官方的结果相比，步骤多了太多，因为又人为地把两个链表主动进行了划分，导致产生一堆判断句 Java
     * 的链表如果用等号把两个结点取相等之后，改变一个的next另一个的next也会跟着改变！
     */
    public ListNode mergeTwoLists_RAW(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode p;
        ListNode q = new ListNode();
        if (l1.val <= l2.val) {
            p = l1;
            q.next = l2;
        } else {
            p = l2;
            q.next = l1;
        }
        while (p.next != null && q.next != null) {
            if (p.next.val >= q.next.val) {
                q = q.next;
                ListNode temp = new ListNode();
                temp.val = q.val;// 这里一定要记住temp结点只能赋值、定义next，不要直接相等，不然会把原来的结点（q）破坏掉
                temp.next = p.next;
                p.next = temp;
                p = p.next;
            } else {
                p = p.next;
            }
        }
        /*
         * 这个循环会在q.next==null或者p.next==null时结束，如果在前者结束， 说明已经把q完全输入到p中了，就是正确的，所以还要处理后者。
         */
        if (p.next == null && q.next != null) {
            p.next = q.next;
        }
        if (l1.val <= l2.val) {
            /*
             * ListNode k = l1; while (k != null) { System.out.println(k.val); k = k.next; }
             */
            return l1;
        } else {
            /*
             * ListNode k = l2; while (k != null) { System.out.println(k.val); k = k.next; }
             */
            return l2;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first_node;
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            ListNode p = new ListNode();
            first_node = p;
            while (l1 != null || l2 != null) {
                if (l1 == null) {
                    p.next = l2;
                    return first_node.next;
                } else if (l2 == null) {
                    p.next = l1;
                    return first_node.next;
                }
                if (l1.val < l2.val) {
                    p.next = l1;
                    p = p.next;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    p = p.next;
                    l2 = l2.next;
                }
            }
        }
        return first_node.next;
    }

    /*
     * 22 回溯，递归，很漂亮
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int i = 0; i < n; i++) {
                for (String left : generateParenthesis(i)) {
                    for (String right : generateParenthesis(n - 1 - i)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return ans;
    }

    /*
     * 23 这题学到了分治法，其实也不难，就是先两两分组（奇数就单独一组），然后两两合并， 比我这种每次读取n个数快多了
     */
    public ListNode mergeKLists_RAW(ListNode[] lists) {
        ListNode firstNode;
        ListNode p = new ListNode();
        firstNode = p;
        int num = lists.length;
        int[] stopped = new int[num];
        int rem = 0;
        for (int i = 0; i < num; i++) {
            if (lists[i] != null) {
                stopped[i] = 1;
                rem += 1;
            } else {
                stopped[i] = 0;
            }
        }
        if (rem == 0) {
            return null;
        }
        while (rem != 0) {
            rem = 0;
            int min_val = Integer.MAX_VALUE;
            int min_index = 0;
            for (int i = 0; i < num; i++) {
                if (lists[i] != null) {
                    rem += 1;
                    if (lists[i].val < min_val) {
                        min_index = i;
                        min_val = lists[i].val;
                    }
                }
            }

            ListNode temp = new ListNode();
            temp.val = min_val;
            p.next = temp;
            p = p.next;
            assert lists[min_index] != null;
            lists[min_index] = lists[min_index].next;
            if (lists[min_index] == null) {
                rem -= 1;
            }
        }
        return firstNode.next;
    }

    // 分治
    public ListNode mergeKLists(ListNode[] lists) {
        int nums = lists.length;
        if (nums == 0) {
            return null;
        }
        while (nums > 1) {
            int i;
            for (i = 0; i < nums / 2; i++) {
                lists[i] = mergeTwoLists(lists[2 * i], lists[2 * i + 1]);
            }
            if (nums % 2 == 1) {
                System.out.println("奇数" + i);
                lists[i] = lists[nums - 1];
                nums += 1;
            }
            nums /= 2;
        }
        return lists[0];
    }

    /* 24 */
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }
        ListNode p = new ListNode();
        ListNode q;
        ListNode f;
        f = p;
        p.next = head;
        q = head;
        /*
         * q和q.next是每次循环交换的，一次循环1p-2q-3q.next 变成 1-3-2p-4q，数字是打比方的值，字母是指针位置
         * q==null说明长度偶数，正好交换完 q.next==null说明是奇数，因此返回结果就行了
         */
        while (q != null && q.next != null) {
            p.next = q.next;
            if (q.next.next != null) {
                q.next = q.next.next;
                p = p.next;
                p.next = q;
                p = p.next;
                q = q.next;
                p.next = q;
            } else {
                // q.next.next不存在的话，说明到尾了，直接赋成null
                p = p.next;
                p.next = q;
                p = p.next;
                q = null;
                p.next = q;
            }
        }
        return f.next;
    }

    /*
     * 25 可以把上题学的递归用一下 总算通过了，头都大了
     * 看了下答案，我分情况讨论的方法太笨了，因为我们把头结点的next定为递归结果后，kend的next已经不重要了，我们可以直接把kend设为null，
     * 然后调用翻转链表的函数
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        if (head == null) {
            return null;
        }

        int count = 0;
        ListNode k_end = head;
        while (count < k - 1 && k_end.next != null) {
            k_end = k_end.next;
            count++;
        }
        if (count < k - 1) {
            return head;
        } else {
            ListNode t = head.next;
            head.next = reverseKGroup(k_end.next, k);
            /*
             * 这里是将k个链表结点反转，要分情况讨论 分这么多情况的原因还是我太菜了，翻转要用三个指针，如果k只有4及以下，那会出现一堆空指针
             */
            if (k == 2) {
                k_end.next = head;
            } else if (k == 3) {
                k_end.next = t;
                t.next = head;
            } else if (k == 4) {
                ListNode tr = t.next;
                k_end.next = tr;
                tr.next = t;
                t.next = head;
            } else if (k >= 5) {
                ListNode t1 = head;
                ListNode t2 = t.next;
                int c = 0;
                while (c < k - 1) {
                    c++;
                    t.next = t1;
                    if (t2 == null) {
                        t1 = t;
                    } else {
                        if (t2.next == null) {
                            t1 = t;
                            t = t2;
                            t2 = null;
                        } else {
                            t1 = t;
                            t = t2;
                            t2 = t2.next;
                        }
                    }
                }
                return t1;
            }
            return k_end;
        }
    }

    // 26
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                count += 1;
                nums[count] = nums[i];
            }
        }
        return count + 1;
    }

    // 27
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[count] = nums[i];
                count += 1;
            }
        }
        return count;
    }

    // 28
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0 || haystack.length() < needle.length()) {
            return -1;
        }

        int[] nextval = KMP_nextval(needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1
                    || Character.getNumericValue(needle.charAt(j)) == Character.getNumericValue(haystack.charAt(i))) {
                i++;
                j++;
            } else {
                j = nextval[j];
            }
        }
        if (j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    public int[] KMP_nextval(String needle) {
        int[] nextval = new int[needle.length()];
        nextval[0] = -1;
        int i = 0;
        int j = -1;
        while (i < needle.length() - 1) {
            if (j == -1 || Character.getNumericValue(needle.charAt(i)) == Character.getNumericValue(needle.charAt(j))) {
                j++;
                i++;
                if (Character.getNumericValue(needle.charAt(i)) != Character.getNumericValue(needle.charAt(j))) {
                    nextval[i] = j;
                } else {
                    nextval[i] = nextval[j];
                }
            } else {
                j = nextval[j];
            }
        }
        return nextval;
    }

    // 29
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        boolean lessthan0;
        lessthan0 = (dividend < 0 || divisor < 0) && (dividend > 0 || divisor > 0);
        long e = Math.abs((long) dividend);
        long s = Math.abs((long) divisor);
        if (e < s) {
            return 0;
        }
        long ans = maxPartDivide(e, s);
        return lessthan0 ? (int) -ans : (int) ans;
    }

    public long maxPartDivide(long e, long s) {
        if (e < s) {
            return 0;
        }
        long ans = 1;
        long t = s;
        int i = 0;
        while (i < 200 && t + t <= e) {
            i++;
            t += t;
            ans += ans;
        }
        return ans + maxPartDivide(e - t, s);
    }

    // 30
    public List<Integer> findSubstring_RAW(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || words == null || words.length == 0) {
            return ans;
        }
        int nums = words.length;
        int len = words[0].length();
        int winLenth = nums * len;
        for (int i = 0; i < s.length() - winLenth + 1; i++) {
            String subs = s.substring(i, i + winLenth);
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < nums; j++) {
                String sub = subs.substring(len * j, len * (j + 1));
                /* 哈希表有getorDefault方法！ */
                if (map.containsKey(sub)) {
                    int t = map.get(sub);
                    map.put(sub, t + 1);
                } else {
                    map.put(sub, 1);
                }
            }
            for (String word : words) {
                if (map.containsKey(word)) {
                    int t = map.get(word);
                    map.put(word, t - 1);
                } else {
                    break;
                }
            }
            boolean a = true;
            /*
             * 这一步的实质是比较子串n分段，和模式串所包含的结果是否一致， 我在循环中又嵌套了一个循环进去，实际上可以再用一个哈希表
             */
            for (String word : words) {
                if (!map.containsKey(word)) {
                    a = false;
                    break;
                }
                if (map.get(word) != 0) {
                    a = false;
                    break;
                }
            }
            if (a) {
                ans.add(i);
            }
        }
        return ans;
    }

    // 重新写一遍
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() == 0 || words.length == 0 || words[0].length() == 0) {
            return ans;
        }
        int nums = words.length;
        int len = words[0].length();
        Map<String, Integer> map1 = new HashMap<>();
        for (String word : words) {
            int t = map1.getOrDefault(word, 0);
            map1.put(word, t + 1);
        }
        for (int i = 0; i < s.length() - nums * len + 1; i++) {
            int j = 0;
            Map<String, Integer> map2 = new HashMap<>();
            while (j < nums) {
                String split_word = s.substring(i + j * len, i + len * (j + 1));
                if (map1.containsKey(split_word)) {
                    int m = map2.getOrDefault(split_word, 0);
                    map2.put(split_word, m + 1);
                    if (map2.get(split_word) > map1.get(split_word)) {
                        break;// 如果出现次数超过应该出现的次数
                    }
                } else {
                    break;// 如果不匹配，就下一个子串 i+1
                }
                j++;
            }
            if (j == nums) {
                ans.add(i);
            }
        }
        return ans;
    }
}
