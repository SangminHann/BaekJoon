class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int[] sort = new int[rank.length], cand = new int[3];
        
        for (int i = 0; i < rank.length; i++) {
            if (attendance[i]) {
                sort[rank[i] - 1] = i;
            }
            
            else {
                sort[rank[i] - 1] = -1;
            }
        }
        
        for (int i = 0, j = 0; i < sort.length; i++) {
            if (sort[i] != -1) {
                cand[j++] = sort[i];
            }
            if (j == 3) {
                break;
            }
        }
        
        return cand[0] * 10000 + cand[1] * 100 + cand[2];
    }
}