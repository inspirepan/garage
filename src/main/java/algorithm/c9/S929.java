package algorithm.c9;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : panjixiang
 * @since : 2022/9/17
 */
public class S929 {
    class Solution {
        public int numUniqueEmails(String[] emails) {
            Set<String> validEmails = new HashSet<>();
            for (String email : emails) {
                int k = email.indexOf('@');
                char[] chars = email.toCharArray();
                var sb = new StringBuilder();
                for (int i = 0; i < k; i++) {
                    if (chars[i] == '+') {
                        break;
                    } else if (chars[i] == '.') {
                        continue;
                    }
                    sb.append(chars[i]);
                }
                sb.append(email.substring(k));
                validEmails.add(sb.toString());
            }
            return validEmails.size();
        }
    }
}
