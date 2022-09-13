package algorithm.C4;

public class S470 {

    public int rand7() {
        return 1;
    }

    public int rand10() {
        int sum = 0;
        while (true) {
            sum = (rand7() - 1) * 7; // 0/7/14/21/28/35/42
            sum += rand7(); // 1~49
            if (sum > 39) {
                break;
            }
        }
        return sum - 39;
    }
}
