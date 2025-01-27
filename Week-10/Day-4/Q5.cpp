#include <iostream>
using namespace std;

class Sample {
public:
    Sample() {
        cout << "Constructor called" << endl;
    }
    ~Sample() {
        cout << "Destructor called" << endl;
    }
};

int main() {
    Sample obj;
    return 0;
}
