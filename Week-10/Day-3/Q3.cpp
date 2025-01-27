#include <iostream>
using namespace std;

string reverseString(string str) {
    int start = 0, end = str.length() - 1;
    while (start < end) {
        swap(str[start], str[end]);
        start++;
        end--;
    }
    return str;
}

int main() {
    string str;
    cout << "Enter a string: ";
    cin >> str;
    cout << "Reversed string: " << reverseString(str) << endl;
    return 0;
}
