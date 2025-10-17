import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {

    static Map<String, String[]> map = new HashMap<>();
    static StringBuilder sb;

    static void preorder(String s) {
        if (map.getOrDefault(s, null) == null) {
            return;
        }

        String[] tmp = map.get(s);
        sb.append(s);
        preorder(tmp[0]);
        preorder(tmp[1]);
    }

    static void inorder(String s) {
        if (map.getOrDefault(s, null) == null) {
            return;
        }

        String[] tmp = map.get(s);
        inorder(tmp[0]);
        sb.append(s);
        inorder(tmp[1]);
    }

    static void postorder(String s) {
        if (map.getOrDefault(s, null) == null) {
            return;
        }
        
        String[] tmp = map.get(s);
        postorder(tmp[0]);
        postorder(tmp[1]);
        sb.append(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), new String[]{st.nextToken(), st.nextToken()});
        }

        sb = new StringBuilder();
        preorder("A");
        System.out.println(sb);

        sb = new StringBuilder();
        inorder("A");
        System.out.println(sb);

        sb = new StringBuilder();
        postorder("A");
        System.out.println(sb);
    }
}