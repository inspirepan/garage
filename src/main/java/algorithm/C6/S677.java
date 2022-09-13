package algorithm.C6;

public class S677 {

    class MapSum {

        // 标准的字典树题

        TrieNode root = new TrieNode();

        public MapSum() {

        }

        public void insert(String key, int val) {
            TrieNode p = root;

            int i = 0;
            while (i < key.length()) {
                int index = key.charAt(i++) - 'a';
                if (p.children[index] == null) {
                    p.children[index] = new TrieNode();
                }
                p = p.children[index];
            }
            p.val = val;
        }

        public int sum(String prefix) {
            TrieNode p = root;
            int i = 0;
            while (i < prefix.length()) {
                int index = prefix.charAt(i++) - 'a';
                if (p.children[index] == null) {
                    return 0;
                }
                p = p.children[index];
            }
            return getSum(p);
        }

        private int getSum(TrieNode p) {
            if (p == null) {
                return 0;
            }
            int sum = p.val;
            for (TrieNode child : p.children) {
                sum += getSum(child);
            }
            return sum;
        }

        private class TrieNode {
            int val = 0;
            TrieNode[] children = new TrieNode[26];

            TrieNode(int val) {
                this.val = val;
            }

            TrieNode() {

            }
        }
    }
}
