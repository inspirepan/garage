package algorithm.c4;

public class S457 {

    public boolean circularArrayLoop(int[] nums) {
        // 快慢指针找环
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 0跳过
            if (nums[i] == 0) {
                continue;
            }
            int slow = i, fast = next(nums, i);
            // 判断非零且方向相同
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)] > 0) {
                // 回到了slow
                if (slow == fast) {
                    if (slow != next(nums, slow)) {
                        return true;
                    } else {
                        break;
                    }
                }
                // fast快一步
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }
            // 标记i节点往后的不能形成环
            int add = i;
            while (nums[add] * nums[next(nums, add)] > 0) {
                int tmp = add;
                add = next(nums, add);
                nums[tmp] = 0;
            }
        }
        return false;
    }

    public int next(int[] nums, int cur) {
        int n = nums.length;
        return ((cur + nums[cur]) % n + n) % n; // 保证返回值在 [0,n) 中
    }
}
