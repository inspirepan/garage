package algorithm.C5;

public class S544 {
    public String findContestMatch(int n) {
        int round = 1;
        String[] temp = new String[n];
        while (Math.pow(2, round) < n) {
            round++;
        }
        for (int i = 0; i < n; i++) {
            temp[i] = "" + (i + 1);
        }
        int len = n;
        while (round > 0) {
            int i = 0;
            int j = len - 1;
            while (i < j) {
                temp[i] = "(" + temp[i] + "," + temp[j] + ")";
                i++;
                j--;
            }
            len = len / 2;
            round--;
        }

        return temp[0];
    }
}
