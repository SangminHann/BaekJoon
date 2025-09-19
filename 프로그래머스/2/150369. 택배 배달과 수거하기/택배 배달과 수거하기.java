class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long dist = 0;
        int truck = 0, end = n - 1, sumD = 0, sumP = 0;

        
        
        for (int i = 0; i < n; i++) {
            sumD += deliveries[i];
            sumP += pickups[i];
        } 
        
        while (end >= 0 && deliveries[end] == 0 && pickups[end] == 0) {
                --end;
        }
        
        while (end >= 0) {
            if (sumD <= cap) { // 트럭 상차
                truck = sumD;
                sumD = 0;
            } else {
                truck = cap;
                sumD -= cap;
            }
            
            dist += (end + 1) * 2;
            
            for (int i = end; truck > 0; i--) { // 배달중
                if (truck > deliveries[i]) {
                    truck -= deliveries[i];
                    deliveries[i] = 0;
                } else {
                    deliveries[i] -= truck;
                    truck = 0;
                }
            }
            
            if (sumP <= cap) {
                truck = sumP;
                sumP = 0;
            } else {
                sumP -= cap;
                truck = cap;
            }
            
            for (int i = end; truck > 0; i--) { // 수거
                if (truck > pickups[i]) {
                    truck -= pickups[i];
                    pickups[i] = 0;
                } else {
                    pickups[i] -= truck;
                    truck = 0;
                }
            }
            
            while (end >= 0 && deliveries[end] == 0 && pickups[end] == 0) {
                --end;
            }
        }
        
        return dist;
    }
}