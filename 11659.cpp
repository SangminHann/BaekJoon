#include <iostream>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

    int arr[100000], sum[100001];
    int start, end, arrSize, t;

    cin >> arrSize >> t;
    
    for (int i = 0; i < arrSize; i++)
        cin >> arr[i];

    for (int i = 0; i < arrSize; i++)
        sum[i + 1] = arr[i] + sum[i];

    while (t--)
    {
        cin >> start >> end;
        cout << sum[end] - sum[start - 1] << '\n';
    }

    return 0;
}