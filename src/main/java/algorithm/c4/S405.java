package algorithm.c4;

public class S405 {
    public String toHex(int num) {
        StringBuilder str = new StringBuilder();
        // 不用管负数，因为Java本来用的就是补码，所以位运算的结果也是补码
        System.out.println(Integer.toBinaryString(num));
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        if (num == 0) {
            return "0";
        }
        while (num != 0) {
            str.append(map[num & 0b1111]);
            num = num >>>= 4;
            System.out.println(str);
        }
        return str.reverse().toString();
    }
}
