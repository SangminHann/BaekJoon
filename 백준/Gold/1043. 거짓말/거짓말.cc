#include <iostream>
#include <vector>

using namespace std;
#define UNION_MAX 51

class UnionFind
{
public:
	int parent[UNION_MAX];
	int truthNode;

	int find_root(int node);
	void init_parent();
	void union_root(int x, int y);
};

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	UnionFind a;
	int party, n, firstNode = 0, truthNum, tmp, cnt = 0;
	vector<int> partyNode;

	cin >> n >> party;
	cin >> truthNum;
	a.init_parent();
	for (int i = 0; i < truthNum; i++)
	{
		if (firstNode == 0)
			cin >> firstNode;
		else
		{
			cin >> tmp;
			a.union_root(firstNode, tmp);
		}
	}
	a.truthNode = a.find_root(firstNode);

	while (party--)
	{
		firstNode = 0;
		cin >> n;
		while (n--)
		{
			if (firstNode == 0)
				cin >> firstNode;
			else
			{
				cin >> tmp;
				a.union_root(firstNode, tmp);
			}
		}
		partyNode.push_back(firstNode);
	}

	if (truthNum == 0)
		cout << partyNode.size();
	else
	{
		for (int i = 0; i < partyNode.size(); i++)
			if (a.find_root(a.truthNode) != a.find_root(partyNode[i]))
				cnt++;
		cout << cnt;
	}
	return 0;
}

int UnionFind::find_root(int node)
{
	if (parent[node] == node)
		return node;
	return parent[node] = find_root(parent[node]);
}

void UnionFind::union_root(int x, int y)
{
	int parentX, parentY;

	parentX = find_root(x);
	parentY = find_root(y);

	if (parentX == parentY)
		return;
	if (parentX < parentY)
		parent[parentY] = parentX;
	else
		parent[parentX] = parentY;
}

void UnionFind::init_parent()
{
	for (int i = 0; i < UNION_MAX; i++)
		parent[i] = i;
}