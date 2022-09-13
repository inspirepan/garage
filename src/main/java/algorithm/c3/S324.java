package algorithm.c3;

public class S324 {
    int n = -1;

    public void wiggleSort(int[] nums) {
        //找到中位数索引
        int midIndex = this.quickSelect(nums, 0, nums.length - 1);
        //找到中位数
        int mid = nums[midIndex];
        n = nums.length;
        //三分法
        for (int left = 0, i = 0, right = nums.length - 1; i <= right; ) {
            if (nums[V(i)] > mid) {
                swap(nums, V(i++), V(left++));
            } else if (nums[V(i)] < mid) {
                swap(nums, V(i), V(right--));
            } else {
                i++;
            }
        }
    }

    public int V(int i) {
        return (1 + 2 * (i)) % (n | 1);
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int quickSelect(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left;
        int r = right;
        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            if (l < r) {
                nums[l++] = nums[r];
            }
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            if (l < r) {
                nums[r--] = nums[l];
            }
        }
        nums[l] = pivot;
        if (l == nums.length / 2) {
            // 如果是中位数
            return l;
        } else if (l > nums.length / 2) {
            // 只考虑中位数所在的部分
            return this.quickSelect(nums, left, l - 1);
        } else {
            return this.quickSelect(nums, l + 1, right);
        }
    }
}