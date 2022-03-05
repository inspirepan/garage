package algorithm.C4;

import java.util.*;

public class S433 {

    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;
        final char[] ch = new char[]{'A', 'C', 'G', 'T'};
        Set<String> bankSet = new HashSet<>();
        Collections.addAll(bankSet, bank);
        if (!bankSet.contains(end)) return -1;
        int times = 0;
        // 广度优先搜索
        List<Set<String>> history = new ArrayList<>();
        history.add(Collections.singleton(start));
        while (bankSet.size() > 0) {
            System.out.println(times);
            Set<String> set = history.get(times);
            if (set.size() == 0) return -1;
            Set<String> set2 = new HashSet<>();
            for (String s : set) {
                // 生成可能的变化
                char[] chars = s.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (chars[i] == ch[j]) continue;
                        char raw = chars[i];
                        chars[i] = ch[j];
                        String current = new String(chars);
                        if (current.equals(end)) return times + 1; // 如果找到了
                        if (bankSet.contains(current)) {
                            set2.add(current);
                            bankSet.remove(current); // 不要重复访问了
                        }
                        chars[i] = raw;
                    }
                }
            }
            times++;
            history.add(set2);
        }
        return -1;
    }
}
