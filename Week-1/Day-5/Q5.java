import java.util.Arrays;
import java.util.HashSet;
public class Q5 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5};
        System.out.println(Arrays.toString(removeDuplicates(arr)));
    }

    public static int[] removeDuplicates(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) set.add(num);
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
