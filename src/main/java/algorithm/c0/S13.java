package algorithm.c0;

public class S13 {

    public int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int res = 0;
        while (i < arr.length) {
            switch (arr[i]) {
                case 'M' -> res += 1000;
                case 'D' -> res += 500;
                case 'C' -> {
                    if (i < arr.length - 1) {
                        char next = arr[i + 1];
                        if (next == 'D') {
                            i++;
                            res += 400;
                        } else if (next == 'M') {
                            i++;
                            res += 900;
                        } else {
                            res += 100;
                        }
                    } else {
                        res += 100;
                    }
                }
                case 'L' -> {
                    res += 50;
                }
                case 'X' -> {
                    if (i < arr.length - 1) {
                        char next = arr[i + 1];
                        if (next == 'L') {
                            i++;
                            res += 40;
                        } else if (next == 'C') {
                            i++;
                            res += 90;
                        } else {
                            res += 10;
                        }
                    } else {
                        res += 10;
                    }
                }
                case 'V' -> res += 5;
                case 'I' -> {
                    if (i < arr.length - 1) {
                        char next = arr[i + 1];
                        if (next == 'V') {
                            i++;
                            res += 4;
                        } else if (next == 'X') {
                            i++;
                            res += 9;
                        } else {
                            res += 1;
                        }
                    } else {
                        res += 1;
                    }
                }
            }
            i++;
        }
        return res;
    }
}
