package algorithm.S0to100;

import java.util.*;

public class S17 {
    private final List<String> result = new ArrayList<>();
    private final Map<Character, List<String>> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
        dfs(digits, 0, "");
        return result;
    }

    private void dfs(String d, int p, String path) {
        if (p == d.length()) {
            result.add(path);
            return;
        }
        var list = map.get(d.charAt(p));
        list.forEach(o -> dfs(d, p + 1, path.concat(o)));
    }
}
