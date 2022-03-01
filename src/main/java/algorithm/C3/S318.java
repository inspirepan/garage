package algorithm.C3;

public class S318 {
    public int maxProduct(String[] words) {
        // 难道要双重循环比对全部的组合吗
        int len = words.length;
        int[] count = new int[len];
        // 统计每个单词的字频
        // 用二进制的方法
        for (int i = 0; i < len; i++) {
            for (char c : words[i].toCharArray()) {
                count[i] |= 1 << (c - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((count[i] & count[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
