package algorithm.c7;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class S792 {
    // 实际情况就是字典树费力不讨好，效率还不如直接排序，应该是words规模不够大，字典树作用不大
    public int numMatchingSubseq2(String s, String[] words) {
        Map<Character, Deque<String>> m = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            m.put(c, new LinkedList<>());
        }
        // 将相同首字母的字符串放在一个队列中
        for (String w : words) {
            m.get(w.charAt(0)).add(w);
        }
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            // 弹出对应首字母的队列 其中都是以这个字符为首字母的字符串
            Deque<String> q = m.get(ch);
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String str = q.poll();
                if (str.length() == 1) {
                    cnt++;
                } else {
                    m.get(str.charAt(1)).offer(str.substring(1));
                }
            }
        }
        return cnt;
    }

    public int numMatchingSubseq(String s, String[] words) {
        // s中重复的字符，肯定是尽可能选最前面的

        List<Integer>[] lists = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            lists[i] = new ArrayList<>();
        }
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            lists[arr[i] - 'a'].add(i);
        }
        Trie t = new Trie();
        for (String word : words) {
            t.add(word);
        }
        return t.dfs(lists, t.root, -1);
    }

    class Trie {
        TrieNode root = new TrieNode();

        void add(String s) {
            char[] arr = s.toCharArray();
            TrieNode node = root;
            int i = 0;
            while (i < arr.length) {
                char c = arr[i];
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
                i++;
            }
            node.count++;
        }

        int dfs(List<Integer>[] lists, TrieNode node, int index) {
            int count = 0;
            count += node.count;
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    Integer next = findNext(lists[i], index);
                    if (next != null) {
                        count += dfs(lists, node.children[i], next + 1);
                    }
                }
            }
            return count;
        }

        Integer findNext(List<Integer> list, int index) {
            // 找到list中第一个大于等于index的
            int left = 0;
            int right = list.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (list.get(mid) >= index) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (left == list.size()) {
                return null;
            }
            return list.get(left);
        }

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            int count = 0;
        }
    }
}
