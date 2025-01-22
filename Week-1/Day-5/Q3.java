public class Q3 {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 4, 2};
        System.out.println(findSecondLargest(arr)); // 4
    }

    public static int findSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        return secondLargest;
    }
}
