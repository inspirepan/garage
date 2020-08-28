package algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class S1550Test {
    S1550 s = new S1550();

    @Test
    public void threeConsecutiveOddsTest() {
        s.threeConsecutiveOdds(new int[]{1,2,34,3,4,5,7,23,12});

    }
}