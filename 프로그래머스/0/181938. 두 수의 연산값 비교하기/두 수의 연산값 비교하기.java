class Solution {
    public int solution(int a, int b) {
        int answer = Integer.parseInt(Integer.toString(a) + Integer.toString(b));
        
        return (answer > (2 * a * b)) ? answer : 2 * a * b;
    }
}