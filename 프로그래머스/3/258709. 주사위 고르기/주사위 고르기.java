import java.util.*;

class Solution {
    
    int[][] dice;
    int[] a, b, answer;
    boolean[] visited;
    int n, half, maxCnt;
    
    void comb(int s, int depth) {
        if (depth == half) {
            int idx = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    b[idx++] = i;
                }
            }
            
            List<Integer> aSum = new ArrayList<>(), bSum = new ArrayList<>();
            sumDice(0, 0, a, aSum);
            sumDice(0, 0, b, bSum);
            
            bSum.sort(null);
            int cnt = 0;
            for (int target : aSum) {
                cnt += lowerBound(bSum, target);
            }
            
            if (maxCnt < cnt) {
                maxCnt = cnt;
                answer = a.clone();
            }
            
            return;
        }
        
        for (int i = s; i < n; i++) {
            a[depth] = i;
            visited[i] = true;
            comb(i + 1, depth + 1);
            visited[i] = false;
        }
    }
    
    void sumDice(int depth, int sum, int[] selected, List<Integer> sumList) {
        if (depth == half) {
            sumList.add(sum);
            return;
        }
        
        for (int i = 0; i < 6; i++) {
            sumDice(depth + 1, sum + dice[selected[depth]][i], selected, sumList);
        }
    }
    
    int lowerBound(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size();
        
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (arr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    public int[] solution(int[][] dice) {
        
        this.dice = dice;
        n = dice.length;
        half = n / 2;
        maxCnt = -1;
        a = new int[half];
        b = new int[half];
        visited = new boolean[n];
        
        comb(0, 0);
        Arrays.sort(answer);
        
        for (int i = 0; i < half; i++) {
            answer[i] += 1;
        }
        return answer;
    }
    
    
}