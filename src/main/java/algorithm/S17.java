package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S17 {
    private final List<String> result = new ArrayList<>();
    private final Map<Character, List<String>> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        map.put('2', List.of("a", "b", "c"));
        map.put('3', List.of("d", "e", "f"));
        map.put('4', List.of("g", "h", "i"));
        map.put('5', List.of("j", "k", "l"));
        map.put('6', List.of("m", "n", "o"));
        map.put('7', List.of("p", "q", "r", "s"));
        map.put('8', List.of("t", "u", "v"));
        map.put('9', List.of("w", "x", "y", "z"));
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
