public class Q4 {
    public static void main(String[] args) {
        System.out.println(replaceSpaces("Java is fun")); // "Java-is-fun"
    }

    public static String replaceSpaces(String str) {
        return str.replace(" ", "-");
    }
}
