class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n], a = {{0, 0}, {0, n - 1}, {n - 1, n - 1}, {n - 1, 0}};
        int[] d = {0, 1, 2, 3};
        boolean flag = false;
        
        for (int i = 1; i <= n * n; ) {
            for (int j = 0; j < 4 && i <= n * n; j++) {
                if (d[j] == 0) {
                    flag = false;
                    for (int k = a[0][1]; k < a[1][1]; k++) {
                        answer[a[0][0]][k] = i++;
                        flag = true;
                    }
                    if (flag)
                        a[0][0]++; a[0][1]++;
                } else if (d[j] == 1) {
                    flag = false;
                    for (int k = a[1][0]; k < a[2][0]; k++) {
                        answer[k][a[1][1]] = i++;
                        flag = true;
                    }
                    if (flag)
                        a[1][1]--; a[1][0]++;
                } else if (d[j] == 2) {
                    flag = false;
                    for (int k = a[2][1]; k > a[3][1]; k--) {
                        answer[a[2][0]][k] = i++;
                        flag = true;
                    }
                    if (flag)
                        a[2][0]--; a[2][1]--;
                } else {
                    flag = false;
                    for (int k = a[3][0]; k >= a[0][0]; k--) {
                        answer[k][a[3][1]] = i++;
                        flag = true;
                    }
                    if (flag)
                        a[3][0]--; a[3][1]++;
                }

            }
        }
        
        return answer;
    }
}