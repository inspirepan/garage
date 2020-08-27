package algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class S190Test {

    @Test
    void reverseBits() {
        long para = Long.valueOf("11111111111111111111111111111101",2);
        System.out.println(Integer.toBinaryString((int)para));
        System.out.println(Integer.toBinaryString(S190.reverseBits((int)para)));
    }
}