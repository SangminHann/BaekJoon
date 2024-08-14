class Solution {
    public boolean solution(int x) {
        int tmp = x, digitSum = 0;
        
        while (tmp != 0) {
            digitSum += tmp % 10;
            tmp /= 10;
        }
        
        return x % digitSum == 0 ? true : false;
    }
}