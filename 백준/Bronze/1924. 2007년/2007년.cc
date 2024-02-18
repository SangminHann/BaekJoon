#include <iostream>

using namespace std;

int months[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int month, day, sum = -1;
    cin >> month >> day;

    for (int i = 1; i < month; i++)
        sum += months[i];
    sum += day;
    sum %= 7;
    
    switch (sum)
    {
        case 0:
            cout << "MON";
            break;
        case 1:
            cout << "TUE";
            break;
        case 2:
            cout << "WED";
            break;
        case 3:
            cout << "THU";
            break;
        case 4:
            cout << "FRI";
            break;
        case 5:
            cout << "SAT";
            break;
        case 6:
            cout << "SUN";
            break;
    }

    return 0;
}