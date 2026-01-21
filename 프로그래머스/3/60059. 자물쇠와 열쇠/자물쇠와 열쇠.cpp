#include <string>
#include <vector>

using namespace std;
vector<vector<int>> turnRight(vector<vector<int>> key);
vector<vector<int>> generateNLock(int kSize, vector<vector<int>> lock);

bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
    vector<vector<int>> nLock;
	nLock = generateNLock(key.size(), lock);
	int flag = 0;
	int count = 4;
	while (count-- && !flag)
	{
		for (int i = 0; !flag && i <= (nLock.size() - key.size()); i++)
		{
			for (int j = 0; !flag && j <= (nLock.size() - key.size()); j++)
			{
				for (int k = i, n = 0; n < key.size(); k++, n++)
					for (int l = j, m = 0; m < key.size(); l++, m++)
						nLock[k][l] += key[n][m];
				flag = 1;
				for (int x = key.size() - 1; x < (lock.size() + key.size() - 1) && flag; x++)
					for (int y = key.size() - 1; y < (lock.size() + key.size() - 1) && flag; y++)
						if (nLock[x][y] != 1)
							flag = 0;
				nLock = generateNLock(key.size(), lock);
			}
		}
		key = turnRight(key);
	}

	return flag;
}
vector<vector<int>> generateNLock(int kSize, vector<vector<int>> lock)
{
	vector<vector<int>> nLock((kSize - 1) * 2 + lock.size(), vector<int>((kSize - 1) * 2 + lock.size(), 0));
	for (int i = kSize - 1, n = 0; n < lock.size(); i++, n++)
		for (int j = kSize - 1, m = 0; m < lock.size(); j++, m++)
			nLock[i][j] = lock[n][m];

	return nLock;
}

vector<vector<int>> turnRight(vector<vector<int>> key)
{
	vector<vector<int>> nKey(key[0].size(), vector<int>(key.size(), 0));
	for (int i = 0; i < nKey.size(); i++)
		for (int j = nKey[0].size() - 1; j >= 0; j--)
			nKey[i][nKey[0].size() - 1 - j] = key[j][i];
	return nKey;
}
