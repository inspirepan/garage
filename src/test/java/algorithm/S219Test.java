package algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class S219Test {

    @Test
    void containsNearbyDuplicate() {
        S219 s = new S219();
        s.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2);
    }
}