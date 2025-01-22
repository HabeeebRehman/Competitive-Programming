import java.util.Arrays;

public class Q4 {
    public static boolean isPossible(int[] stalls, int cows, int minDistance) {
        int count = 1, lastPosition = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= minDistance) {
                count++;
                lastPosition = stalls[i];
                if (count == cows) return true;
            }
        }
        return false;
    }

    public static int aggressiveCows(int[] stalls, int cows) {
        Arrays.sort(stalls);
        int left = 1, right = stalls[stalls.length - 1] - stalls[0];
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(stalls, cows, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] stalls = {1, 2, 8, 4, 9};
        int cows = 3;
        System.out.println("Maximum minimum distance: " + aggressiveCows(stalls, cows));
    }
}
