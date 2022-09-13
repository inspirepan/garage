package algorithm.c4;

public class S476 {
    public int findComplement(int num) {
        int result = 0;
        int index = 0;
        while (num > 0) {
            result = result | (((num & 1) == 1 ? 0 : 1) << index++);
            num >>>= 1;
            System.out.println(Integer.toBinaryString(num) + "  " + Integer.toBinaryString(result));
        }
        return result;
    }
}
