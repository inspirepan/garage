package algorithm;

import org.junit.jupiter.api.Test;

class S30Test {

    @Test
    void findSubstring() {
        System.out.println(S30.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
    }
}