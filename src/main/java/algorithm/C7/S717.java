package algorithm.C7;

public class S717 {
    public boolean isOneBitCharacter(int[] bits) {
        // 感觉这道题还是有点绕的，没那么简单啊
        int count = 0;
        int p = bits.length - 2;
        while (p >= 0 && bits[p] == 1) {
            p--;
            count++;
        }
        return (count & 1) == 0;
    }
}
