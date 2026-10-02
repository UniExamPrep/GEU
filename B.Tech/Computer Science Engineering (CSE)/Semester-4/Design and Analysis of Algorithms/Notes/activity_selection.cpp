#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Activity {
    int start;
    int finish;
    int index;

    Activity(int s, int f, int i) : start(s), finish(f), index(i) {}
};

class ActivitySelector {
private:
    vector<Activity> activities;

public:
    void addActivity(int start, int finish, int index) {
        activities.push_back(Activity(start, finish, index));
    }

    void selectActivities() {
        // Sort activities by finish time
        sort(activities.begin(), activities.end(),
            [](const Activity& a, const Activity& b) {
                return a.finish < b.finish;
            });

        vector<int> selected;
        int lastFinish = 0;

        for (const Activity& activity : activities) {
            if (activity.start >= lastFinish) {
                selected.push_back(activity.index);
                lastFinish = activity.finish;
            }
        }

        // Print results
        cout << "No. of non-conflicting activities: " << selected.size() << endl;
        cout << "List of selected activities: ";
        for (int i = 0; i < selected.size(); i++) {
            cout << selected[i];
            if (i < selected.size() - 1) cout << ", ";
        }
        cout << endl;
    }
};

int main() {
    int n;
    cout << "Enter number of activities: ";
    cin >> n;

    vector<int> start(n), finish(n);
    
    cout << "Enter start times: ";
    for (int i = 0; i < n; i++)
        cin >> start[i];

    cout << "Enter finish times: ";
    for (int i = 0; i < n; i++)
        cin >> finish[i];

    ActivitySelector selector;
    for (int i = 0; i < n; i++)
        selector.addActivity(start[i], finish[i], i+1);

    selector.selectActivities();
    return 0;
} 