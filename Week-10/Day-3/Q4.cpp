#include <iostream>
using namespace std;

int stringLength(string str) {
    int length = 0;
    while (str[length] != '\0') {
        length++;
    }
    return length;
}

int main() {
    string str;
    cout << "Enter a string: ";
    cin >> str;
    cout << "String length: " << stringLength(str) << endl;
    return 0;
}
