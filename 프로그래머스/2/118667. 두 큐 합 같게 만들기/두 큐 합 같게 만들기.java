import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Deque<Integer> dq1 = new ArrayDeque<>(), dq2 = new ArrayDeque<>();
        long sum1 = 0, sum2 = 0;
        
        for (int a : queue1) {
            dq1.addLast(a);
            sum1 += a;
        }
        
        for (int a : queue2) {
            dq2.addLast(a);
            sum2 += a;
        }
        
        if ((sum1 + sum2) % 2 == 1) {
            return -1;
        }
        
        int cnt = 0, limit = (dq1.size() + dq2.size()) * 2;
        while (!(sum1 == 0 || sum2 == 0 || sum1 == sum2 || cnt > limit)) {
            if (sum1 > sum2) {
                int tmp = dq1.pollFirst();
                sum1 -= tmp;
                sum2 += tmp;
                dq2.addLast(tmp);
            } else {
                int tmp = dq2.pollFirst();
                sum2 -= tmp;
                sum1 += tmp;
                dq1.addLast(tmp);
            }
            ++cnt;
        }
        
        return sum1 == sum2 ? cnt : -1;
    }
}