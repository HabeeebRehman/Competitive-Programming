#include <iostream>
using namespace std;

bool isPalindrome(string str) {
    int start = 0, end = str.length() - 1;
    while (start < end) {
        if (str[start] != str[end]) return false;
        start++;
        end--;
    }
    return true;
}

int main() {
    string str;
    cout << "Enter a string: ";
    cin >> str;
    cout << (isPalindrome(str) ? "Palindrome" : "Not Palindrome") << endl;
    return 0;
}
