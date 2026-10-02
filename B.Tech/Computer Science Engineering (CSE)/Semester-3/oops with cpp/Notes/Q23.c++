// Templates are the foundation of generic programming,
// which involves writing code in a way that is independent
// of any particular type. Write a program that can create a
// list (create a class list) of given type (int, float, char etc.)
// and perform insertion and deletion on list object.

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
template <typename T>
class List {
private:
vector<T> elements;
public:
void insert(const T& element) {
elements.push_back(element);
cout << "Inserted : " <<element<<" ";
}
void remove(const T& element) {
auto it = find(elements.begin(), elements.end(), element);
if (it != elements.end()) {
elements.erase(it);
cout<<"Removed : "<<element<<" ";
} else cout<<"Element not found : "<<element<<" ";
}
void display() const {
cout << "\nList contents: ";
for (const auto& elem : elements) cout << elem << " ";
cout<<endl;
}
};
int main() {
List<int> iList; cout<<endl;
iList.insert(10); iList.insert(20); iList.insert(30);
iList.display();
iList.remove(20);
iList.display();
List<char> cList; cout<<endl;
cList.insert('A'); cList.insert('B'); cList.insert('C');
cList.display();
cList.remove('B');
cList.display();
List<float> fList; cout<<endl;
fList.insert(1.1f); fList.insert(2.2f);fList.insert(3.3f);
fList.display();
fList.remove(2.2f);
fList.display();
return 0;
}