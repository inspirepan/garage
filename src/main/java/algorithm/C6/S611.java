package algorithm.C6;

import java.security.interfaces.RSAKey;
import java.util.*;

public class S611 {
    public int triangleNumber(int[] nums) {
        // 麻烦了
        // 等边三角形 n*(n-1)*(n-2)/6
        // 等腰三角形 n*(n-1)/2* sumOfOtherLength
        // 三条边不一样 sum1*sum2*sum3
        int len = nums.length;
        // length, count
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int num : nums) if (num > 0) map.put(num, map.getOrDefault(num, 0) + 1);
        // 等边
        for (int count : map.values()) {
            if (count >= 3) result += count * (count - 1) * (count - 2) / 6;
        }
        // 长度列表，1<=num<=1000
        int[] sumList = new int[1001];
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            sumList[i] = sum;
            sum += map.getOrDefault(i, 0);
        }
        // 等腰
        for (var e : map.entrySet()) {
            if (e.getValue() >= 2) {
                int temp = 0;
                if (e.getKey() > 500) temp = len;
                else temp = sumList[e.getKey() * 2];
                result += e.getValue() * (e.getValue() - 1) / 2 * (temp - e.getValue());
            }
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        System.out.println(result);
        System.out.println(list);
        // 不一样长
        for (int i = list.size() - 1; i >= 2; i--) {
            int sec = i - 1;
            int fst = 0;
            int thdCount = map.get(list.get(i));
            while (fst < sec) {
                if (list.get(fst) + list.get(sec) > list.get(i)) {
                    // [fst,sec) 都可以当成第三个数
                    int secNum = list.get(sec);
                    int fstNum = list.get(fst);
                    result += thdCount * map.get(secNum) * (sumList[secNum] - sumList[fstNum]);
                    sec--;
                } else {
                    fst++;
                }
            }
        }
        return result;
    }

    public int triangleNumber2(int[] nums) {
        // 看的双指针
        // 和我开始的思路差不多，先固定最大的，然后固定第二个
        if (nums.length < 3) return 0;
        Arrays.sort(nums);
        int len = nums.length;
        // 只要两个小数和比大数大即可 故倒叙遍历
        int res = 0;
        for (int i = len - 1; i >= 2; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    // 大于l小于r的都可以做第三个数
                    res += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }
}
