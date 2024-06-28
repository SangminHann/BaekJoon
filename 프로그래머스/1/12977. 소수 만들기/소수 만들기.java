class Solution {
    
    public boolean isPrime(int tmp) {
        for (int i = 2; i <= Math.sqrt(tmp); i++) {
            if (tmp % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public int solution(int[] nums) {
        int answer = 0, tmp;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    tmp = nums[i] + nums[j] + nums[k];
                    if (isPrime(tmp)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}