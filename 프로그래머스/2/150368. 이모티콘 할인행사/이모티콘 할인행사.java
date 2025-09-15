class Solution {
    
    int[][] Users;
    int[] Emoticons, sum;
    int maxSum = 0, maxPlus = 0;
    
    void recursive(int d) {
        if (d == Emoticons.length) {
            int tmp = 0, cnt = 0;
            
            for (int i = 0; i < Users.length; i++) {
                if (sum[i] >= Users[i][1]) {
                    ++cnt;
                } else {
                    tmp += sum[i];
                }
            }
            
            if (maxPlus < cnt) {
                maxPlus = cnt;
                maxSum = tmp;
            } else if (maxPlus == cnt && maxSum < tmp) {
                maxSum = tmp;
            } 
            
            return ;
        }
        
        for (int i = 10; i <= 40; i += 10) {
            for (int j = 0; j < Users.length; j++) {
                if (Users[j][0] <= i) {
                    sum[j] += (Emoticons[d] * (100 - i));
                }
            }
            
            recursive(d + 1);
            
            for (int j = 0; j < Users.length; j++) {
                if (Users[j][0] <= i) {
                    sum[j] -= (Emoticons[d] * (100 - i));
                }
            }
        }
    }
    
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        for (int i = 0; i < emoticons.length; i++) {
            emoticons[i] /= 100;
        }
        
        Emoticons = emoticons;
        Users = users;
        sum = new int[users.length];
        
        recursive(0);
        
        return new int[]{maxPlus, maxSum};
    }
}


// 이모티콘 100 나누기
// 플러스 배열
// sum 배열