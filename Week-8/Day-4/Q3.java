import java.util.*;

public class Q3 {
    private TrieNode root;

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;
        List<String> suggestions;

        TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
            suggestions = new ArrayList<>();
        }
    }

    public Q3(List<String> words) {
        root = new TrieNode();
        for (String word : words) {
            insert(word);
        }
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
            if (node.suggestions.size() < 3) { // Limit suggestions to 3
                node.suggestions.add(word);
            }
        }
        node.isEndOfWord = true;
    }

    public List<String> autoComplete(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.children.get(c);
            if (node == null) return new ArrayList<>();
        }
        return node.suggestions;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "appetizer", "application", "banana", "bat", "ball");
        Q3 ac = new Q3(words);
        System.out.println(ac.autoComplete("app")); 
    }
}
