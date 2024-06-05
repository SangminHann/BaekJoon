class Solution {
    public int solution(String myString, String pat) {
        
        return myString.replace("A", "p")
                    .replace("B", "A")
                    .replace("p", "B")
                    .contains(pat) ? 1 : 0;
    }
}