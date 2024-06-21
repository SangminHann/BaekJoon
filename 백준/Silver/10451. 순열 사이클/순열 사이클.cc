#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int t;
    cin >> t;

    while (t--)
    {
        int cnt = 0, visited[1000] = {0,}, arr[1000], n;
        cin >> n;

        for (int i = 0; i < n; i++)
        {
            cin >> arr[i];
            arr[i]--;
        }
        
        for (int i = 0; i < n; i++)
        {
            if (!visited[i])
            {
                cnt++;
                int j = i;

                while (!visited[j])
                {
                    visited[j] = 1;
                    j = arr[j];
                }
            }
        }

        cout << cnt << "\n";
    }

    return 0;
}