public class Q2 {
    public static boolean isPossible(int[] pages, int students, int maxPages) {
        int allocated = 0, count = 1;
        for (int page : pages) {
            if (page > maxPages) return false;
            if (allocated + page > maxPages) {
                count++;
                allocated = page;
                if (count > students) return false;
            } else {
                allocated += page;
            }
        }
        return true;
    }

    public static int allocateBooks(int[] pages, int students) {
        int left = 0, right = 0, result = -1;
        for (int page : pages) right += page;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(pages, students, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] pages = {12, 34, 67, 90};
        int students = 2;
        System.out.println("Minimum max pages: " + allocateBooks(pages, students)); // Output: 113
    }
}
