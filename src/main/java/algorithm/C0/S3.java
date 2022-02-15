package algorithm.C0;

import java.util.HashMap;

public class S3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(left,map.get(c));
            }
            maxLen = Math.max(maxLen, i - left);
            map.put(c, i);
        }
        return maxLen;
    }
}
