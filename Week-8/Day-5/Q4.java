import java.util.*;

public class Q4 {
    public static List<String> scheduleTasks(List<String> tasks) {
        PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(tasks);

        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> tasks = Arrays.asList("Task1", "Task2", "Task3", "Task4");
        List<String> scheduled = scheduleTasks(tasks);
        System.out.println("Scheduled tasks: " + scheduled);
    }
}
