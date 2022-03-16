package algorithm.C5;

public class S557 {
    public String reverseWords(String s) {
        String[] ss = s.split("\\s");
        for (int i = 0; i < ss.length; i++) {
            ss[i] = new StringBuilder(ss[i]).reverse().toString();
        }
        return String.join(" ", ss);
    }
}
