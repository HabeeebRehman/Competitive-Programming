#include <iostream>
#include <map>
using namespace std;

int main() {
    string str = "programming";
    map<char, int> freq;
    for (char c : str) {
        freq[c]++;
    }
    for (auto& pair : freq) {
        cout << pair.first << ": " << pair.second << endl;
    }
    return 0;
}
