import java.util.*;

public class TaskScheduler {
    
    static class Task {
        int duration, deadline;
        Task(int duration, int deadline) {
            this.duration = duration;
            this.deadline = deadline;
        }
    }

    public static int maxTasks(Task[] tasks, int maxTime) {
        Arrays.sort(tasks, Comparator.comparingInt(t -> t.deadline));
        
        int n = tasks.length;
        int[] dp = new int[maxTime + 1];

        for (int i = 0; i < n; i++) {
            for (int j = maxTime; j >= tasks[i].duration; j--) {
                dp[j] = Math.max(dp[j], dp[j - tasks[i].duration] + 1);
            }
        }

        return dp[maxTime];
    }

    public static void main(String[] args) {
        Task[] tasks = {
            new Task(2, 5),
            new Task(3, 6),
            new Task(1, 3),
            new Task(2, 4)
        };
        
        System.out.println("Maximum tasks that can be completed: " + maxTasks(tasks, 6));
    }
}
