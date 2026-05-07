class Solution {
    
    int maxSum = 0, maxPlusUser = 0;
    int[] userSum;
    
    void recursive(int idx, int[][] users, int[] emoticons) {
        if (emoticons.length == idx) {
            int sum = 0, plusUser = 0;
            for (int i = 0; i < users.length; i++) {
                if (users[i][1] <= userSum[i]) {
                    plusUser++;
                } else {
                    sum += userSum[i];
                }
            }
            
            
            if (maxPlusUser < plusUser) {
                maxPlusUser = plusUser;
                maxSum = sum;
            } else if (maxPlusUser == plusUser && sum > maxSum) {
                maxSum = sum;
            }
            
            return;
        }
        
        for (int i = 90; i > 50; i -= 10) {
            for (int j = 0; j < users.length; j++) {
                if (users[j][0] >= i) {
                    userSum[j] += emoticons[idx] * i;
                }
            }
            
            recursive(idx + 1, users, emoticons);
            
            for (int j = 0; j < users.length; j++) {
                if (users[j][0] >= i) {
                    userSum[j] -= emoticons[idx] * i;
                }
            }
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        userSum = new int[users.length];
        
        for (int i = 0; i < users.length; i++) {
            users[i][0] = 100 - users[i][0];
        }
        
        for (int i = 0 ; i < emoticons.length; i++) {
            emoticons[i] /= 100;
        }

        recursive(0, users, emoticons);
        return new int[]{maxPlusUser, maxSum};
    }
}