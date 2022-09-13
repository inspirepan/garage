package algorithm.C6;

import java.util.List;

public class S648 {

    public String replaceWords(List<String> dictionary, String s) {
        Trie trie = new Trie();
        for (String root : dictionary) {
            trie.insert(root);
        }
        String[] ss = s.trim().split("\\s+");
        for (int i = 0; i < ss.length; i++) {
            String prefix = trie.getPrefix(ss[i]);
            if (prefix.length() > 0) {
                ss[i] = prefix;
            }
        }
        return String.join(" ", ss);
    }

    class Trie {

        TrieNode root = new TrieNode();

        public Trie() {

        }

        public void insert(String word) {
            int i = 0;
            TrieNode p = root;
            while (i < word.length()) {
                int index = word.charAt(i++) - 'a';
                if (p.children[index] == null) {
                    p.children[index] = new TrieNode();
                }
                p = p.children[index];
            }
            p.isLeaf = true;
        }

        public boolean search(String word) {
            int i = 0;
            TrieNode p = root;
            while (i < word.length()) {
                int index = word.charAt(i++) - 'a';
                if (p.children[index] == null) {
                    return false;
                }
                p = p.children[index];
            }
            return p.isLeaf;
        }

        public boolean startsWith(String prefix) {
            int i = 0;
            TrieNode p = root;
            while (i < prefix.length()) {
                int index = prefix.charAt(i++) - 'a';
                if (p.children[index] == null) {
                    return false;
                }
                p = p.children[index];
            }
            return true;
        }

        public String getPrefix(String word) {
            int i = 0;
            TrieNode p = root;
            String prefix = "";
            while (i < word.length()) {
                int index = word.charAt(i++) - 'a';
                if (p.children[index] == null) {
                    break;
                }
                p = p.children[index];
                if (p.isLeaf) {
                    prefix = word.substring(0, i);
                    break;
                }
            }
            return prefix;
        }

        class TrieNode {
            boolean isLeaf = false;
            TrieNode[] children = new TrieNode[26];

            public TrieNode() {

            }
        }
    }
}
