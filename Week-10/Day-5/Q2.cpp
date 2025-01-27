#include <iostream>
#include <set>
using namespace std;

int main() {
    set<int> s = {3, 1, 4, 1, 5};
    s.insert(9);
    for (int i : s) {
        cout << i << " ";
    }
    cout << endl;
    return 0;
}
