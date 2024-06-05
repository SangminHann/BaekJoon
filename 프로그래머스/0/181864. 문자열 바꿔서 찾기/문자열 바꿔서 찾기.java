class Solution {
    public int solution(String myString, String pat) {
        
        return myString.replaceAll("A", "p")
                    .replaceAll("B", "A")
                    .replaceAll("p", "B")
                    .contains(pat) ? 1 : 0;
    }
}