public class Q3 {
    public static void main(String[] args) {
        System.out.println(countWords("Hello World!")); // 2
    }

    public static int countWords(String sentence) {
        return sentence.trim().split("\\s+").length;
    }
}
