import java.util.*;

class Solution {
    char[] ch, bf = new char[7];
	List<Integer> arr = new LinkedList<>();
	boolean[] visited;

	void permutation(int idx, int num) {
		if (idx == num) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < idx; i++) {
				sb.append(bf[i]);
			}
			arr.add(Integer.valueOf(sb.toString()));

			return ;
		}

		for (int i = 0; i < ch.length; i++) {
			if (visited[i]) {
				continue;
			}
			bf[idx] = ch[i];
			visited[i] = true;
			permutation(idx + 1, num);
			visited[i] = false;
		}
	}
    
    public int solution(String numbers) {
        ch = numbers.toCharArray();
		visited = new boolean[ch.length];

		for (int i = 1; i <= ch.length; i++) {
			permutation(0, i);
		}

		Set<Integer> set = new HashSet<>(arr);
		boolean[] prime = new boolean[Integer.parseInt(new String("1").repeat(ch.length)) * 9 + 1];
		
		prime[0] = prime[1] = true;
		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (prime[i]) {
				continue;
			}

			for (int j = i + i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}

		int cnt = 0;
		for (int i : set) {
			if (!prime[i]) {
				++cnt;
			}
		}
        
        return cnt;
    }
}