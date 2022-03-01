package algorithm.C3;

public class S319 {
    public int bulbSwitch(int n) {
        // 如果一个数k%i==0 那么在第i轮就会切换
        // 在n之前，如果一个数有偶数个因数就会灭，奇数个因数就会亮
        // 1 2- 3- 4 5- 6- 7- 8- 9+
        // 相当于说是统计n及以下有几个因数是奇数的数
        // 奇数的情况只可能是平方数，那就是统计root n等于几

        if (n == 1) return 1;
        long left = 1, right = n;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == n) return (int) mid;
            else if (mid * mid > n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 这个二分搜索一定要返回left-1，因为结束的条件是left==right，只有在left=mid+1后才会触发
        // 如果left=mid+1，那么此时right^2>n,mid^2<n，那么结束的left就是刚刚好大于结果的right
        return (int) left - 1;
    }
}
