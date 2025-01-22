import java.util.*;

public class Q5 {
    public static int scheduleTasks(List<int[]> tasks) {
        tasks.sort((a, b) -> Integer.compare(a[1], b[1]));

        int prevEnd = -1;
        int maxTasks = 0;

        for (int[] task : tasks) {
            if (task[0] >= prevEnd) {
                prevEnd = task[1];
                maxTasks++;
            }
        }

        return maxTasks;
    }

    public static void main(String[] args) {
        List<int[]> tasks = Arrays.asList(
            new int[]{1, 3}, new int[]{2, 5}, new int[]{4, 6}, new int[]{7, 9}
        );
        System.out.println("Maximum tasks scheduled: " + scheduleTasks(tasks));
    }
}
