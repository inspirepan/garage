package algorithm;

public class S268 {
    public int missingNumber(int[] nums) {
        boolean[] rec = new boolean[nums.length + 1];
        for (int num : nums) rec[num] = true;
        for (int i = 0; i < rec.length; i++) {
            if (!rec[i]) return i;
        }
        return 0;
    }
}
