#include <iostream>
using namespace std;

class BankAccount {
private:
    string name;
    double balance;
public:
    BankAccount(string n, double b) : name(n), balance(b) {}
    void deposit(double amount) {
        balance += amount;
        cout << "Deposited: " << amount << endl;
    }
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            cout << "Withdrawn: " << amount << endl;
        } else {
            cout << "Insufficient funds!" << endl;
        }
    }
    void display() {
        cout << "Account holder: " << name << ", Balance: " << balance << endl;
    }
};

int main() {
    BankAccount account("Alice", 1000);
    account.display();
    account.deposit(500);
    account.withdraw(200);
    account.display();
    return 0;
}
