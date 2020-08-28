package algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {
    Trie t = new Trie();

    @Test
    void insert() {
        t.insert("hello");
        assertTrue(t.search("hello"));
        assertTrue(t.startsWith("hell"));
        t.insert("hepda");
        assertFalse(t.startsWith("hk"));
        assertFalse(t.search("he"));
        assertTrue(t.startsWith("he"));
    }

    @Test
    void search() {
    }

    @Test
    void startsWith() {
    }
}