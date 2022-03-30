package algorithm.C5;

public class S540 {
    public int singleNonDuplicate(int[] nums) {
        // 奇偶
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left >>> 1);
            if ((mid & 1) == 0) {
                // 遇到边界就结束了
                if (mid == nums.length - 1) return nums[mid];
                if (nums[mid] == nums[mid + 1])
                    left = mid + 1;
                else
                    right = mid;
            } else {
                if (nums[mid] == nums[mid + 1])
                    right = mid;
                else
                    left = mid + 1;
            }
        }
        return nums[left];
    }

    public int singleNonDuplicate3(int[] nums) {
        // 奇偶
        int left = 0;
        int right = nums.length - 1; // 其实直接把最后一个位置剪掉也可以
        while (left < right) {
            int mid = left + (right - left >>> 1);
            if ((mid & 1) == 0) {
                if (nums[mid] == nums[mid + 1])
                    left = mid + 1;
                else
                    right = mid;
            } else {
                if (nums[mid] == nums[mid + 1])
                    right = mid;
                else
                    left = mid + 1;
            }
        }
        return nums[left];
    }

    public int singleNonDuplicate2(int[] nums) {
        // 优化的异或版本，不好想，还是用奇偶直观一点
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == nums[mid ^ 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
