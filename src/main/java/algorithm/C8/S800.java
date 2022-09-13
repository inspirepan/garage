package algorithm.C8;

public class S800 {
    public String similarRGB(String color) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 1; i < color.length(); i += 2) {
            String sub = color.substring(i, i + 2);
            int ori = Integer.parseInt(sub, 16);
            if (ori % 17 < 9) {
                ori = ori / 17;
            } else {
                ori = ori / 17 + 1;
            }
            sb.append(String.format("%02x", ori * 17));
        }
        return sb.toString();
    }
}
