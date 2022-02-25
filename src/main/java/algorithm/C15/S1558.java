package algorithm.C15;

public class S1558 {
    public int minOperations(int[] nums) {
        // 一次操作可以将一个位置的值+1；或者将数组全部的值翻倍
        // 先找到奇数，因为奇数肯定要用偶数+1得到；偶数可以用一次翻倍操作
        // 全变成偶数之后，集体除以2，算一次操作，然后再重复
        // 一直算到每个数为0
        // 乘2这个操作是可以共享的，只要统计nums中每个数需要*2的次数，
        // 然后取个最大值就可以了，+1这个操作是不能共享的

        int maxOp1 = 0;
        int op0Count = 0;
        for (int num : nums) {
            int op1count = 0;
            while (num > 0) {
                if ((num & 1) == 1) {
                    num--;
                    op0Count++;
                } else {
                    num >>= 1;
                    op1count++;
                }
            }
            maxOp1 = Math.max(maxOp1, op1count);
        }
        return maxOp1 + op0Count;
    }
}
