#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    string str;
    int node, t, num[21] = {0};

    cin >> t;

    while (t--)
    {
        cin >> str;

        if (str != "all" && str != "empty")
            cin >> node;

        if (str == "add")
            num[node] = 1;AA
        
        else if (str == "remove")
            num[node] = 0;

        else if (str == "check")
        {
            if (num[node])
                cout << "1\n";
            
            else
                cout << "0\n";
        }

        else if (str == "toggle")
        {
            if (num[node])
                num[node] = 0;
            
            else
                num[node] = 1;
        }

        else if (str == "all")
        {
            for (int i = 1; i < 21; i++)
                num[i] = 1;
        }

        else
        {
            for (int i = 1; i < 21; i++)
                num[i] = 0;
        }
    }

    return 0;
}