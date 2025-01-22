import java.util.*;

public class Q5 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] input1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(input1));

        String[] input2 = {""};
        System.out.println(groupAnagrams(input2));

        String[] input3 = {"a"};
        System.out.println(groupAnagrams(input3));
    }
}
