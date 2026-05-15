import java.util.*;

class Solution {
    public int solution(int N, int number) {
        Set<Integer>[] arr = new HashSet[9];

        for (int i = 1; i < 9; i++) {
            arr[i] = new HashSet<>();
        }

        for (int i = 1; i < 9; i++) {
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                tmp = tmp * 10 + N;
            }

            arr[i].add(tmp);

            for (int j = 1; j < i; j++) {
                for (int l : arr[j]) {
                    for (int r : arr[i - j]) {
                        arr[i].add(l + r);
                        arr[i].add(l - r);
                        arr[i].add(l * r);

                        if (r != 0) {
                            arr[i].add(l / r);
                        }
                    }
                }
            }

            if (arr[i].contains(number)) {
                return i;
            }
        }

        return -1;
    }
}