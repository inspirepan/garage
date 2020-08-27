package algorithm;

public class S657 {
    public boolean judgeCircle(String moves) {
        int hori = 0;
        int vert = 0;
        for (var c : moves.toCharArray()) {
            switch (c) {
                case 'U' -> vert++;
                case 'D' -> vert--;
                case 'L' -> hori++;
                case 'R' -> hori--;
            }
        }
        return hori == 0 && vert == 0;
    }
}
