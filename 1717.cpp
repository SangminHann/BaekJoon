#include <iostream>
#define UNION_MAX 1000001
using namespace std;

class UnionFind
{
public:
	int parent[UNION_MAX];

	int find_root(int node);
	void init_parent();			   // 부모노드를 각각의 노드들로 초기화
	void union_root(int x, int y); // 집합 합치기
	void check_root(int x, int y);
};

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	UnionFind rst;
	int n, m, op, x, y;

	cin >> n >> m;
	rst.init_parent();

	while (m--)
	{
		cin >> op >> x >> y;
		if (op)
			rst.check_root(x, y);
		else
			rst.union_root(x, y);
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
	parent[parentX] = parentY;
}

void UnionFind::check_root(int x, int y)
{
	int parentX, parentY;

	parentX = find_root(x);
	parentY = find_root(y);

	if (parentX == parentY)
		cout << "YES" << '\n';
	else
		cout << "NO" << '\n';
}

void UnionFind::init_parent()
{
	for (int i = 0; i < UNION_MAX; i++)
		parent[i] = i;
}
