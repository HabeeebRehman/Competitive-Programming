#include <iostream>
#include <map>
using namespace std;

int main() {
    map<string, int> mp;
    mp["apple"] = 3;
    mp["banana"] = 5;
    for (auto& pair : mp) {
        cout << pair.first << ": " << pair.second << endl;
    }
    return 0;
}
