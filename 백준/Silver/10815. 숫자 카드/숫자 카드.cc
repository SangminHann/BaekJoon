#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, m;
    cin >> n;

    vector<int> card(n);
    for (auto &a : card)
        cin >> a;
    
    cin >> m;
    vector<int> candidate(m);
    for (auto &a : candidate)
        cin >> a;
    
    sort(card.begin(), card.end());
    for (auto &a : candidate)
        cout << (binary_search(card.begin(), card.end(), a)) << ' ';

    return 0;
}