import java.util.*;

public class Q3 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int platforms = 0, endIdx = 0;
        
        for (int i = 0; i < intervals.length; i++) {
            if (start[i] < end[endIdx]) {
                platforms++;
            } else {
                endIdx++;
            }
        }
        
        return platforms;
    }
}
