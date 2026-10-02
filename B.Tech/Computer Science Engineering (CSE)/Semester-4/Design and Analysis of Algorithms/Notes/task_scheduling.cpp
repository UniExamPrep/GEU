#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Task {
    int time;
    int deadline;
    int index;

    Task(int t, int d, int i) : time(t), deadline(d), index(i) {}
};

class TaskScheduler {
private:
    vector<Task> tasks;

public:
    void addTask(int time, int deadline, int index) {
        tasks.push_back(Task(time, deadline, index));
    }

    void scheduleTasks() {
        // Sort tasks by deadline
        sort(tasks.begin(), tasks.end(),
            [](const Task& a, const Task& b) {
                return a.deadline < b.deadline;
            });

        vector<int> selected;
        int currentTime = 0;

        for (const Task& task : tasks) {
            if (currentTime + task.time <= task.deadline) {
                selected.push_back(task.index);
                currentTime += task.time;
            }
        }

        // Print results
        cout << "Max number of tasks = " << selected.size() << endl;
        cout << "Selected task numbers : ";
        for (int i = 0; i < selected.size(); i++) {
            cout << selected[i];
            if (i < selected.size() - 1) cout << ", ";
        }
        cout << endl;
    }
};

int main() {
    int n;
    cout << "Enter number of tasks: ";
    cin >> n;

    vector<int> times(n), deadlines(n);
    
    cout << "Enter time taken by each task: ";
    for (int i = 0; i < n; i++)
        cin >> times[i];

    cout << "Enter deadlines for each task: ";
    for (int i = 0; i < n; i++)
        cin >> deadlines[i];

    TaskScheduler scheduler;
    for (int i = 0; i < n; i++)
        scheduler.addTask(times[i], deadlines[i], i+1);

    scheduler.scheduleTasks();
    return 0;
} 