package algorithm.c14;

public class S1491 {
    public double average(int[] salary) {
        int max = salary[0], min = salary[0], sum = 0;
        for (int sal : salary) {
            max = Math.max(max, sal);
            min = Math.min(min, sal);
            sum += sal;
        }
        double dsum = sum - max - min;
        return dsum / (salary.length - 2);
    }
}
