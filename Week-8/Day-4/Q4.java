import java.util.*;

public class Q4 {
    public static boolean isSubstring(String s, String query) {
        List<Integer> suffixArray = buildSuffixArray(s);
        int low = 0, high = suffixArray.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String suffix = s.substring(suffixArray.get(mid));
            if (suffix.startsWith(query)) {
                return true;
            } else if (suffix.compareTo(query) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    private static List<Integer> buildSuffixArray(String s) {
        int n = s.length();
        List<Integer> suffixArray = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            suffixArray.add(i);
        }

        suffixArray.sort((i, j) -> s.substring(i).compareTo(s.substring(j)));
        return suffixArray;
    }

    public static void main(String[] args) {
        String s = "banana";
        System.out.println(isSubstring(s, "nan"));
        System.out.println(isSubstring(s, "apple"));

    }
}
