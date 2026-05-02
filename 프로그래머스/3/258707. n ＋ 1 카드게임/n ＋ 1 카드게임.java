import java.util.*;

class Solution {
    static int target;

    public int solution(int coin, int[] cards) {
        int n = cards.length;
        target = n + 1;

        Set<Integer> hand = new HashSet<>();
        Set<Integer> draw = new HashSet<>();

        int idx = 0;

        for (int i = 0; i < n / 3; i++) {
            hand.add(cards[idx++]);
        }

        int round = 1;

        while (idx < n) {
            draw.add(cards[idx++]);
            draw.add(cards[idx++]);

            if (usePair(hand, hand)) {
                round++;
            } else if (coin >= 1 && usePair(hand, draw)) {
                coin--;
                round++;
            } else if (coin >= 2 && usePair(draw, draw)) {
                coin -= 2;
                round++;
            } else {
                break;
            }
        }

        return round;
    }

    private boolean usePair(Set<Integer> set1, Set<Integer> set2) {
        int removeA = -1;
        int removeB = -1;

        for (int card : set1) {
            int pair = target - card;

            if (set2.contains(pair)) {
                removeA = card;
                removeB = pair;
                break;
            }
        }

        if (removeA == -1) {
            return false;
        }

        set1.remove(removeA);
        set2.remove(removeB);

        return true;
    }
}