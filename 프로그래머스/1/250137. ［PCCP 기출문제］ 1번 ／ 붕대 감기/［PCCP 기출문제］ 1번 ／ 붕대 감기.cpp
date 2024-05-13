#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<int> bandage, int health, vector<vector<int>> attacks)
{
    int s = 1, time, curHealth = health;
    
    for (auto &a : attacks)
    {
        time = a[0] - s;
        curHealth += (time / bandage[0]) * (bandage[2] + bandage[1] * bandage[0]) + (time % bandage[0]) * bandage[1];
        if (curHealth > health)
            curHealth = health;
        
        curHealth -= a[1];
        if (curHealth <= 0)
            return -1;
        
        s = a[0] + 1;
    }
    
    return curHealth;
}