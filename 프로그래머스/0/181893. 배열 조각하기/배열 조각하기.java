import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        
        List<Integer> arrayList = Arrays.stream(arr)
                                         .boxed()
                                         .collect(Collectors.toCollection(ArrayList::new));
        
        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                arrayList.subList(query[i] + 1, arrayList.size()).clear();
            } else {
                arrayList.subList(0, query[i]).clear();
            }
        }
        
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }
}