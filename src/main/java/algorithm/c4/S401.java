package algorithm.c4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S401 {
    private final Map<Integer, List<Integer>> map = new HashMap<>();

    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn == 0) {
            return List.of("0:00");
        }
        // 分配二进制的1
        // 时钟至少0个1，最多3个1，分钟最少0个1，最多6个1
        // 分钟要补0
        List<String> result = new ArrayList<>();

        for (int i = 0; i <= turnedOn; i++) {
            if (i > 3) {
                break;
            }
            // i分配给时钟
            List<Integer> hours = hourList(i);
            List<Integer> minutes = minuteList(turnedOn - i);
            for (int hour : hours) {
                for (int minute : minutes) {
                    var sb = new StringBuilder();
                    sb.append(hour);
                    sb.append(":");
                    if (minute == 0) {
                        sb.append("00");
                    } else if (minute < 10) {
                        sb.append("0").append(minute);
                    } else {
                        sb.append(minute);
                    }
                    result.add(sb.toString());
                }
            }
        }
        return result;
    }

    private List<Integer> hourList(int turnedOn) {
        return switch (turnedOn) {
            case 1 -> List.of(1, 2, 4, 8);
            case 2 -> List.of(3, 5, 6, 9, 10);
            case 3 -> List.of(7, 11);
            case 0 -> List.of(0);
            default -> null;
        };
    }

    private List<Integer> minuteList(int turnedOn) {
        if (map.containsKey(turnedOn)) {
            return map.get(turnedOn);
        }
        // 6个二进制位，只接受0-59
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            if (Integer.bitCount(i) == turnedOn) {
                result.add(i);
            }
        }
        map.put(turnedOn, result);
        return result;
    }
}
