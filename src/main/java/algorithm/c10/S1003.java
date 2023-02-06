package algorithm.c10;

/**
 * @author : panjixiang
 * @since : 2022/11/15
 */
public class S1003 {
    class Solution {
        public boolean isValid(String s) {
            // 可以倒推，最后一次插入一定是一个完整的abc，并且abc只可能作为某一次插入的部分，而不是由某一个插入两个部分拼接形成
            while (s.indexOf("abc") > 0) {
                s = s.replaceAll("abc", "");
                System.out.println(s);
            }

            return s.length() == 0;
        }
    }
}
