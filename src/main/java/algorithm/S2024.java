package algorithm;

public class S2024 {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        // 滑动窗口，窗口内的t和f最小值不能超过k，不然就左缩窗口
        int tSize = 0, fSize = 0;
        int left = 0, right = 0;
        char[] cs = answerKey.toCharArray();
        while (right < cs.length) {
            char in = cs[right++];
            if (in == 'T') tSize++;
            else fSize++;
            if (Math.min(tSize, fSize) > k) {
                char out = cs[left++];
                if (out == 'T') tSize--;
                else fSize--;
            }
        }
        return right - left;
    }
}
