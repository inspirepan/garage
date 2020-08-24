package algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class S459Test {

    @Test
    void repeatedSubstringPattern2() {
    }

    @Test
    void repeatedSubstringPattern() {
        assertTrue(S459.repeatedSubstringPattern3("abab"));
        assertFalse(S459.repeatedSubstringPattern3("aba"));
        assertTrue(S459.repeatedSubstringPattern3("abcabcabcabc"));
        assertFalse(S459.repeatedSubstringPattern3("abac"));
    }
}