package algorithm.C4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class S406 {
    public int[][] reconstructQueue(int[][] people) {
        // 就是返回的queue应该是有序的，每个元素的第二个元素表示前面有多少个身高更高的人
        // 只应该修改people数组中元素的顺序
        // 还是应该从0开始，将所有kj==0的元素按照身高排在最前面
        // 然后是

        // 因为身高最高的肯定会计算进去，所以要考虑身高最高的人
        // 好麻烦，不想做了
        Arrays.sort(people, new Comparator<int[]>() { //比较器，设置比较逻辑
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person2[0] - person1[0];   //height 不等时，大的在前
                } else {
                    return person1[1] - person2[1];   //height 相等时，k小的在前
                }
            }
        });
        // 身高从高到低排序，然后k小在前
        List<int[]> ans = new ArrayList<int[]>();     //泛型的使用，二维数组的本质就是一维数组的数组
        for (int[] person : people) {                   //迭代器
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);  //直接list转array
    }
}

