package algorithm.c2;

public class S280 {
    public void wiggleSort(int[] nums) {
        // O(n)
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i & 1) == 1) {
                // 奇数
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                // 偶数
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }

    // 3 2 1 0 1 2 3 4 5 6
    // 2 3 0 1 2 1 4 3 6 5

    void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
