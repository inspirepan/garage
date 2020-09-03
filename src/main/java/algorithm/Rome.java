package algorithm;

public class Rome {
    public String intToRoman(int num) {
        var sb = new StringBuilder();
        if (num >= 1000) {
            sb.append("M".repeat(num / 1000));
            num %= 1000;
        }
        if (num >= 100) {
            int hundredDig = num / 100;
            switch (hundredDig) {
                case 1, 2, 3 -> sb.append("C".repeat(hundredDig));
                case 4 -> sb.append("CD");
                case 5 -> sb.append("D");
                case 6, 7, 8 -> sb.append("D").append("C".repeat(hundredDig - 5));
                case 9 -> sb.append("CM");
            }
            num %= 100;
        }
        if (num >= 10) {
            int tenDig = num / 10;
            switch (tenDig) {
                case 1, 2, 3 -> sb.append("X".repeat(tenDig));
                case 4 -> sb.append("XL");
                case 5 -> sb.append("L");
                case 6, 7, 8 -> sb.append("L").append("X".repeat(tenDig - 5));
                case 9 -> sb.append("XC");
            }
            num %= 10;
        }
        switch (num) {
            case 1, 2, 3 -> sb.append("I".repeat(num));
            case 4 -> sb.append("IV");
            case 5 -> sb.append("V");
            case 6, 7, 8 -> sb.append("V").append("I".repeat(num - 5));
            case 9 -> sb.append("IX");
        }
        return sb.toString();
    }
}
