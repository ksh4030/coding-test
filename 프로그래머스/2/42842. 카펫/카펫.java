class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for(int i=3; i<sum; i++) {
            if(sum % i != 0) continue;
            int n = sum/i;
            answer[0] = Math.max(i, n);
            answer[1] = Math.min(i, n);
            
            if((answer[0]-2) * (answer[1]-2) == yellow) return answer;
        }
        
        return answer;
    }
}