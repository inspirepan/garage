package algorithm.c7;

import java.util.ArrayList;
import java.util.List;

public class S758 {
    public String boldWords(String[] words, String s) {
        List<int[]> match = new ArrayList<>();
        char[] arr = s.toCharArray();
        Trie trie = new Trie();
        for (String w : words) {
            trie.insert(w);
        }
        for (int i = 0; i < arr.length; i++) {
            int end = trie.searchMax(arr, i);
            if (end >= i) {
                if (match.size() == 0) {
                    match.add(new int[]{i, end});
                } else {
                    int lastEnd = match.get(match.size() - 1)[1];
                    if (lastEnd + 1 < i) {
                        match.add(new int[]{i, end});
                    } else {
                        match.get(match.size() - 1)[1] = Math.max(lastEnd, end);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < arr.length) {
            if (j < match.size() && i == match.get(j)[0]) {
                sb.append("<b>");
            }
            sb.append(arr[i]);
            if (j < match.size() && i == match.get(j)[1]) {
                sb.append("</b>");
                j++;
            }
            i++;
        }
        return sb.toString();
    }

    class Trie {
        TrieNode root = new TrieNode();

        void insert(String word) {
            char[] arr = word.toCharArray();
            int i = 0;
            TrieNode node = root;
            while (i < arr.length) {
                int curr = arr[i] - 'a';
                if (node.children[curr] == null) {
                    node.children[curr] = new TrieNode();
                }
                node = node.children[curr];
                i++;
            }
            node.isLeaf = true;
        }

        int searchMax(char[] arr, int start) {
            // 从start开始往后匹配，返回匹配最远的索引，如果没有匹配返回-1

            TrieNode node = root;
            int i = start;
            int ans = -1;
            while (i < arr.length) {
                int curr = arr[i] - 'a';
                if (node.children[curr] == null) {
                    return ans;
                }
                node = node.children[curr];
                if (node.isLeaf) {
                    ans = i;
                }
                i++;
            }
            return ans;
        }

        class TrieNode {
            boolean isLeaf = false;
            TrieNode[] children = new TrieNode[26];
        }
    }
}
