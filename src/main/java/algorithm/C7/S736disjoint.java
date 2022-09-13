package algorithm.C7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S736disjoint {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        // 有传递性，并查集
        if (sentence1.length != sentence2.length) {
            return false;
        }
        Graph g = new Graph(2000);
        Map<String, Integer> wordIndex = new HashMap<>();
        int index = 0;
        for (var pair : similarPairs) {
            String w1 = pair.get(0);
            String w2 = pair.get(1);
            if (!wordIndex.containsKey(w1)) {
                wordIndex.put(w1, index++);
            }
            if (!wordIndex.containsKey(w2)) {
                wordIndex.put(w2, index++);
            }
        }
        for (var pair : similarPairs) {
            String w1 = pair.get(0);
            String w2 = pair.get(1);
            g.union(wordIndex.get(w1), wordIndex.get(w2));
        }
        for (int i = 0; i < sentence1.length; i++) {

            String w1 = sentence1[i];
            String w2 = sentence2[i];
            if (w1.equals(w2)) {
                continue;
            }
            if (!wordIndex.containsKey(w1) || !wordIndex.containsKey(w2)) {
                return false;
            }
            if (g.find(wordIndex.get(w1)) != g.find(wordIndex.get(w2))) {
                return false;
            }
        }
        return true;
    }

    class Graph {
        int[] root;
        int[] height;

        Graph(int size) {
            root = new int[size];
            height = new int[size];
            for (int i = 0; i < root.length; i++) {
                root[i] = i;
            }
        }

        int find(int x) {
            while (root[x] != x) {
                root[x] = find(root[x]);
                x = root[x];
            }
            return root[x];
        }

        void union(int x, int y) {
            int a = find(x);
            int b = find(y);
            if (a != b) {
                if (height[a] == height[b]) {
                    root[a] = b;
                    height[b]++;
                } else if (height[a] < height[b]) {
                    root[a] = b;
                } else {
                    root[b] = a;
                }
            }
        }
    }
}
