package algorithm.c4;

import java.util.ArrayList;
import java.util.List;

public class S412 {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean is3 = i % 3 == 0;
            boolean is5 = i % 5 == 0;
            if (is3 && is5) {
                result.add("FizzBuzz");
            } else if (is3) {
                result.add("Fizz");
            } else if (is5) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}
