class Solution {
    public String solution(String myString) {
        char[] arr = myString.toCharArray();
        int i = -1;
        
        while (++i < arr.length) {
            if (arr[i] < 'l') {
                arr[i] = 'l';
            }
        }
        
        return new String(arr);
    }
}