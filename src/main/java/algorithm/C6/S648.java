package algorithm.C6;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class S648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] ss = sentence.split("\\s");
        Collections.sort(dictionary);
        // 对于每一个词，匹配词根？
        for (int i = 0; i < ss.length; i++) {
            String s = ss[i];
            for (String root : dictionary) {
                if (s.startsWith(root)) {
                    ss[i] = root;
                    break;
                }
            }
        }
        return String.join(" ", ss);
    }

    // 做一下trie的试试看
    public String replaceWords2(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String dic : dictionary) {
            trie.add(dic);
        }
        String[] words = sentence.split(" ");
        // 处理句子中的单词
        for (int i = 0; i < words.length; i++) {
            words[i] = trie.shortestPrefixOf(words[i]);
        }
        return String.join(" ", words);
    }

    static class Trie {
        private static final int R = 26;

        static class TrieNode {
            TrieNode[] children = new TrieNode[R];
            String val; // only for leaf node
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void add(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                int u = word.charAt(i) - 'a';
                if (p.children[u] == null) p.children[u] = new TrieNode();
                p = p.children[u];
            }
            p.val = word;
        }

        public String shortestPrefixOf(String query) {
            TrieNode p = root;
            for (int i = 0; i < query.length(); i++) {
                if (p == null) return "";
                if (p.val != null) return query.substring(0, i);
                int u = query.charAt(i) - 'a';
                p = p.children[u];
            }
            if (p != null && p.val != null) {
                return query;
            }
            return "";
        }
    }
}
