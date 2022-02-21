package algorithm.C15;

public class S1528 {
    public String restoreString(String s, int[] indices) {
        char[] result = new char[indices.length];
        char[] origin = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            result[indices[i]] = origin[i];
        }
        return new String(result);
    }
}
