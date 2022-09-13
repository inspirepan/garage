package algorithm.c1;

public class S137 {
    public int singleNumber(int[] nums) {
        // 要求是三次重复就归零，
        // 一共四个状态，需要两个状态位
        int a = 0, b = 0;
        for (int x : nums) {
            b = (b ^ x) & ~a;
            a = (a ^ x) & ~b;
        }
        return b;
    }
}
