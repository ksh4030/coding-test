import java.util.HashSet;

class Solution {
    static int answer = 0;
    static HashSet<Integer> seenNums = new HashSet<>();

    public int solution(String numbers) {
        String[] digits = numbers.split(""); 
        
        for (int i = 1; i <= numbers.length(); i++) {            
            permute(digits, new String[i], 0, new boolean[digits.length]);
        }
        
        return answer;
    }
    
    public void permute(String[] digits, String[] sel, int depth, boolean[] visited) {
        if (depth == sel.length) {
            int num = Integer.parseInt(String.join("", sel));
            if (!seenNums.contains(num)) {
                seenNums.add(num);
                if (isPrime(num)) {
                    answer++;
                }
            }
            return;
        }
        
        for (int i = 0; i < digits.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sel[depth] = digits[i];
                permute(digits, sel, depth + 1, visited);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num) {     
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
