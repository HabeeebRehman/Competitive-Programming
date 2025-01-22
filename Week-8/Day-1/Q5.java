public class Q5 {
    public static boolean canShip(int[] weights, int days, int capacity) {
        int currentWeight = 0, requiredDays = 1;
        for (int weight : weights) {
            if (currentWeight + weight > capacity) {
                requiredDays++;
                currentWeight = weight;
                if (requiredDays > days) return false;
            } else {
                currentWeight += weight;
            }
        }
        return true;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println("Minimum ship capacity: " + shipWithinDays(weights, days)); // Output: 15
    }
}
