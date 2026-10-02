#include <stdio.h>

// Function to swap two elements
void swap(int arr[], int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
}

// Partition function for QuickSort
int partition1(int arr[], int low, int high) {
    int pivot = arr[low]; // Pivot element
    int i = low;          // Index for smaller element
    int j = low + 1;      // Index for iteration

    // Iterate through the array
    while (j <= high) {
        if (arr[j] < pivot) {
            i++;
            swap(arr, i, j); // Swap elements
        }
        j++;
    }

    // Place the pivot in its correct position
    swap(arr, low, i);
    return i; // Return the partition index
}

// Example usage
int main() {
    int arr[] = {10, 7, 8, 9, 1, 5};
    int n = sizeof(arr) / sizeof(arr[0]);

    int pi = partition1(arr, 0, n - 1);

    printf("Partition index: %d\n", pi);
    printf("Array after partitioning: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    return 0;
}