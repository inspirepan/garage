package algorithm.C4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S438 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        int[] pmap = new int[26];
        for (char pc : p.toCharArray()) {
            pmap[pc - 'a']++;
        }
        int k = p.length();
        int[] smap = new int[26];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            smap[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(smap, pmap)) {
            result.add(0);
        }

        int left = 1, right = k;
        while (right < s.length()) {
            smap[s.charAt(right++) - 'a']++;
            smap[s.charAt(left - 1) - 'a']--;
            if (Arrays.equals(smap, pmap)) {
                result.add(left);
            }
            left++;
        }
        return result;
    }
}
