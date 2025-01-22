import java.util.*;

public class Q2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
            graph.putIfAbsent(pre[1], new ArrayList<>());
            graph.get(pre[1]).add(pre[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            
            if (graph.containsKey(course)) {
                for (int next : graph.get(course)) {
                    if (--indegree[next] == 0) queue.offer(next);
                }
            }
        }
        
        return count == numCourses;
    }
}
