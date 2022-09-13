package algorithm.C8;

import java.util.ArrayList;
import java.util.List;

public class S820 {
    int sum = 0;

    public int minimumLengthEncoding(String[] words) {
        // 后缀字典树
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        helper(trie.root, 0);
        return sum;
    }

    private void helper(TrieNode node, int length) {
        if (node == null) {
            return;
        }

        List<TrieNode> childList = new ArrayList<>();
        for (TrieNode child : node.children) {
            if (child != null) {
                childList.add(child);
            }
        }
        if (childList.size() == 0 && node.isLeaf) {
            sum += length + 1;
        }

        for (TrieNode child : childList) {
            helper(child, length + 1);
        }
    }

    class Trie {
        TrieNode root = new TrieNode();

        public Trie() {
        }

        public void insert(String word) {
            //后缀插入
            TrieNode p = root;
            char[] chars = word.toCharArray();
            int i = chars.length - 1;
            while (i >= 0) {
                int index = chars[i] - 'a';
                if (p.children[index] == null) {
                    p.children[index] = new TrieNode();
                }
                p = p.children[index];
                i--;
            }
            p.isLeaf = true;
        }
    }

    class TrieNode {
        boolean isLeaf;
        TrieNode[] children = new TrieNode[26];

        public TrieNode() {

        }
    }
}
