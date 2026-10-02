// You are provided with a vector of N integers. Then, you
// are given 2 queries. For the first query, you are provided
// with 1 integer, which denotes a position in the vector.
// The value at this position in the vector needs to be
// erased.
// The next query consists of 2 integers denoting a range of
// the positions in the vector. The elements which fall under
// that range should be removed. The second query is
// performed on the updated vector which we get after
// performing the first query.
// Input Format: The first line of the input contains an
// integer N. The next line contains N space-separated
// integers (1-based index). The third line contains a single
// integer x, denoting the position of an element that should
// be removed from the vector. The fourth line contains two
// integers a and b denoting the range that should be erased
// from the vector inclusive of a and exclusive of b.
// Output Format: Print the size of the vector in the first line
// and the elements of the vector after the two erase
// operations in the second line separated by space.
// Sample Input:
// 6
// 1 4 6 2 8 9
// 2
// 2 4
// Sample Output:
// 3
// 1 8 9

#include <iostream>
#include <vector>
using namespace std;

int main() {
    int N;
    cin >> N;

    if (N <= 0) {
        cout << "Invalid size of vector!" << endl;
        return 0;
    }

    vector<int> vec(N);

    for (int i = 0; i < N; i++) 
        cin >> vec[i];

    int x;
    cin >> x;

    // Ensure x is within valid range
    if (x >= 1 && x <= vec.size()) {
        vec.erase(vec.begin() + x - 1);
    } else {
        cout << "Invalid index for single erase!" << endl;
    }

    int a, b;
    cin >> a >> b;

    // Ensure a and b are within valid range and a < b
    if (a >= 1 && b <= vec.size() + 1 && a < b) {
        vec.erase(vec.begin() + a - 1, vec.begin() + b - 1);
    } else {
        cout << "Invalid range for erase!" << endl;
    }

    cout << vec.size() << endl;

    for (int i = 0; i < vec.size(); i++) 
        cout << vec[i] << " ";

    cout << endl;

    return 0;
}