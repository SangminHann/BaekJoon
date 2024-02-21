#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool comp(const pair<char, int> &a, const pair<char, int> &b)
{
    return bool(a.first < b.first);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    string key, code;
    cin >> key >> code;

    vector<pair<char, int>> keySort(key.length());
    vector<string> codePiece(key.length());
    size_t row = code.length() / key.length(), idx = 0;

    for (auto &a : codePiece)
    {
        a = code.substr(idx, row);
        idx += row;
    }

    for (int i = 0; i < (int)key.length(); i++)
    {
        keySort[i].first = key[i];
        keySort[i].second = i;
    }

    stable_sort(keySort.begin(), keySort.end(), comp);

    string tmp(key.length(), '\0');
    for (size_t i = 0; i < row; i++)
    {
        for (size_t j = 0; j < key.length(); j++)
            tmp[keySort[j].second] = codePiece[j][i];
        cout << tmp;
    }

    return 0;
}