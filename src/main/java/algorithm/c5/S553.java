package algorithm.c5;

public class S553 {
    public String optimalDivision(int[] nums) {
        // 不管怎么样，每个元素对总的结果的影响要么是乘要么是除
        // 乘除数量是匹配的，不管怎么括，肯定是先一乘一除，然后
        // 因为要求结果最大、并且所有元素都是正整数，那么必然是要求第二个数到最后一个数作为一个整体、并且要求最小，那就不要加括号
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        if (nums.length == 2) {
            return String.valueOf(nums[0]).concat("/").concat(String.valueOf(nums[1]));
        }
        var sb = new StringBuilder();
        sb.append(nums[0]);
        sb.append("/(");
        int i = 1;
        while (i < nums.length) {
            sb.append(nums[i++]).append("/");
        }
        sb.setLength(sb.length() - 1);
        sb.append(")");
        return sb.toString();
    }
}
