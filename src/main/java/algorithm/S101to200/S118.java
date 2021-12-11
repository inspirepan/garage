package algorithm.S101to200;

import java.util.ArrayList;
import java.util.List;

public class S118 {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> generate(int numRows) {
        ans.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            generateHelper();
        }
        return ans;
    }

    private void generateHelper() {
        List<Integer> prev = ans.get(ans.size() - 1);
        List<Integer> curr = new ArrayList<>();
        for (int i = -1; i < prev.size(); i++) {
            curr.add(generateSingle(prev, i, i + 1));
        }
        ans.add(curr);
    }

    private int generateSingle(List<Integer> prev, int left, int right) {
        if (left == -1) return 1;
        if (right == prev.size()) return 1;
        return prev.get(left) + prev.get(right);
    }
}
