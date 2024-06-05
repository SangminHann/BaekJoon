class Solution {
    public int solution(String binomial) {
        String[] op = binomial.split(" ");
        
        return switch (op[1]) {
                case "+" -> Integer.parseInt(op[0]) + Integer.parseInt(op[2]);
                case "-" -> Integer.parseInt(op[0]) - Integer.parseInt(op[2]);
                default -> Integer.parseInt(op[0]) * Integer.parseInt(op[2]);
        };
    }
}