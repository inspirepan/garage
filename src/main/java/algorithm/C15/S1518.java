package algorithm.C15;

import javax.accessibility.AccessibleValue;

public class S1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;
        int leave = numBottles;
        while (leave >= numExchange) {
            total += leave / numExchange;
            leave -= (leave / numExchange) * (numExchange - 1);
        }
        return total;
    }
}
