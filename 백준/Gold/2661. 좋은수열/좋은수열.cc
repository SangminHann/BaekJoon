#include <iostream>

using namespace std;

int n;
string rst;

bool isValid()
{
    int s = rst.length() - 1;
    for (int i = 1; i < rst.length(); i++)
    {
        if(s - i < 0)
            return true;
        string subSeq1 = rst.substr(s, i);
        string subSeq2 = rst.substr(s - i, i);
        if(subSeq1 == subSeq2)
            return false;
        s--;
    }

    return true;
}

void backTracking(int idx)
{
    if (!isValid())
        return;
    
    if (idx == n)
    {
        cout << rst;
        exit(0);
    }

    for (char i = '1'; i < '4'; i++)
    {
        rst.push_back(i);
        backTracking(idx + 1);
        rst.pop_back();
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    rst = "";
    cin >> n;
    
    backTracking(0);

    return 0;
}