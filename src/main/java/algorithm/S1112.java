package algorithm;

public class S1112 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 桶排序
        //统计各元素出现次数
        int[] res = new int[1001];
        for (int num : arr1) {
            res[num]++;
        }

        int index = 0;
        //遍历 arr2，以 arr2的顺序填arr1数组
        for (int num : arr2) {
            //得到 num 元素的个数，并往arr1填充
            for (int i = 0; i < res[num]; i++) {
                arr1[index++] = num;
            }
            res[num] = 0;
        }
        //将剩下的数字按序填入arr1
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i]; j++) {
                arr1[index++] = i;
            }
        }
        return arr1;
    }
}
