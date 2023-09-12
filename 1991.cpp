#include <iostream>
#include <vector>

using namespace std;

vector<pair<char, char>> tree(91, {'.', '.'});

void preorder(char p)
{
    if (p == '.')
        return;
    
    cout << p;
    preorder(tree[p].first);
    preorder(tree[p].second);
}

void inorder(char p)
{
    if (p == '.')
        return;

    inorder(tree[p].first);
    cout << p;
    inorder(tree[p].second);
}

void postorder(char p)
{
    if (p == '.')
        return;
    
    postorder(tree[p].first);
    postorder(tree[p].second);
    cout << p;
}

void print(char p, void (*f)(char))
{
    f(p);
    cout << "\n";
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    char p, l, r;
    int t;

    cin >> t;
    while (t--)
    {
        cin >> p >> l >> r;
        tree[p] = {l, r};
    }

    print('A', preorder);
    print('A', inorder);
    print('A', postorder);
    return 0;
}