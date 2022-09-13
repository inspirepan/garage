package algorithm.c6;

public class S670 {
    public int maximumSwap(int num) {
        // 感觉像是用单调栈
        // 8765432189999
        // 每一个位置往后找比它大最后一个最大的数（最大可能为9），如果一个位置后面没有比它大的，就再往下一个找，然后互换这两位置
        // 实际上因为给定的数字范围[0,10^8]最大也就8位，因此直接for循环On2是可以的
        String s = String.valueOf(num);
        char[] c = s.toCharArray();
        int index1 = 0;
        int index2 = 0;
        boolean founded = false;
        //
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] == '9') {
                continue;
            }
            index1 = i;
            char max = (char) (c[i] + 1);
            int k = i + 1;
            while (k < c.length) {
                if (c[k] >= max) {
                    max = c[k];
                    index2 = k;
                    founded = true;
                }
                k++;
            }
            if (founded) {
                break;
            }
        }
        if (founded) {
            char t = c[index1];
            c[index1] = c[index2];
            c[index2] = t;
        }
        return Integer.parseInt(new String(c));
    }
}
