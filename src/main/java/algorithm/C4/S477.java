package algorithm.C4;

public class S477 {
    public int totalHammingDistance(int[] nums) {
        // 分别统计int32位，数组全部数中，这个位置1的数量，那么这个位置产生的汉明距离就是1的数量乘以0的数量
        int sum = 0;
        int pattern = 1;
        for (int i = 0; i < 32; i++) {
            int count1 = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & pattern) > 0) count1++;
            }
            pattern <<= 1;
            sum += count1 * (nums.length - count1);
        }
        return sum;
    }
}
