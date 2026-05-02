import java.util.*;

class Solution {
    int target;

    private boolean usePair(Set<Integer> set1, Set<Integer> set2) {
        int a = -1, b = -1;

        for (int card : set1) {
            b = target - card;

            if (set2.contains(b)) {
                a = card;
                break;
            }
        }

        if (a == -1) {
            return false;
        }

        set1.remove(a);
        set2.remove(b);

        return true;
    }
    
    public int solution(int coin, int[] cards) {
        int n = cards.length, idx = 0 ,round = 1;
        target = n + 1;

        Set<Integer> hand = new HashSet<>(), draw = new HashSet<>();

        while (idx < n / 3) {
            hand.add(cards[idx++]);
        }

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
}