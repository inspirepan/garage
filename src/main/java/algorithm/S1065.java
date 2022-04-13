package algorithm;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S1065 {
    public int[][] indexPairs(String text, String[] words) {
        char[] arr = text.toCharArray();
        Trie t = new Trie();
        for (String word : words) {
            t.insert(word);
        }
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int j = i;
            Trie.TrieNode node = t.root;
            while (j < arr.length) {
                if (node.children[arr[j] - 'a'] == null) {
                    break;
                }
                node = node.children[arr[j] - 'a'];
                if (node.isLeaf) {
                    result.add(List.of(i, j));
                }
                j++;
            }
        }
        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            res[i][0] = result.get(i).get(0);
            res[i][1] = result.get(i).get(1);
        }
        return res;
    }

    class Trie {

        TrieNode root = new TrieNode();

        public class TrieNode {

            TrieNode[] children = new TrieNode[26];
            boolean isLeaf = false;

            TrieNode() {

            }
        }

        Trie() {

        }

        void insert(String word) {
            int i = 0;
            TrieNode node = root;
            while (i < word.length()) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
                node = node.children[c - 'a'];
                i++;
            }
            node.isLeaf = true;
        }
    }
}
