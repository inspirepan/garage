package algorithm.c14;

public class S1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        // 这不就是统计元素是不是一样多的吗
        int[] bucket = new int[1001];
        for (int i = 0; i < target.length; i++) {
            bucket[target[i]]++;
        }

        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]--;
        }
        for (int j = 0; j < bucket.length; j++) {
            if (bucket[j] != 0) {
                return false;
            }
        }
        return true;
    }
}
