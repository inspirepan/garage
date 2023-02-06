package algorithm.c4;

import java.util.Arrays;

public class S475 {
    public int findRadius(int[] houses, int[] heaters) {
        //
        Arrays.sort(houses);
        Arrays.sort(heaters);
        if (heaters.length == 1) {
            return Math.max(Math.abs(heaters[0] - houses[0]),
                    Math.abs(heaters[0] - houses[houses.length - 1]));
        }
        int i = 0;
        int j = 0;
        int radius = 0;
        while (i < houses.length) {
            int house = houses[i];
            while (j < heaters.length - 2 && house > heaters[j + 1]) {
                j++;
            }
            System.out.println(houses[i] + " " + heaters[j]);
            // heater[j] < house < heater[j+1]
            // j==len-2，house > heaters[len-1]
            radius = Math.max(radius, Math.min(Math.abs(heaters[j + 1] - house), Math.abs(heaters[j] - house)));
            i++;
        }
        return radius;
    }
}
