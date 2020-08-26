package algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class S179Test {
    S179 t = new S179();

    @Test
    void largestNumber() {
        assertEquals("900",t.largestNumber(new int[]{0,0,9}));
        assertEquals("910",t.largestNumber(new int[]{10,9}));
        assertEquals("9534330",t.largestNumber(new int[]{3,30,34,5,9}));
    }
}