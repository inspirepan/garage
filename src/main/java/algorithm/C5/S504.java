package algorithm.C5;

public class S504 {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        boolean negative = num < 0;
        num = Math.abs(num);
        var sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        if (negative) sb.append("-");
        return sb.reverse().toString();
    }
}
