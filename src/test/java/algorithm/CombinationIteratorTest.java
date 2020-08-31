package algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombinationIteratorTest {

    @Test
    void next() {
        var s = new CombinationIterator("abcdefghijklmn", 3);
        while(s.hasNext()){
            System.out.println(s.next());
        }

    }
}