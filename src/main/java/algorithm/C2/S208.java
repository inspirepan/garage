package algorithm.C2;

public class S208 {

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


        class TrieNode {
            boolean isLeaf = false;
            TrieNode[] children = new TrieNode[26];

            public TrieNode() {

            }
        }
    }
}
