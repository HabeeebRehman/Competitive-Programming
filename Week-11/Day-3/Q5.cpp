#include <iostream>
using namespace std;

int main() {
    int a = 5;
    int *ptr = &a;
    cout << "Value: " << *ptr << endl;
    cout << "Address: " << ptr << endl;
    return 0;
}
