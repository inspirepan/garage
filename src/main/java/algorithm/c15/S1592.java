package algorithm.c15;

public class S1592 {
    public String reorderSpaces(String text) {
        String[] words = text.trim().split("\\s+");
        int num = words.length - 1;
        int spaceCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        if (spaceCount == 0) {
            return text;
        }
        if (num == 0) {
            return words[0].concat(" ".repeat(spaceCount));
        }

        var sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
            sb.append(" ".repeat(spaceCount / num));
        }
        sb.append(" ".repeat(spaceCount % num));
        sb.setLength(text.length());
        return sb.toString();
    }
}
