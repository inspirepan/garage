package algorithm.c15;

public class S1507 {
    public String reformatDate(String date) {
        String[] d = date.split(" ");
        String sb = d[2] +
                "-" +
                toMonth(d[1]) +
                "-" +
                toDate(d[0]);
        return sb;
    }

    private String toMonth(String mon) {
        return switch (mon) {
            case "Jan" -> "01";
            case "Feb" -> "02";
            case "Mar" -> "03";
            case "Apr" -> "04";
            case "May" -> "05";
            case "Jun" -> "06";
            case "Jul" -> "07";
            case "Aug" -> "08";
            case "Sep" -> "09";
            case "Oct" -> "10";
            case "Nov" -> "11";
            case "Dec" -> "12";
            default -> "00";
        };
    }

    private String toDate(String date) {
        String d = date.substring(0, date.length() - 2);
        if (d.length() == 1) {
            d = "0" + d;
        }
        return d;
    }
}
