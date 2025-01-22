import java.util.*;

public class Q2 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, minLength = Integer.MAX_VALUE, minLeft = 0, required = t.length();
        
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                if (map.get(s.charAt(right)) > 0) required--;
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
            }
            right++;
            
            while (required == 0) {
                if (right - left < minLength) {
                    minLength = right - left;
                    minLeft = left;
                }
                if (map.containsKey(s.charAt(left))) {
                    if (map.get(s.charAt(left)) == 0) required++;
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                }
                left++;
            }
        }
        
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }
}
