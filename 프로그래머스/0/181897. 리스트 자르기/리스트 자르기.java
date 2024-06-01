class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int num, s, e, c = 1, i = 0;
        switch(n) {
                case 1 -> {
                    num = slicer[1] + 1;
                    s = 0;
                    e = slicer[1];
                } case 2 -> {
                    num = num_list.length - slicer[0];
                    s = slicer[0];
                    e = num_list.length - 1;
                } case 3 -> {
                    num = slicer[1] - slicer[0] + 1;
                    s = slicer[0];
                    e = slicer[1];
                } default -> {
                    num = (slicer[1] - slicer[0]) / slicer[2] + 1;
                    s = slicer[0];
                    e = slicer[1];
                    c = slicer[2];
                }
        }
        int[] answer = new int[num];
        
        while (s <= e) {
            answer[i++] = num_list[s];
            s += c;
        }
        
        return answer;
    }
}