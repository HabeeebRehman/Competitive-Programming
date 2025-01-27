#include <iostream>
using namespace std;

class Box {
public:
    int length, width, height;
    Box() : length(0), width(0), height(0) {}
    Box(int l, int w, int h) : length(l), width(w), height(h) {}
    void display() {
        cout << "Dimensions: " << length << " x " << width << " x " << height << endl;
    }
};

int main() {
    Box box1;
    Box box2(5, 4, 3);
    box1.display();
    box2.display();
    return 0;
}
