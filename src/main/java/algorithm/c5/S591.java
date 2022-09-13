package algorithm.c5;

import java.util.ArrayDeque;
import java.util.Deque;

public class S591 {
    class Solution {
        public boolean isValid(String code) {
            // 起始<> 结束 </>
            // cdata起始 <![CDATA[  结束]]>   cdata部分是随意的，相当于注释，可以有[]<>
            char[] arr = code.toCharArray();
            int i = 0;
            Deque<String> tags = new ArrayDeque<>();
            while (i < arr.length) {
                if (arr[i] == '<') {
                    if (++i == arr.length) {
                        // 规则6
                        return false;
                    }
                    if (arr[i] == '!') {
                        // CDATA 规则7
                        // 必须要有一个闭合标签，栈必须大于1 规则1
                        if (tags.size() == 0) {
                            return false;
                        }
                        if (i + 7 >= arr.length || !code.startsWith("[CDATA[", i + 1)) {
                            return false;
                        }
                        i += 8;
                        boolean cdataClosed = false;
                        while (i < arr.length) {
                            if (arr[i] == ']') {
                                if (i + 2 < arr.length && arr[i + 1] == ']' && arr[i + 2] == '>') {
                                    i += 2;
                                    cdataClosed = true;
                                    break;
                                }
                            }
                            i++;
                        }
                        if (!cdataClosed) {
                            return false;
                        }
                    } else if (arr[i] == '/') {
                        // close tag
                        int start = ++i;
                        while (i < arr.length && Character.isUpperCase(arr[i])) {
                            i++;
                        }
                        if (i == arr.length || arr[i] != '>' || i == start || i >= start + 10) {
                            // 规则3
                            return false;
                        }
                        if (tags.isEmpty() || !code.substring(start, i).equals(tags.pop())) {
                            // 不匹配
                            return false;
                        }
                    } else {
                        // TAG_NAME
                        int start = i;
                        while (i < arr.length && Character.isUpperCase(arr[i])) {
                            i++;
                        }
                        if (i == arr.length || arr[i] != '>' || i == start || i >= start + 10) {
                            // 规则3
                            return false;
                        }
                        tags.push(code.substring(start, i));
                    }
                }
                // 必须要有一个闭合标签，栈必须大于1 规则1
                if (tags.size() == 0 && i != arr.length - 1) {
                    return false;
                }
                i++;
            }
            return tags.isEmpty();
        }
    }
}
