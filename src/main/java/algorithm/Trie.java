package algorithm;

/**
 * 208 前缀树
 * @author panjx
 */
public class Trie {

    public static final char END = '-';

    TrieNode root = new TrieNode();

    public Trie() {
    }


    public void insert(String word) {
        var wordArr = word.toCharArray();
        TrieNode p = root;
        for (char c : wordArr) {
            if (!p.containChild(c)) {
                p.put(c);
            }
            p = p.getChild(c);
        }
        p.put(END);
    }

    public boolean search(String word) {
        var wordArr = word.toCharArray();
        TrieNode p = root;
        for (char c : wordArr) {
            if (!p.containChild(c)) {
                return false;
            }
            p = p.getChild(c);
        }
        return p.containChild(END);
    }


    public boolean startsWith(String prefix) {
        var prefixArr = prefix.toCharArray();
        TrieNode p = root;
        for (char c : prefixArr) {
            if (!p.containChild(c)) {
                return false;
            }
            p = p.getChild(c);
        }
        return true;
    }

    static class TrieNode {
        char val;
        TrieNode[] child;

        TrieNode(char c) {
            this.val = c;
            this.child = new TrieNode[27];
        }

        TrieNode() {
            this.val = END;
            this.child = new TrieNode[27];
        }

        boolean containChild(char c) {
            if (c != END) {
                return child[c - 'a'] != null;
            } else {
                return child[26] != null;
            }
        }

        TrieNode getChild(char c) {
            if (c != END) {
                return child[c - 'a'];
            } else {
                return child[26];
            }
        }

        void put(char c) {
            if (c != END) {
                child[c - 'a'] = new TrieNode(c);
            } else {
                child[26] = new TrieNode();
            }
        }
    }
}
