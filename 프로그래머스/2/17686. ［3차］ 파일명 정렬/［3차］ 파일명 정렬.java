import java.util.*;
import java.io.*;

class Solution {
    
    class Node implements Comparable<Node> {
        String head;
        int num;
        int idx;
        
        public Node(String s, int num, int idx) {
            this.head = s.toLowerCase();
            this.num = num;
            this.idx = idx;
        }
        
        public int compareTo(Node o) {
            if (this.head.equals(o.head)) {
                if (this.num == o.num) {
                    return this.idx - o.idx;
                }
                return this.num - o.num;
            }
            return this.head.compareTo(o.head);
        }
    }
    
    public String[] solution(String[] files) {
        
        List<Node> arr = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            int startIdx = 0;
            
            while (!('0' <= files[i].charAt(startIdx) && files[i].charAt(startIdx) <= '9')) {
                startIdx++;
            }
            
            int endIdx = startIdx;
            while (endIdx < files[i].length() && ('0' <= files[i].charAt(endIdx) && files[i].charAt(endIdx) <= '9')) {
                endIdx++;
            }
            
            arr.add(new Node(
                    files[i].substring(0, startIdx), 
                    Integer.parseInt(files[i].substring(startIdx, endIdx)),
                    i
                )
            );
        }
        
        arr.sort(null);
        
        String[] answer = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            Node n = arr.get(i);
            answer[i] = files[n.idx];
        }
        
        
        return answer;
    }
}