#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Item {
    int weight;
    int value;
    double ratio;
    int index;

    Item(int w, int v, int i) : weight(w), value(v), index(i) {
        ratio = (double)value / weight;
    }
};

class Knapsack {
private:
    vector<Item> items;
    int capacity;

public:
    Knapsack(int cap) : capacity(cap) {}

    void addItem(int weight, int value, int index) {
        items.push_back(Item(weight, value, index));
    }

    void solve() {
        // Sort items by value/weight ratio in descending order
        sort(items.begin(), items.end(), 
            [](const Item& a, const Item& b) {
                return a.ratio > b.ratio;
            });

        double totalValue = 0;
        int remainingCapacity = capacity;
        vector<pair<int, double>> selectedItems;

        for (const Item& item : items) {
            if (remainingCapacity >= item.weight) {
                // Take the whole item
                totalValue += item.value;
                remainingCapacity -= item.weight;
                selectedItems.push_back({item.index, 1.0});
            } else {
                // Take fraction of the item
                double fraction = (double)remainingCapacity / item.weight;
                totalValue += item.value * fraction;
                selectedItems.push_back({item.index, fraction});
                break;
            }
        }

        // Print results
        cout << "Maximum value : " << totalValue << endl;
        cout << "item-weight" << endl;
        for (const auto& item : selectedItems) {
            cout << item.first << "-" << item.second << endl;
        }
    }
};

int main() {
    int n;
    cout << "Enter number of items: ";
    cin >> n;

    vector<int> weights(n), values(n);
    
    cout << "Enter weights: ";
    for (int i = 0; i < n; i++)
        cin >> weights[i];

    cout << "Enter values: ";
    for (int i = 0; i < n; i++)
        cin >> values[i];

    int capacity;
    cout << "Enter knapsack capacity: ";
    cin >> capacity;

    Knapsack knapsack(capacity);
    for (int i = 0; i < n; i++)
        knapsack.addItem(weights[i], values[i], i+1);

    knapsack.solve();
    return 0;
} 