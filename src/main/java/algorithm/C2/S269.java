package algorithm.C2;

import java.util.*;

public class S269 {
    public String alienOrder(String[] words) {
        // 好难啊
        // 先根据第一个字母排序、然后根据第一个字母分组
        // 再根据下一个字母排序、然后分组这样子递推
        // 用什么数据结构可以记录这个分组的结果呢，不知道
        // 实际上每次比较也只能知道两个字母之间的顺序，所以可能有模糊的情况 a<b c<b 那么a和c的顺序应该是随意的，所以只需要记录一下比较对，
        // 然后再根据课程顺序那道题的方法给出一个排序就可以了

        Map<Character, List<Character>> greaterMap = new HashMap<>();
        // 每一个字符比它大的字符
        int[] lessCount = new int[26];
        // 每一个字符比它小的字符的数量
        Arrays.fill(lessCount, -1);
        // 没有出现过的字符记成-1

        // 开始构建一下字符的比较关系
        // 好像只需要比较相邻的字符就可以了

        for (int i = 0; i < words.length - 1; i++) {
            compare(words[0], words[1], greaterMap, lessCount);
        }

        var sb = new StringBuilder();
        Deque<Character> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (lessCount[i] == 0) queue.offer((char) ('a' + i));
        }
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            if (greaterMap.containsKey(curr)) {
                for (char next : greaterMap.get(curr)) {
                    if (--lessCount[next - 'a'] == 0) {
                        queue.offer(next);
                    }
                }
            }
            sb.append(curr);
        }
        return sb.toString();
    }

    private void compare(String w1, String w2, Map<Character, List<Character>> greaterMap, int[] lessCount) {
        int i = 0;
        int j = 0;
        // 依次按位比较获取关系
    }
}
