import java.util.*;

public class Q2 {
    public static List<Integer> buildSuffixArray(String s) {
        int n = s.length();
        List<Integer> suffixes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            suffixes.add(i);
        }

        suffixes.sort((i, j) -> s.substring(i).compareTo(s.substring(j)));

        return suffixes;
    }

    public static void main(String[] args) {
        String s = "banana";
        List<Integer> suffixArray = buildSuffixArray(s);
        System.out.println("Suffix Array: " + suffixArray);
    }
}
