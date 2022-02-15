package algorithm.C1;

import java.util.Arrays;
import java.util.List;

public class S119 {
    public List<Integer> getRow(int rowIndex) {
        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp, 1);
        System.out.println(Arrays.toString(dp));
        for (int i = 2; i < dp.length; i++) {
            for (int j = i - 1; j > 0; j--) {
                dp[j] = dp[j] + dp[j - 1];
            }
            System.out.println(Arrays.toString(dp));
        }
        return Arrays.asList(dp);
    }
}