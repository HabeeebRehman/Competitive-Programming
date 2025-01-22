import java.util.*;

public class Q4 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        
        Arrays.sort(jobs, (a, b) -> a.end - b.end);
        
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;
        
        for (int i = 1; i < n; i++) {
            int profitIncludingCurrentJob = jobs[i].profit;
            int l = binarySearch(jobs, i);
            if (l != -1) {
                profitIncludingCurrentJob += dp[l];
            }
            dp[i] = Math.max(profitIncludingCurrentJob, dp[i - 1]);
        }
        
        return dp[n - 1];
    }
    
    private int binarySearch(Job[] jobs, int index) {
        int low = 0, high = index - 1;
        int startTime = jobs[index].start;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (jobs[mid].end <= startTime) {
                if (jobs[mid + 1].end <= startTime) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    
    class Job {
        int start, end, profit;
        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
}
