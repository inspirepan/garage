package algorithm.C2;

import java.util.ArrayList;
import java.util.List;

public class S271 {
    public class Codec {

        public String encode(List<String> strs) {
            // 用四个字符记录strs数量
            // 用对应长度的首部记录各个strs的长度，没有说清具体的长度范围啊，我用四个字符记录长度得了
            // 然后就直接拼接在一起
            var sb = new StringBuilder();
            sb.append(String.format("%04d", strs.size()));
            for (String s : strs) {
                sb.append(String.format("%04d", s.length()));
                sb.append(s);
            }

            return sb.toString();
        }

        public List<String> decode(String s) {
            int len = Integer.parseInt(s.substring(0, 4));
            List<String> res = new ArrayList<>();
            int index = 4;
            while (len-- > 0) {
                int strLen = Integer.parseInt(s.substring(index, index + 4));
                index += 4;
                res.add(s.substring(index, index + strLen));
                index += strLen;
            }
            return res;
        }
    }
}
