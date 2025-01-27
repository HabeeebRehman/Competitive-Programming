#include <iostream>
using namespace std;

int findSecondLargest(int arr[], int n) {
    int largest = arr[0], secondLargest = -1;
    for (int i = 1; i < n; i++) {
        if (arr[i] > largest) {
            secondLargest = largest;
            largest = arr[i];
        } else if (arr[i] > secondLargest && arr[i] != largest) {
            secondLargest = arr[i];
        }
    }
    return secondLargest;
}

int main() {
    int arr[] = {5, 8, 12, 20, 9};
    int n = sizeof(arr) / sizeof(arr[0]);
    cout << "Second largest: " << findSecondLargest(arr, n) << endl;
    return 0;
}
