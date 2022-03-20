package algorithm.C6;

public class S657 {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (var c : moves.toCharArray()) {
            switch (c) {
                case 'U' -> y++;
                case 'D' -> y--;
                case 'L' -> x++;
                case 'R' -> x--;
            }
        }
        return x == 0 && y == 0;
    }
}
