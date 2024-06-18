import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> arrList = new LinkedList<>(IntStream.of(arr)
                                                    .boxed()
                                                    .collect(Collectors.toList()));
        Set<Integer> deleteSet = IntStream.of(delete_list)
                                            .boxed()
                                            .collect(Collectors.toSet());
        Iterator<Integer> it = arrList.iterator();
        while (it.hasNext()) {
            if (deleteSet.contains(it.next())) {
                it.remove();
            }
        }
        
        return arrList.stream().mapToInt(Integer::intValue).toArray();
    }
}