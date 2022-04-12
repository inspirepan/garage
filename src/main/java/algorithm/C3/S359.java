package algorithm.C3;

import java.util.HashMap;
import java.util.Map;

public class S359 {
    class Logger {
        Map<String, Integer> map = new HashMap<>();

        public Logger() {

        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if (map.containsKey(message)) {
                int last = map.get(message);
                if (timestamp >= last + 10) {
                    map.put(message, timestamp);
                    return true;
                }
                return false;
            }
            map.put(message, timestamp);
            return true;
        }
    }
}
