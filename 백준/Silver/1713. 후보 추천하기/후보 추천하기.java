import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

    public static class Candidate implements Comparable<Candidate> {
        int n;
        int cnt;
        int date;

        public Candidate(int n, int date) {
            this.n = n;
            this.date = date;
            this.cnt = 1;
        }

        @Override
        public String toString() {
            return String.valueOf(n);
        }

        @Override
        public int compareTo(Candidate o) {
            return this.n - o.n;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int frame = Integer.parseInt(br.readLine()), num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Candidate> arr = new LinkedList<>();

        for (int i = 0; i < num; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            boolean flag = true;
                
            for (int j = 0; j < arr.size(); j++) {
                if (arr.get(j).n == tmp) {
                    arr.get(j).cnt++;
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                if (arr.size() < frame) {
                    arr.add(new Candidate(tmp, i));
                } else {
                    int idx = 0, date = 0, cnt = 1000;
                    for (int j = 0; j < frame; j++) {
                        if (arr.get(j).cnt < cnt) {
                            cnt = arr.get(j).cnt;
                            idx = j;
                            date = arr.get(j).date;
                        } else if (arr.get(j).cnt == cnt && date > arr.get(j).date) {
                            idx = j;
                            date = arr.get(j).date;
                        }
                    }

                    arr.remove(idx);
                    arr.add(new Candidate(tmp, i));
                }
            }
        }

        arr.sort(null);

        System.out.println(arr.toString()
                            .replace("[", "")
                            .replace("]", "")
                            .replace(",", "")
        );
    }
}