public class Q3 {
    public static int findPeak(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int binarySearch(int[] nums, int target, int left, int right, boolean ascending) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (ascending) {
                if (nums[mid] < target) left = mid + 1;
                else right = mid - 1;
            } else {
                if (nums[mid] < target) right = mid - 1;
                else left = mid + 1;
            }
        }
        return -1;
    }

    public static int searchBitonic(int[] nums, int target) {
        int peak = findPeak(nums);
        int index = binarySearch(nums, target, 0, peak, true);
        if (index != -1) return index;
        return binarySearch(nums, target, peak + 1, nums.length - 1, false);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 8, 12, 4, 2};
        int target = 4;
        System.out.println("Index of target: " + searchBitonic(nums, target)); // Output: 4
    }
}
