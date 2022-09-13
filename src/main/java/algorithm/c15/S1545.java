package algorithm.c15;

public class S1545 {
    public char findKthBit(int n, int k) {
        // 二进制的数学题，不想做
        int mirror = 2;
        while (k >= mirror) {
            mirror = mirror << 1;
        }
        int reverseTimes = 0;
        int base = 0;
        while (mirror >= 2) {
            if (mirror > k) {
                mirror >>= 1;
            } else if (mirror == k) {
                base = 1;
                break;
            } else {
                k = mirror * 2 - k;
                mirror >>= 1;
                reverseTimes++;
            }
        }
        return (char) ((base ^ (reverseTimes % 2)) + '0');
    }
}
