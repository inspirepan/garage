package algorithm.C0;

public class S81 {
    /**
     * 修改后的
     */
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // 中位数和左右边界一样，用这种方式处理
            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    return binarySearch(nums, target, left, mid - 1) != -1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    return binarySearch(nums, target, mid + 1, right) != -1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    /**
     * 自己写的原版，不复杂但是很凌乱
     */
    public boolean search3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // 中位数和左边一样，写得麻烦了
            if (nums[mid] == nums[left]) {
                if (nums[mid] != nums[right]) {
                    left = mid + 1;
                } else {
                    // 1111 1 1131
                    // 1311 1 1111 这两种情况没法区分啊，往两边探好了
                    // 没什么好的处理思路，就
                    int p = 1;
                    boolean toLeft = true;
                    while (mid - p >= left || mid + p <= right) {
                        // 要这么处理是因为mid左边的数可能比右边少一位
                        if (mid - p >= left && nums[mid] != nums[mid - p]) {
                            break;
                        }
                        if (mid + p <= right && nums[mid] != nums[mid + p]) {
                            toLeft = false;
                            break;
                        }
                        p++;
                    }
                    if (mid + p > right) {
                        // 说明整个数组都是一样的数
                        return false;
                    }
                    if (toLeft) {
                        right = mid - p;
                    } else {
                        left = mid + p;
                    }
                }
            } else if (nums[mid] > nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    return binarySearch(nums, target, left, mid - 1) != -1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    return binarySearch(nums, target, mid + 1, right) != -1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 抄的
     */
    public boolean search2(int[] A, int target) {
        if (A == null) {
            return false;
        }
        int high = A.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = high + (low - high) / 2;
            if (A[mid] == target) {
                return true;
            }
            //有重复元素时，需要判断一下左右中三者相等的情况，这种情况无法确定那边有序，需要左右指针移动一下
            if (A[mid] == A[low] && A[low] == A[high]) {
                low++;
                high--;
                continue; //!! 注意打断本次执行
            }
            //左边有序，就可以确定目标是否在左边。
            if (A[mid] >= A[low]) {
                if (target >= A[low] && target <= A[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            //右边有序
            else {
                if (target >= A[mid] && target <= A[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
