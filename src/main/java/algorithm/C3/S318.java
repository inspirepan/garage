package algorithm.C3;

public class S318 {
    public int maxProduct(String[] words) {
        // 可以用二进制编码每一个字符的出现情况，

        int[] count = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                count[i] |= 1 << (c - 'a');
            }
        }

        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((count[i] & count[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
