#include <stdio.h>

void swap(int arr[], int low, int high);
int partition(int arr[], int low, int high);

void swap(int arr[], int low, int high) {
    int temp;
    temp = arr[low]; 
    arr[low] = arr[high]; 
    arr[high] = temp;
}

void q_sort(int arr[], int low, int high) {
    if (low >= high)
        return;

    int p = partition(arr, low, high);
    q_sort(arr, low, p - 1);
    q_sort(arr, p + 1, high);
}

int partition(int arr[], int low, int high) {
    int p = arr[low];
    int i = low;
    int j = high;

    while (i < j) {
        while (arr[i] <= p && i <= high) {
            i++;
        }

        while (arr[j] > p && j >= low) {
            j--;
        }

        if (i < j) {
            swap(arr, i, j);
        }
    }

    swap(arr, low, j);
    return j;
}


int main() {
    int arr[] = {2, 17, 4, 6, 3, 7};
    int n = sizeof(arr) / sizeof(arr[0]);
    q_sort(arr, 0, n - 1);

    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    return 0;
}