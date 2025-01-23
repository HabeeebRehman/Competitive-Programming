import java.util.*;

public class JobScheduling {
    
    static class Job {
        int id, deadline, profit;
        Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    static int maxProfit(Job[] jobs, int n) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);  // Sort jobs by profit in descending order

        boolean[] slots = new boolean[n];
        Arrays.fill(slots, false);

        int maxProfit = 0;

        // Iterate over jobs
        for (int i = 0; i < n; i++) {
            // Find a free slot for this job (if possible)
            for (int j = Math.min(n, jobs[i].deadline) - 1; j >= 0; j--) {
                if (!slots[j]) {
                    slots[j] = true;
                    maxProfit += jobs[i].profit;
                    break;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Job[] jobs = new Job[] {
            new Job(1, 4, 20),
            new Job(2, 1, 10),
            new Job(3, 1, 40),
            new Job(4, 1, 30)
        };

        int n = jobs.length;
        System.out.println("Maximum Profit: " + maxProfit(jobs, n));
    }
}
