package algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class S332Test {
    @Test
    void test() {
        var s = new S332();
        var input = new ArrayList<List<String>>();
        input.add(List.of("JFK", "SFO"));
        input.add(List.of("JFK", "ATL"));
        input.add(List.of("SFO", "ATL"));
        input.add(List.of("ATL", "JFK"));
        input.add(List.of("ATL", "SFO"));
        var result = List.of("JFK", "ATL", "JFK", "SFO", "ATL", "SFO");
        assertEquals(result, s.findItinerary(input));
        System.out.println(result);
    }

}