class Solution {
    public String solution(String my_string, String alp) {
        char[] arr = my_string.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == alp.charAt(0)) {
                arr[i] -= ('a' - 'A');
            }
        }
        
        return new String(arr);
    }
}