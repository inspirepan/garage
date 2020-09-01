package playground;

import java.util.StringJoiner;
import java.util.stream.IntStream;

public class ArrayUtils {
    public static void deepPrintArray(int[][] nums) {
        for (var line : nums) {
            var sj = new StringJoiner(", ");
            for (int i : line) {
                sj.add(String.valueOf(i));
            }
            System.out.println(sj.toString());
        }
    }

    public static void deepPrintArray(boolean[][] booleans) {
        for (boolean[] aBoolean : booleans) {
            var sj = new StringJoiner(", ");
            IntStream.range(0, booleans[0].length).mapToObj(j -> aBoolean[j] ? "TRUE" : "----").forEach(sj::add);
            System.out.println(sj.toString());
        }
    }

    public static void deepPrintArrayWithMark(boolean[][] nums, int row, int col) {
        for (int i = 0; i < nums.length; i++) {
            var sj = new StringJoiner(", ");
            for (int j = 0; j < nums[0].length; j++) {
                boolean mark = i == row && j == col;
                sj.add(mark ? (nums[i][j] ? "*TRUE" : "*----") : (nums[i][j] ? " TRUE" : "-----"));
            }
            System.out.println(sj.toString());
        }
    }
}
