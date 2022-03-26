package algorithm.F1;

public class S58I {
    public String reverseWords(String s) {
        s = s.trim();
        String[] ss = s.split("\\s+");
        var sb = new StringBuilder();
        for(int i = ss.length-1;i>=0;i--){
            sb.append(ss[i]);
            sb.append(" ");
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }
}
