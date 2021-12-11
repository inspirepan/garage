package algorithm.S0to100;

public class S80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int pos = 0;
        int ptr = 0;
        int prev = nums[0];
        int count = 0;
        while (ptr < nums.length) {
            int curr = nums[ptr];
            if (curr == prev) {
                if (++count <= 2) {
                    nums[pos++] = curr;
                }
            } else {
                nums[pos++] = curr;
                prev = curr;
                count = 1;
            }
            ptr++;
        }
        return pos;
    }
}
