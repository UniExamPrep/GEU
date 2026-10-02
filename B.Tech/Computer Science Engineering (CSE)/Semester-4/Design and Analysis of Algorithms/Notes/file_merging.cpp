#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class FileMerger {
private:
    priority_queue<int, vector<int>, greater<int>> minHeap;

public:
    void addFile(int size) {
        minHeap.push(size);
    }

    int getMinComputationCost() {
        int totalCost = 0;

        // Keep merging the two smallest files until only one remains
        while (minHeap.size() > 1) {
            int file1 = minHeap.top(); minHeap.pop();
            int file2 = minHeap.top(); minHeap.pop();
            
            int mergeCost = file1 + file2;
            totalCost += mergeCost;
            
            minHeap.push(mergeCost);
        }

        return totalCost;
    }
};

int main() {
    int n;
    cout << "Enter number of files: ";
    cin >> n;

    FileMerger merger;
    
    cout << "Enter file sizes: ";
    for (int i = 0; i < n; i++) {
        int size;
        cin >> size;
        merger.addFile(size);
    }

    cout << merger.getMinComputationCost() << endl;
    return 0;
} 